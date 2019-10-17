package com.mycafe.mycafe_api.service.customerService.ServiceImpl;


import com.boot.mycafe.cafe.Service.Value.WalletType;
import com.mycafe.mycafe_api.config.MyDateTime;
import com.mycafe.mycafe_api.exception.ErrorCode;
import com.mycafe.mycafe_api.exception.WalletException;
import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import com.mycafe.mycafe_api.model.canteenmodel.Wallet;
import com.mycafe.mycafe_api.model.loginmodel.User;
import com.mycafe.mycafe_api.repository.customerRepository.WalletRepository;
import com.mycafe.mycafe_api.service.customerService.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WalletServiceImpl implements IWalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletHistoryServiceImpl historyService;

    @Autowired
    private MyDateTime myDateTime;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = WalletException.class)
    public ResponseEntity<Boolean> createNewWallet(Wallet wallet) throws WalletException {
        Wallet savedWallet = walletRepository.save(wallet);
        walletRepository.flush();

        if (savedWallet==null){
            throw new WalletException("Wallet Creation Error", ErrorCode.InternalServerError.getCode());
        }else {
            Payment payment=new Payment();
            payment.setAmount(0);
            payment.setPay_id(0);
            if (!historyService.addNewWalletHistory(savedWallet,payment,WalletType.NEW)){
                throw new WalletException("Wallet History Creation Error", ErrorCode.InternalServerError.getCode());
            }else{
                return new ResponseEntity<Boolean>(true,HttpStatus.OK);
            }
        }
    }

    @Override
    public  ResponseEntity<Float> getCurrentBalance(User user) throws WalletException {
        Wallet byAuthUserRole = walletRepository.getWalletByAuthUserRole(user.getId());

        if (byAuthUserRole==null){
            throw new WalletException(String.format("Wallet is not found with auth_user_id : '%s'", user.getId()),ErrorCode.NotFound.getCode());
        }
        return new ResponseEntity<Float>(byAuthUserRole.getBalance(), HttpStatus.OK);
    }

    @Override
    public  ResponseEntity<List<Wallet>> findAllWallets() throws WalletException {
        List<Wallet> allWallets = walletRepository.findAll();
        return new ResponseEntity(allWallets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Wallet> isWalletExists(int walletId) throws WalletException {
        Wallet selectedWallet = walletRepository.getOne(walletId);
        if(selectedWallet==null){
            throw new WalletException(String.format("Wallet is not found with auth_user_id : '%s'",walletId),ErrorCode.NotFound.getCode());
        }
        return new ResponseEntity<Wallet>(selectedWallet, HttpStatus.OK);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = WalletException.class)
    public ResponseEntity<Boolean> rechargeAndPaymentWallet(User user, Payment payment, WalletType walletType) throws WalletException {
        Wallet byAuthUserRole = walletRepository.getWalletByAuthUserRole(user.getId());

        if (byAuthUserRole==null){
            throw new WalletException(String.format("Wallet is not found with auth_user_id : '%s'", user.getId()),ErrorCode.NotFound.getCode());
        }
        int wallet_id=byAuthUserRole.getWallet_id();
        String date=myDateTime.getCurrentDate().getDate();

        Wallet updatedWallet;

        if(walletType==WalletType.PAYMENT) {
            if (byAuthUserRole.getBalance() <= 40 && byAuthUserRole.getBalance() == 0) {
                throw new WalletException("Wallet has not sufficient credit", ErrorCode.BadRequest.getCode());
            } else {
                float newBalance = byAuthUserRole.getBalance() - payment.getAmount();
                updatedWallet = new Wallet(wallet_id, user, date, newBalance);
            }

        }else if(walletType==WalletType.RECHARGE) {
            float recharge = payment.getAmount();
            float newBalance = recharge + byAuthUserRole.getBalance();
            updatedWallet = new Wallet(wallet_id, user, date, newBalance);
        }else{
            throw new WalletException("Wallet type error", ErrorCode.BadRequest.getCode());
        }

            int isRecharge = walletRepository.rechargeWallet(updatedWallet.getWallet_id(), date, updatedWallet.getBalance());
            if(isRecharge==0){
                boolean isAdd = historyService.addNewWalletHistory(byAuthUserRole,payment,walletType);
                if (isAdd){
                    return new ResponseEntity<Boolean>(true,HttpStatus.OK);
                }else throw new WalletException("Wallet history insertion error", ErrorCode.InternalServerError.getCode());
            }else {
                throw new WalletException("Wallet recharge error",ErrorCode.InternalServerError.getCode());
            }
        }



    @Override
    public ResponseEntity<Boolean> deletewallet(User user) throws WalletException {
        Wallet byAuthUserRole = walletRepository.getWalletByAuthUserRole(user.getId());

        if (byAuthUserRole==null){
            throw new WalletException(String.format("Wallet is not found with auth_user_id : '%s'", user.getId()),ErrorCode.NotFound.getCode());
        }else{
            walletRepository.deleteById(byAuthUserRole.getWallet_id());
        }

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}

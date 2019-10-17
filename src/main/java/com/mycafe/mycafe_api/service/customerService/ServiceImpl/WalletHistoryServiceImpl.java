package com.mycafe.mycafe_api.service.customerService.ServiceImpl;


import com.boot.mycafe.cafe.Service.Value.WalletType;
import com.mycafe.mycafe_api.config.MyDateTime;
import com.mycafe.mycafe_api.exception.ErrorCode;
import com.mycafe.mycafe_api.exception.WalletException;
import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import com.mycafe.mycafe_api.model.canteenmodel.Wallet;
import com.mycafe.mycafe_api.model.canteenmodel.WalletHistory;
import com.mycafe.mycafe_api.repository.customerRepository.WalletHistoryRepository;
import com.mycafe.mycafe_api.service.customerService.IWalletHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletHistoryServiceImpl implements IWalletHistoryService {

    @Autowired
    private WalletHistoryRepository historyRepository;

    @Autowired
    private MyDateTime myDateTime;

    /*this method call when
    create new account
    add new order payment
    recharge wallet account
    **pay_id will be null when create new account*/
    @Override
    public boolean addNewWalletHistory(Wallet wallet, Payment payment, WalletType walletType) throws WalletException {

        int isInsert = historyRepository.insertWalletRecord(wallet.getWallet_id(),payment.getPay_id(), wallet.getBalance(), walletType, myDateTime.getCurrentDate().getDate(), myDateTime.getCurrentDate().getTime());
        if (isInsert==0){
            throw new WalletException("Wallet History Creation Error", ErrorCode.InternalServerError.getCode());
        }else {
            return true;
        }
    }

    @Override
    public ResponseEntity<List<WalletHistory>> getWalletHistoryByWalletId(int walletId) throws WalletException {

        return null;
    }

    @Override
    public ResponseEntity<List<WalletHistory>> getWalletHistoryByWalletIdDate(int walletId, String date) throws WalletException {
        return null;
    }
}
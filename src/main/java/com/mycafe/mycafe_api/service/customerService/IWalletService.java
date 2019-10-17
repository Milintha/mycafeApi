package com.mycafe.mycafe_api.service.customerService;


import com.boot.mycafe.cafe.Service.Value.WalletType;
import com.mycafe.mycafe_api.exception.WalletException;
import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import com.mycafe.mycafe_api.model.canteenmodel.Wallet;
import com.mycafe.mycafe_api.model.loginmodel.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IWalletService {

    /*ok*/
    public ResponseEntity<Boolean> createNewWallet(Wallet wallet) throws WalletException;

    /*ok*/
    public ResponseEntity<Float> getCurrentBalance(User user) throws WalletException;

    /*ok*/
    public ResponseEntity<List<Wallet>> findAllWallets()throws  WalletException;

    public ResponseEntity<Wallet> isWalletExists(int walletId) throws WalletException;

    public ResponseEntity<Boolean> rechargeAndPaymentWallet(User user, Payment payment, WalletType walletType) throws WalletException;

    public ResponseEntity<Boolean> deletewallet(User user) throws WalletException;


}

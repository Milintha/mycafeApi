package com.mycafe.mycafe_api.service.customerService;


import com.boot.mycafe.cafe.Service.Value.WalletType;
import com.mycafe.mycafe_api.exception.WalletException;
import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import com.mycafe.mycafe_api.model.canteenmodel.Wallet;
import com.mycafe.mycafe_api.model.canteenmodel.WalletHistory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IWalletHistoryService {

    public boolean addNewWalletHistory(Wallet wallet, Payment payment, WalletType walletType) throws WalletException;

    public ResponseEntity< List<WalletHistory>> getWalletHistoryByWalletId(int walletId) throws WalletException;

    public ResponseEntity< List<WalletHistory>> getWalletHistoryByWalletIdDate(int walletId,String date) throws WalletException;


}

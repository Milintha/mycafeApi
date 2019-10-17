package com.mycafe.mycafe_api.service.customerService.ServiceImpl;


import com.boot.mycafe.cafe.Service.Value.WalletType;
import com.mycafe.mycafe_api.exception.ErrorCode;
import com.mycafe.mycafe_api.exception.PaymentException;
import com.mycafe.mycafe_api.exception.WalletException;
import com.mycafe.mycafe_api.model.canteenmodel.Payment;
import com.mycafe.mycafe_api.model.loginmodel.User;
import com.mycafe.mycafe_api.repository.customerRepository.PaymentRepository;
import com.mycafe.mycafe_api.service.customerService.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService
{
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private WalletServiceImpl walletService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = PaymentException.class)
    public ResponseEntity<Boolean>  insertPayment(User user, Payment payment) throws PaymentException,WalletException {
        Payment save = paymentRepository.save(payment);
        paymentRepository.flush();
        //wallet rechargeAndpayment

        if(save==null){
            throw new PaymentException("Payment insertion error", ErrorCode.InternalServerError.getCode());
        }else{
            //AuthUserRole userRole, Payment payment, WalletType walletType //recharge /payment
            if(payment.getPaymentMethod().getMethod_desc()=="wallet"){
                 return walletService.rechargeAndPaymentWallet(user, payment, WalletType.PAYMENT);
            }else if(payment.getPaymentMethod().getMethod_desc()=="recharge"){
                return walletService.rechargeAndPaymentWallet(user,payment, WalletType.RECHARGE);
            }else if(payment.getPaymentMethod().getMethod_desc()=="card"){
                return null;
                /** this for card payment repository **/
                /*** card payment method***/
            }else{
                throw new WalletException("Error in wallet payment in insert payment",ErrorCode.InternalServerError.getCode());
            }
        }
    }

    @Override
    public ResponseEntity<List<Payment>> getAllPaymentsByDate(String date) throws PaymentException, WalletException {
        List<Payment> paymentsByDate = paymentRepository.findPaymentsByDate(date);
        if(paymentsByDate==null){
            throw new PaymentException(String.format("Not found any transaction for %s",date),ErrorCode.NotFound.getCode());
        }

        return new ResponseEntity<List<Payment>>(paymentsByDate, HttpStatus.OK);
    }

    @Override
    public ResponseEntity< List<Payment>> getAllPaymentsBetweenDates(String date1,String date2)throws PaymentException,WalletException {
        List<Payment> paymentsByDate = paymentRepository.findPaymentsByDateBetween(date1,date2);
        if(paymentsByDate==null){
            throw new PaymentException(String.format("Not found any transaction between %s & %s",date1,date2),ErrorCode.NotFound.getCode());
        }

        return new ResponseEntity<List<Payment>>(paymentsByDate, HttpStatus.OK);
    }
}

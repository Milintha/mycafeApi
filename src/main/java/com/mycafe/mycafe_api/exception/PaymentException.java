package com.mycafe.mycafe_api.exception;

public class PaymentException extends Exception{
    private int errorCode;


    public PaymentException(){
        super();
    }

    public PaymentException(String message, int errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public PaymentException(String message){
        super(message);
    }

    public PaymentException(Exception e){
        super(e);
    }

}

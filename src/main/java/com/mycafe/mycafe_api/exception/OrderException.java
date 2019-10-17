package com.mycafe.mycafe_api.exception;

public class OrderException extends Exception {

    private int errorCode;

    public int getErrorCode() {
        return errorCode;
    }

    public OrderException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public OrderException(){
        super();
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public OrderException(String message){
        super(message);
    }

    public OrderException(Exception e){
        super(e);
    }
}

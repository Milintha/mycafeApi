package com.mycafe.mycafe_api.exception;

public class WalletException extends Exception {
    private int errorCode;


    public WalletException(){
        super();
    }

    public WalletException(String message, int errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public WalletException(String message){
        super(message);
    }

    public WalletException(Exception e){
        super(e);
    }

}

//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = WalletException.class)
//throw error
// throw new WalletException(error, ErrorCode.BadRequest.getCode());
//
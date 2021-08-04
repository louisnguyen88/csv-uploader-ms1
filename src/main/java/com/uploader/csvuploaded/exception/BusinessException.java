package com.uploader.csvuploaded.exception;

/**
 * Business Exception, this exception will be throw when we got any exception related to business
 */
public class BusinessException extends RuntimeException {

    private String errorCode = "";

    public BusinessException() {}

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
    }

    public BusinessException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BusinessException(String errorCode, String msg, Throwable e) {
        super(msg, e);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

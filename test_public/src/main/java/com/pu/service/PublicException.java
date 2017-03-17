package com.pu.service;

/**
 * createtime：2017/3/16/01615:39
 * author：xiaozhuangping
 * purpose：
 */
public class PublicException extends Exception {

    private String code;

    public PublicException(String message){

        super(message);
    }

    public PublicException(String code, String message){
        super(message);
        this.code = code;
    }

    public PublicException(String code, String message, Throwable cause){
        super(message,cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}

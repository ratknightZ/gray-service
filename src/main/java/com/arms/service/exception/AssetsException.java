package com.arms.service.exception;


import com.arms.common.exception.BizException;

public class AssetsException extends BizException {

    /**  */
    private static final long serialVersionUID = 1L;

    public AssetsException(String msg) {
        super(msg);
    }

    public AssetsException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

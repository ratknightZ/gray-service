package com.arms.service.exception;

import com.arms.common.exception.BizException;

public class AppPushException extends BizException {

    /**  */
    private static final long serialVersionUID = 1L;

    public AppPushException(String msg) {
        super(msg);
    }

    public AppPushException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

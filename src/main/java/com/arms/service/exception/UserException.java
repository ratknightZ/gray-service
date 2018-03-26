package com.arms.service.exception;

import com.arms.common.exception.BizException;

public class UserException extends BizException {

    public UserException(String msg) {
        super(msg);
    }

    public UserException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

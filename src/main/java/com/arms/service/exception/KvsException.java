package com.arms.service.exception;

import com.arms.common.exception.BizException;

public class KvsException extends BizException {

    /**  */
    private static final long serialVersionUID = 1L;

    public KvsException(String msg) {
        super(msg);
    }

    public KvsException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

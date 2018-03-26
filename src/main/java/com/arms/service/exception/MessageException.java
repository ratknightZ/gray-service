package com.arms.service.exception;

import com.arms.common.exception.BizException;

/**
 * @author jinxuan
 * @since 2017/11/22
 */
public class MessageException extends BizException {

    /**  */
    private static final long serialVersionUID = 1L;

    public MessageException(String msg) {
        super(msg);
    }

    public MessageException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

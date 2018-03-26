package com.arms.service.exception;

import com.arms.common.exception.BizException;

/**
 * @author jinxuan
 * @since 2017/12/5
 */
public class GetuiException extends BizException {

    /**  */
    private static final long serialVersionUID = 1L;

    public GetuiException(String msg) {
        super(msg);
    }

    public GetuiException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

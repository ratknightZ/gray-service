package com.arms.service.exception;

import com.arms.common.exception.BizException;

/**
 * @author jinxuan
 * @since 2017/11/22
 */
public class BannerException extends BizException {

    /**  */
    private static final long serialVersionUID = 1L;

    public BannerException(String msg) {
        super(msg);
    }

    public BannerException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

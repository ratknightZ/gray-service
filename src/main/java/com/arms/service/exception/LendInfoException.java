package com.arms.service.exception;

import com.arms.common.exception.BizException;

/**
 * @author liuchen
 * @since 2017/12/7
 */
public class LendInfoException extends BizException {

    public LendInfoException(String msg) {
        super(msg);
    }

    public LendInfoException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

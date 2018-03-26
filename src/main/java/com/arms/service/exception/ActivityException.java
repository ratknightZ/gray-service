package com.arms.service.exception;

import com.arms.common.exception.BizException;

/**
 * Created by Administrator on 2017/11/26.
 */
public class ActivityException extends BizException {

    public ActivityException(String msg) {
        super(msg);
    }

    public ActivityException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

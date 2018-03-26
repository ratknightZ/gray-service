package com.arms.service.exception;

import com.arms.common.exception.BizException;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public class TerraceException extends BizException {

    public TerraceException(String msg) {
        super(msg);
    }

    public TerraceException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

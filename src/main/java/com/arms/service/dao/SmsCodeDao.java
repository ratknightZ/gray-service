package com.arms.service.dao;

import java.util.List;

import com.arms.service.model.SmsCode;

/**
 * Created by zhangchaojie on 2017/4/12.
 */
public interface SmsCodeDao {

    int insert(SmsCode smsCode);

    int update(SmsCode smsCode);

    SmsCode select(int id);

    List<SmsCode> selectByCellphone(String cellphone);

    SmsCode selectLast(String cellphone);

}

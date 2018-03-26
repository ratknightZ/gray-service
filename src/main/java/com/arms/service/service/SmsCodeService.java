package com.arms.service.service;

import java.util.List;

import com.arms.service.model.SmsCode;

/**
 * Created by zhangchaojie on 2017/4/12.
 */
public interface SmsCodeService {

    void add(SmsCode smsCode);

    void update(SmsCode smsCode);

    SmsCode get(int id);

    List<SmsCode> get(String cellphone);

    SmsCode getLast(String cellphone);

    boolean check(String cellphone, String smsCode);

    //    boolean checkAvailable(SmsCode smsCode);

}

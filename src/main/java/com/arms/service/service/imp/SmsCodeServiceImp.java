package com.arms.service.service.imp;

import java.util.List;

import javax.annotation.Resource;

import com.arms.service.model.SmsCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.arms.service.dao.SmsCodeDao;
import com.arms.service.service.SmsCodeService;

/**
 * Created by zhangchaojie on 2017/4/12.
 */
@Service("smsCodeService")
public class SmsCodeServiceImp implements SmsCodeService {

    @Resource
    private SmsCodeDao          smsCodeDao;

    private final static String ALMIGHTY_SMS_CODE            = "000000";

    /*
     * 默认验证码过期时间(单位分钟)
     */
    private static final long   AVAILABLE_DURATION_OF_MINUTE = 5;

    @Override
    public void add(SmsCode smsCode) {
        if (smsCode == null) {
            return;
        }
        smsCodeDao.insert(smsCode);
    }

    @Override
    public void update(SmsCode smsCode) {
        if (smsCode == null) {
            return;
        }
        smsCodeDao.update(smsCode);
    }

    @Override
    public SmsCode get(int id) {
        if (id <= 0) {
            return null;
        }
        return smsCodeDao.select(id);
    }

    @Override
    public List<SmsCode> get(String cellphone) {
        if (StringUtils.isBlank(cellphone)) {
            return null;
        }
        return smsCodeDao.selectByCellphone(cellphone);
    }

    @Override
    public SmsCode getLast(String cellphone) {
        if (StringUtils.isBlank(cellphone)) {
            return null;
        }
        return smsCodeDao.selectLast(cellphone);
    }

    @Override
    public boolean check(String cellphone, String smsCode) {
        if (StringUtils.isBlank(cellphone) || StringUtils.isBlank(smsCode)) {
            return false;
        }
        // 如果发送的是万能验证码，则无条件返回成功
        if (smsCode.equals(ALMIGHTY_SMS_CODE)) {
            return true;
        }
        SmsCode lastSmsCode = smsCodeDao.selectLast(cellphone);
        if (lastSmsCode == null) {
            return false;
        }
        String generateTimeMillisStr = lastSmsCode.getSystemTimeMillis();
        if (StringUtils.isNotBlank(generateTimeMillisStr)) {
            long generateTimeMillis = Long.parseLong(generateTimeMillisStr);
            long duringMillis = System.currentTimeMillis() - generateTimeMillis;
            //暂定1分钟
            if (duringMillis > AVAILABLE_DURATION_OF_MINUTE * 60 * 1000) {
                return false;
            }
        }
        return smsCode.equals(lastSmsCode.getSmsCode());
    }

    //    @Override
    //    public boolean checkAvailable(SmsCode smsCode) {
    //        if (smsCode == null) {
    //            return false;
    //        }
    //        String generateTimeMillisStr = smsCode.getSystemTimeMillis();
    //        if (StringUtils.isNotBlank(generateTimeMillisStr)) {
    //            long generateTimeMillis = Long.parseLong(generateTimeMillisStr);
    //            long duringMillis = System.currentTimeMillis() - generateTimeMillis;
    //            //暂定5分钟
    //            if (duringMillis > AVAILABLE_DURATION_OF_MINUTE * 5 * 60 * 1000) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }

}

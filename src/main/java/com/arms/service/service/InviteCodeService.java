package com.arms.service.service;

/**
 * Created by Administrator on 2017/11/26.
 */
public interface InviteCodeService {

    String getInviteCode(int userId);

    int getUserId(String inviteCode);
}

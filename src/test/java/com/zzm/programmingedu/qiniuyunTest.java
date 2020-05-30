package com.zzm.programmingedu;


import com.zzm.util.QiNiuYunUtil;
import org.junit.jupiter.api.Test;


class qiniuyunTest {

    @Test
    public void getTokenTest(){
        String token = QiNiuYunUtil.getToken();
        System.out.println(token);
    }
}

package com.huwenkang.reggie.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 发送邮箱验证码
 */
public class SendEmail {

    public void sendEmail() {
        HtmlEmail send = new HtmlEmail();//创建一个HtmlEmail实例对象
        // 获取随机验证码
        String resultCode = "111";
        try {
            send.setHostName("smtp.qq.com");
            send.setAuthentication("XXX@qq.com", "XXX"); //第一个参数是发送者的QQEamil邮箱   第二个参数是刚刚获取的授权码

            send.setFrom("XXX@qq.com", "orison有限公司");//发送人的邮箱为自己的，用户名可以随便填  记得是自己的邮箱不是qq
//			send.setSmtpPort(465); 	//端口号 可以不开
            send.setSSLOnConnect(true); //开启SSL加密
            send.setCharset("utf-8");
            send.addTo("XXX@qq.com");  //设置收件人    email为你要发送给谁的邮箱账户
            send.setSubject("测试测试"); //邮箱标题
            send.setMsg("HelloWorld!<font color='red'>您的验证码:</font>   " + resultCode + " ，五分钟后失效"); //Eamil发送的内容
            send.send();  //发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}

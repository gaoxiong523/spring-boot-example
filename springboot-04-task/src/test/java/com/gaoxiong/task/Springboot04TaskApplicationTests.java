package com.gaoxiong.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    String username;

    @Test
    public void contextLoads () {
    }

    @Test
    public void test(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //主题
        simpleMailMessage.setSubject("我又来测试邮件了");
        //内容
        simpleMailMessage.setText("我又来测试邮件了");
        //发件人
//        simpleMailMessage.setFrom("2200506725@qq.com");
        simpleMailMessage.setFrom(username);
        //收件人
        simpleMailMessage.setTo("gaoxiong5233@163.com");
        javaMailSender.send(simpleMailMessage);
//        javaMailSender.send();
    }

    @Test
    public void test2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(username);
        helper.setTo("200506725@qq.com");
        helper.setSubject("带附件的邮件");
        helper.setText("<b style='color:red'>带附件的邮件</b>", true);
        helper.addAttachment("aaaa",new File("C:\\Users\\Administrator\\Desktop\\无标题.png"));
        javaMailSender.send(mimeMessage);
    }
}

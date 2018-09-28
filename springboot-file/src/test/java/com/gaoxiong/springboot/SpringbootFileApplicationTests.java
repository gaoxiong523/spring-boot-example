package com.gaoxiong.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SpringbootFileApplicationTests {
    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void contextLoads () {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("测试2");
        simpleMailMessage.setText("测试发送邮件2");
        simpleMailMessage.setTo("gaoxiong5233@qq.com");
        simpleMailMessage.setFrom("gaoxiong@lidianjinrong.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void test() throws Exception {
        //1.创建复杂消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.addAttachment("xx.png",new File("C:\\Users\\Administrator\\Desktop\\00\\4.png"));
            helper.setSubject("带附件测试");
            helper.setText("<h1 style='color:red'>带附件测试</h1>",true);
            helper.setTo("gaoxiong5233@qq.com");
            helper.setFrom("gaoxiong@lidianjinrong.com");
            javaMailSender.send(mimeMessage);

    }
}

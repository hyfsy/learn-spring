package com.hyf.spring6.integration.email.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * @author baB_hyf
 * @date 2020/10/17
 */
@Component
public class OrderManager implements IOrderManager {

    public static final String username  = "xxx@qq.com";
    public static final String recipient = "xxx@qq.com";

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void placeOrder(Map<String, Object> order) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage(this.simpleMailMessage);

        simpleMailMessage.setTo(recipient);
        simpleMailMessage.setText("hello");
        simpleMailMessage.setSubject("主题内容：测试");

        System.out.println(mailSender);
        System.out.println(simpleMailMessage);

        try {
            mailSender.send(simpleMailMessage); // MailException为非受检异常
        } catch (MailException e) {
            // simply log it and go on...
            // System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void placeOrder2(Map<String, Object> order) {

        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom(new InternetAddress(username));
                mimeMessage.setRecipient(Message.RecipientType.TO, // 接受者
                        new InternetAddress(recipient));
                mimeMessage.setText("hello2");
                mimeMessage.setSubject("主题内容：测试");
            }
        };

        try {
            javaMailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            // simply log it and go on...
            // System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void placeOrder3(Map<String, Object> order) {
        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {

                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

                mimeMessageHelper.setFrom(username);
                mimeMessageHelper.setTo(recipient);
                mimeMessageHelper.setText("hello3");
                mimeMessageHelper.setSubject("主题内容：测试3");
            }
        };

        try {
            javaMailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            // simply log it and go on...
            // System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

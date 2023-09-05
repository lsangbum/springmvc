package hello.itemservice.service;

import hello.itemservice.mapper.MailSenderMapper;
import hello.itemservice.vo.MailInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@AllArgsConstructor
@Slf4j
public class MailSenderService {

    private JavaMailSender javaMailSender;
    private MailSenderMapper mailSenderMapper;

    public Integer sendMail(MailInfo mailInfo) throws SQLException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("c23tiger@gmail.com");
        message.setTo(mailInfo.getReceiver());
        message.setSubject(mailInfo.getTitle());
        message.setText(mailInfo.getContent());
        javaMailSender.send(message);


        return mailSenderMapper.sendMail(mailInfo);
    }
}

package hello.itemservice.controller;

import hello.itemservice.service.MailSenderService;
import hello.itemservice.vo.MailInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/mail")
public class MailSenderController {

    private MailSenderService mailSenderService;

    /**
     * @writer  이상범
     * @date    230904
     * @script  이메일 전송
     * @return  성공 1 실패 0
     */
    @PostMapping("/send")
    public Integer sendMail(MailInfo mailInfo) throws Exception{
        return mailSenderService.sendMail(mailInfo);
    }





}

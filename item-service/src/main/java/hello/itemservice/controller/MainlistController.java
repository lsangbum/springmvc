package hello.itemservice.controller;

import hello.itemservice.service.MainlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
@Slf4j
public class MainlistController {

    private final MainlistService mainlistService;

    /**
     * @writer  이상범
     * @date    230815
     * @script  request values 에 따라 response 경료 변경
     * @return  mainlist/firstpage
     */
    @GetMapping("/list")
    public String firstList(String values)throws Exception {

        mainlistService.insertTest(values);

        String result = "";

        if (values.equals("first"))
            result = "mainlist/firstpage";
        else if (values.equals("second"))
            result = "mainlist/secondpage";
        else if (values.equals("third"))
            result = "mainlist/thirdpage";
        else if (values.equals("four"))
            result = "mainlist/fourthpage";
        else
            result = "mainlist/fifthpage";

        return result;
    }

    /**
     * @writer  이상범
     * @date    230818
     * @script  아이디, 비밀번호 DB저장 확인 메서드
     * @return  mainlist/login
     */
    @PostMapping("/login")
    public String loginTest(String userName, String passwordName)throws Exception {

        mainlistService.loginTest(userName, passwordName);
        String result = "mainlist/loginCheck";

        return result;
    }

}

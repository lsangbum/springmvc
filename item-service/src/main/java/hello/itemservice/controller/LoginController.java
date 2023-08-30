package hello.itemservice.controller;

import hello.itemservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    /**
     * @writer  이상범
     * @date    230830
     * @script  아이디, 비밀번호 확인 API
     * @return  성공 1 실패 0
     */
    @PostMapping("/loginChk")
    @ResponseBody
    public Map loginChk(String email, String pwd, Model model) throws Exception {
        return loginService.loginChk(email, pwd);
    }

    @GetMapping("/view")
    public String view(Model model) throws Exception {
        model.addAttribute("list", loginService.getBoard());
        return "view/view1";
    }

    @GetMapping("/board/write")
    public String write() throws Exception {
        return "view/boardwrite";
    }

}

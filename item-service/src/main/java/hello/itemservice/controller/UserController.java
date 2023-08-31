package hello.itemservice.controller;

import hello.itemservice.service.UserService;
import hello.itemservice.vo.ReqUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * @writer  이상범
     * @date    230831
     * @script  회원가입
     * @return  성공 1 실패 0
     */
    @PostMapping("/join")
    @ResponseBody
    public Integer insertJoin(@RequestBody ReqUserInfo userInfo) throws Exception {
        return userService.insertJoin(userInfo);
    }

    /**
     * @writer  이상범
     * @date    230830
     * @script  아이디, 비밀번호 확인 API
     * @return  성공 1 실패 0
     */
    @PostMapping("/loginChk")
    @ResponseBody
    public Map loginChk(String email, String pwd) throws Exception {
        return userService.loginChk(email, pwd);
    }

    @GetMapping("/view")
    public String view(Model model) throws Exception {
        model.addAttribute("list", userService.getBoard());
        return "view/view1";
    }

    @GetMapping("/board/write")
    public String write() throws Exception {
        return "view/boardwrite";
    }

}

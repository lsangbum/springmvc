package hello.itemservice.controller;

import hello.itemservice.service.UserService;
import hello.itemservice.vo.ReqUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public Map loginChk(String email, String pwd, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("userId", email);
        return userService.loginChk(email, pwd);
    }

    @GetMapping("/view")
    public String view(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        model.addAttribute("list", userService.getBoard());
        System.out.println(userService.getBoard().get(0).toString());
        model.addAttribute("userId", session.getAttribute("userId"));
        return "view/view1";
    }

    @GetMapping("/board/write")
    public String write() throws Exception {
        return "view/boardwrite";
    }

}

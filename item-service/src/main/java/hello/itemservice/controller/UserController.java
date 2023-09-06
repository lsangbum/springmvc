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
     * @date    230905
     * @script  아이디중복체크
     * @return  성공 1 실패 0
     */
    @PostMapping("/check/userid")
    @ResponseBody
    public Map getCheckUserId(String userId)throws Exception {
        return userService.getCheckUserId(userId);
    }

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
     * @date    230906
     * @script  회원정보 수정
     * @return  성공 1 실패 0
     */
    @PostMapping("/update/info")
    @ResponseBody
    public Integer updateUserInfo(@RequestBody ReqUserInfo userInfo) throws Exception {
        return userService.updateUserInfo(userInfo);
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

    /**
     * @writer  이상범
     * @date    230830
     * @script  로그인 아이디세션저장 후 페이지이동
     * @return  view/view1
     */
    @GetMapping("/view")
    public String view(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        model.addAttribute("list", userService.getBoard());
        System.out.println(userService.getBoard().get(0).toString());
        model.addAttribute("userId", session.getAttribute("userId"));
        return "view/view1";
    }

    /**
     * @writer  이상범
     * @date    230905
     * @script  로그아웃 세션삭제
     * @return  index
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);    //session 자체가 null을 허용하기에 null 체크를 해줌
        if (session != null) {
            session.invalidate();   //세션의 모든 속성을 삭제
        }
        return "redirect:/";
    }
    
    /**
     * @writer  이상범
     * @date    230906
     * @script  회원정보 불러오기
     * @return  회원정보
     */
    @PostMapping("/get/info")
    @ResponseBody
    public ReqUserInfo getUserInfo(String userId) throws Exception {
        return userService.getUserInfo(userId);
    }


    /**
     * 확인 후 삭제
     * @return
     * @throws Exception
     */
    @GetMapping("/board/write")
    public String write() throws Exception {
        return "view/boardwrite";
    }

}

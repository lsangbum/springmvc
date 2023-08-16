package hello.itemservice.controller;

import hello.itemservice.service.MainlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
@Slf4j
public class MainlistController {

    private MainlistService mainlistService;

    /**
     * @writer  이상범
     * @date    230815
     * @script  request values 에 따라 response 경료 변경
     * @return  mainlist/firstpage
     */
    @GetMapping("/list")
    public String firstList(String values)throws Exception {

        log.info("######values : " + values);
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

}

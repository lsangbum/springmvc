package hello.itemservice.controller;

import hello.itemservice.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/write")
    public int setWrite(String title, String content) throws Exception {
        return boardService.setWrite(title, content);
    }


}

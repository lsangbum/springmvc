package hello.itemservice.controller;

import hello.itemservice.service.BoardService;
import hello.itemservice.vo.BoardList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    /**
     * @writer  이상범
     * @date    230830
     * @script  게시판글쓰기 / 제목, 내용, 작성자
     * @return  성공 1 실패 0
     */
    @PostMapping("/write")
    public Integer setWrite(String title, String content, String uid) throws Exception {
        return boardService.setWrite(title, content, uid);
    }
    /**
     * @writer  이상범
     * @date    230901
     * @script  게시판글 수정 / 제목, 내용, 작성자, 작성일
     * @return  성공 1 실패 0
     */
    @PostMapping("/updateLetter")
    public Integer updateLetter(@RequestBody BoardList boardList) throws Exception  {
        return boardService.updateLetter(boardList);
    }
    /**
     * @writer  이상범
     * @date    230901
     * @script  게시판글 삭제 / 제목, 내용, 작성자, 작성일
     * @return  성공 1 실패 0
     */
    @PostMapping("/deleteLetter")
    public Integer deleteLetter(@RequestBody BoardList boardList) throws Exception  {
        return boardService.deleteLetter(boardList);
    }


}

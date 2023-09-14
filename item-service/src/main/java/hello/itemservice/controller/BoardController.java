package hello.itemservice.controller;

import hello.itemservice.service.BoardService;
import hello.itemservice.vo.BoardList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    /**
     * @writer  이상범
     * @date    230830
     * @script  로그인 아이디세션저장 후 페이지이동
     * @return  view/view1
     */
    @GetMapping("/view")
    public ModelAndView view(ModelAndView model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        List<BoardList> list = boardService.getBoard();

        if (list != null) {
            model.addObject("list", list);
        }

        model.addObject("userId", session.getAttribute("userId"));
        model.setViewName("view/view1");

        return model;
    }

    /**
     * @writer  이상범
     * @date    230830
     * @script  게시판글쓰기 / 제목, 내용, 작성자
     * @return  성공 1 실패 0
     */
    @PostMapping("/write")
    public ModelAndView setWrite(@ModelAttribute BoardList boardList, ModelAndView mv) throws Exception {
        boardService.setWrite(saveFile(boardList));     //업데이트 쿼리
        mv.setViewName("redirect:/board/view");         //게시판 리다이렉트

        return mv;
    }

    /**
     * @writer  이상범
     * @date    230901
     * @script  게시판글 수정 / 제목, 내용, 작성자, 작성일
     * @return  성공 1 실패 0
     */
    @PostMapping("/updateLetter")
    public ModelAndView updateLetter(@ModelAttribute BoardList boardList, ModelAndView mv) throws Exception  {
        boardService.updateLetter(saveFile(boardList));
        mv.setViewName("redirect:/board/view");

        return mv;
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

    /**
     * @writer  이상범
     * @date    230915
     * @script  파일저장 공용모듈
     * @return  boardList
     */
    public BoardList saveFile(BoardList boardList) throws Exception {
        /* uploadPath   = 업로드 폴더 경로 저장
         * filePath     = 파일 저장 경로 설정
         * destinationFile / transferTo(destinationFile) = 파일 저장
         */
        Path uploadPath = Paths.get(boardList.getUploadFolder());
        Path filePath = uploadPath.resolve(boardList.getFile().getOriginalFilename());
        File destinationFile = new File(filePath.toString());
        boardList.getFile().transferTo(destinationFile);

        boardList.setFileName(boardList.getFile().getOriginalFilename());
        boardList.setFilePath(boardList.getUploadFolder() + "/");
        boardList.setFileSize(boardList.getFile().getSize());
        return boardList;
    }
}

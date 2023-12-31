package hello.itemservice.service;

import hello.itemservice.mapper.BoardMapper;
import hello.itemservice.vo.BoardList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardList> getBoard() throws SQLException {
        return boardMapper.getBoard();
    }

    public Integer setWrite(BoardList boardList) throws SQLException {
        return boardMapper.setWrite(boardList);
    }

    public Integer updateLetter(BoardList boardList) throws SQLException {
        return boardMapper.updateLetter(boardList);
    }

    public Integer deleteLetter(BoardList boardList) throws SQLException {
        return boardMapper.deleteLetter(boardList);
    }

}

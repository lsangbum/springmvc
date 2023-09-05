package hello.itemservice.service;

import hello.itemservice.mapper.BoardMapper;
import hello.itemservice.vo.BoardList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@AllArgsConstructor
@Slf4j
public class BoardService {

    private final BoardMapper boardMapper;

    public Integer setWrite(String title, String content, String uid) throws SQLException {
        return boardMapper.setWrite(title, content, uid);
    }

    public Integer updateLetter(BoardList boardList) throws SQLException {
        return boardMapper.updateLetter(boardList);
    }

    public Integer deleteLetter(BoardList boardList) throws SQLException {
        return boardMapper.deleteLetter(boardList);
    }

}

package hello.itemservice.service;

import hello.itemservice.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@AllArgsConstructor
@Slf4j
public class BoardService {

    private final BoardMapper boardMapper;

    public int setWrite(String title, String content) throws SQLException {
        return boardMapper.setWrite(title, content);
    }
}

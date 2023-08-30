package hello.itemservice.service;

import hello.itemservice.mapper.LoginMapper;
import hello.itemservice.vo.BoardList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final LoginMapper loginMapper;

    public Map loginChk(String email, String pwd) throws SQLException {
        return loginMapper.loginChk(email, pwd);
    }

    public List<BoardList> getBoard() throws SQLException {
        return loginMapper.getBoard();
    }
}

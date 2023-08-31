package hello.itemservice.service;

import hello.itemservice.mapper.UserMapper;
import hello.itemservice.vo.BoardList;
import hello.itemservice.vo.ReqUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserMapper userMapper;

    public Map loginChk(String email, String pwd) throws SQLException {
        return userMapper.loginChk(email, pwd);
    }

    public List<BoardList> getBoard() throws SQLException {
        return userMapper.getBoard();
    }

    public Integer insertJoin(ReqUserInfo userInfo) throws SQLException {
        return userMapper.insertJoin(userInfo);
    }
}

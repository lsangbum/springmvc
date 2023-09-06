package hello.itemservice.service;

import hello.itemservice.mapper.UserMapper;
import hello.itemservice.vo.BoardList;
import hello.itemservice.vo.ReqUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public Map loginChk(String email, String pwd) throws SQLException {
        Map<String, String> result;
        result = userMapper.loginChk(email, pwd);

        if (passwordEncoder.matches(pwd, result.get("PWD"))) {
            result.put("result", "1");
        }else {
            result.put("result", "0");
        }

        return result;
    }

    public List<BoardList> getBoard() throws SQLException {
        return userMapper.getBoard();
    }

    public Integer insertJoin(ReqUserInfo userInfo) throws SQLException {
        String encryptedPassword = passwordEncoder.encode(userInfo.getUserPwd());
        userInfo.setUserPwd(encryptedPassword);
        return userMapper.insertJoin(userInfo);
    }

    public Map getCheckUserId(String userId) throws SQLException {
        return userMapper.getCheckUserId(userId);
    }

    public ReqUserInfo getUserInfo(String userId) throws SQLException {
        return userMapper.getUserInfo(userId);
    }

    public Integer updateUserInfo(ReqUserInfo userInfo) throws SQLException {
        return userMapper.updateUserInfo(userInfo);
    }
}

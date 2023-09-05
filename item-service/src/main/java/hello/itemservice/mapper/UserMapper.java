package hello.itemservice.mapper;

import hello.itemservice.vo.BoardList;
import hello.itemservice.vo.ReqUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    Map loginChk(@Param("email") String email, @Param("pwd") String pwd) throws SQLException;

    List<BoardList> getBoard() throws SQLException;

    Integer insertJoin(ReqUserInfo userInfo) throws SQLException;

    Map getCheckUserId(@Param("userId") String userId)throws SQLException;
}
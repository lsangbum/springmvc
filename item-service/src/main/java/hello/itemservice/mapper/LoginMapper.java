package hello.itemservice.mapper;

import hello.itemservice.vo.BoardList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface LoginMapper {
    Map loginChk(@Param("email") String email, @Param("pwd") String pwd) throws SQLException;

    List<BoardList> getBoard() throws SQLException;
}
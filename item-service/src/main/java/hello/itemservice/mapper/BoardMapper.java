package hello.itemservice.mapper;

import hello.itemservice.vo.BoardList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

@Mapper
public interface BoardMapper {
    Integer setWrite(@Param("title") String title, @Param("content") String content, @Param("uid") String uid) throws SQLException;

    Integer updateLetter(BoardList boardList) throws SQLException;

    Integer deleteLetter(BoardList boardList)throws SQLException;
}

package hello.itemservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

@Mapper
public interface BoardMapper {
    int setWrite(@Param("title") String title, @Param("content") String content) throws SQLException;
}

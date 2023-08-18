package hello.itemservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MainlistMapper {

    void insertTest(@Param("uuid") String uuid, @Param("values") String values);

    void loginTest(@Param("userName") String userName, @Param("passwordName") String passwordName);
}

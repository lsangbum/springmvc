package hello.itemservice.mapper;

import hello.itemservice.vo.MailInfo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface MailSenderMapper {
    Integer sendMail(MailInfo mailInfo) throws SQLException;

}

package hello.itemservice.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MailInfo {

    private String receiver;
    private String title;
    private String content;
    private String uid;

}

package hello.itemservice.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardList {

    private String title;
    private String content;
    private String uid;
    private String date;

    private MultipartFile file;
    private String filePath;
    private String fileName;
    private Long fileSize;

    @Value("${spring.servlet.multipart.location}")
    private String uploadFolder;
}

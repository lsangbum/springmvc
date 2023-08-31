package hello.itemservice.vo;

import lombok.Data;

@Data
public class ReqUserInfo {

    private String userId;
    private String userPwd;
    private String userName;
    private String userBirth;
    private String userPhone;
    private String userZipcode;
    private String userAddress;

}

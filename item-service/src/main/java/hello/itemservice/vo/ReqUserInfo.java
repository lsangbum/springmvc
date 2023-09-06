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
    private String userDetailAddress;

    private String userNewPwd;  //  회원정보 수정 시 신규 비밀번호 값

}

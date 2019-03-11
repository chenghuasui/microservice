package cn.jbinfo.microservice.biz;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class User  {
    private String id	;
    private String userAccount;
    private String userPsd	;
    private String userName;
    private String userPsdSource;
    private String userGroup;
    private String userDuty;
    private String userPermissionText;
    private String sooId;
    private String geroId	;
    private String delFlag	;
    private Date createDate;
    private String createBy;
    private String dbSource;

}

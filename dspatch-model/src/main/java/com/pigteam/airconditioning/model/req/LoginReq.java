package com.pigteam.airconditioning.model.req;

import lombok.Data;

/**
 * @className: LoginReq
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 15:43
 * @descripton:
 **/
@Data
public class LoginReq {

    private String vcode;

    private String username;

    private String password;
}

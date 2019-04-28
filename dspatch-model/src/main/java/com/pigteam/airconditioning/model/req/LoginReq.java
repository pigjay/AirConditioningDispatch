package com.pigteam.airconditioning.model.req;

import com.pigteam.airconditioning.common.validate.annotation.ValueSet;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @className: LoginReq
 * @author: zhujie
 * @version:
 * @date: 2019/4/17 15:43
 * @descripton:
 **/
@Data
public class LoginReq {

    @NotBlank
    private String vcode;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @ValueSet({"1","2","3"})
    private Integer status;
}

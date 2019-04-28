package com.pigteam.airconditioning.model.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @className: MenuReq
 * @author: zhujie
 * @version:
 * @date: 2019/4/28 17:31
 * @descripton:
 **/
@Data
public class MenuReq {

    @NotNull
    private Long userId;
}

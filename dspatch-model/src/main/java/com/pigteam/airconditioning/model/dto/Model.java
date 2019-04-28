package com.pigteam.airconditioning.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className: Model
 * @author: zhujie
 * @version:
 * @date: 2019/4/25 17:43
 * @descripton:
 **/
@Data
@AllArgsConstructor
public class Model {

    private Long id;

    private Long parentId;

    private String content;
}

package com.gourmetapi.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GourmetClassify {
    private Integer id;

    private String name;

    private Integer parentId;

}
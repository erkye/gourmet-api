package com.gourmetapi.pojo;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author none
 */
@Data
@Builder
public class GourmetClassify {
    private Integer id;

    private String name;

    private Integer parentId;

}
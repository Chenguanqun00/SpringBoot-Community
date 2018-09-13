package com.animo.mail.entity;

import lombok.Data;

@Data
public class ResourceEntity extends BaseEntity{

    /**
     * 静态资源文件路径
     */
    private String rscPath;

    /**
     * 静态资源文件标示
     */
    private String rscId;

}

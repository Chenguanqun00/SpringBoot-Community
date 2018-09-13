package com.animo.mail.entity;

import lombok.Data;

@Data
public class BaseEntity {

    /**
     * 接收人
     */
    private String[] to;

    /**ß
     * 主题（标题）
     */
    private String subject;

    /**
     * 内容
     */
    private String Text;

    /**
     * 抄送可多人
     */
    private String[] cc;

}

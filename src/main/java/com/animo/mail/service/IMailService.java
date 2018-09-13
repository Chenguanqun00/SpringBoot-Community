package com.animo.mail.service;

import com.animo.mail.entity.AttachmentsEntity;
import com.animo.mail.entity.ResourceEntity;
import com.animo.mail.entity.SimpleEntity;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description : 发送邮件几种形式的公用方法
 * ---------------------------------
 * @Author : Animo QQ:1151757358
 * @Date : 2018/8/30
 */
public interface IMailService {

    /**
     * 发送文本邮件
     */
    void sendSimpleMail(SimpleEntity simple);

    void sendSimpleMailCc(SimpleEntity simple);

    /**
     * 发送HTML邮件
     * @throws MessagingException
     */
    void sendHtmlMail(SimpleEntity simple) throws MessagingException;

    void sendHtmlMailCc(SimpleEntity simple) throws MessagingException;

    /**
     * 发送带附件的邮件
     *
     * @throws MessagingException
     */
    void sendAttachmentsMail(AttachmentsEntity attachmentsEntity) throws MessagingException;

    void sendAttachmentsMailCc(AttachmentsEntity attachmentsEntity) throws MessagingException;

    /**
     * 发送正文中有静态资源的邮件
     * @throws MessagingException
     */
    void sendResourceMail(ResourceEntity resourceEntity) throws MessagingException;

    void sendResourceMailCc(ResourceEntity resourceEntity) throws MessagingException;
}

package com.animo.mail.service.impl;

import com.animo.mail.entity.AttachmentsEntity;
import com.animo.mail.entity.ResourceEntity;
import com.animo.mail.entity.SimpleEntity;
import com.animo.mail.service.IMailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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
 * @Description :
 * ---------------------------------
 * @Author : Animo QQ:1151757358
 * @Date : 2018/8/30
 */
@Component
public class IMailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;

    @Override
    public void sendSimpleMail(SimpleEntity simpleEntity) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(simpleEntity.getTo());
        message.setSubject(simpleEntity.getSubject());
        message.setText(simpleEntity.getText());
        mailSender.send(message);
    }

    @Override
    public void sendSimpleMailCc(SimpleEntity simpleEntity) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(simpleEntity.getTo());
        message.setCc(simpleEntity.getCc());
        message.setSubject(simpleEntity.getSubject());
        message.setText(simpleEntity.getText());
        mailSender.send(message);
    }

    @Override
    public void sendHtmlMail(SimpleEntity simpleEntity) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(simpleEntity.getTo());
        helper.setSubject(simpleEntity.getSubject());
        helper.setText(simpleEntity.getText(), true);
        mailSender.send(message);
    }

    @Override
    public void sendHtmlMailCc(SimpleEntity simpleEntity) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(simpleEntity.getTo());
        helper.setSubject(simpleEntity.getSubject());
        helper.setText(simpleEntity.getText(), true);
        helper.setCc(simpleEntity.getCc());
        mailSender.send(message);
    }

    @Override
    public void sendAttachmentsMail(AttachmentsEntity attachmentsEntity) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        String filePath = attachmentsEntity.getFilePath();
        helper.setFrom(from);
        helper.setTo(attachmentsEntity.getTo());
        helper.setSubject(attachmentsEntity.getSubject());
        helper.setText(filePath, true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);
        mailSender.send(message);
    }

    @Override
    public void sendAttachmentsMailCc(AttachmentsEntity attachmentsEntity) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        String filePath = attachmentsEntity.getFilePath();
        helper.setCc(attachmentsEntity.getCc());
        helper.setFrom(from);
        helper.setTo(attachmentsEntity.getTo());
        helper.setSubject(attachmentsEntity.getSubject());
        helper.setText(filePath, true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);
        mailSender.send(message);
    }

    @Override
    public void sendResourceMail(ResourceEntity resourceEntity) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(resourceEntity.getTo());
        helper.setSubject(resourceEntity.getSubject());
        helper.setText(resourceEntity.getText(), true);
        FileSystemResource res = new FileSystemResource(new File(resourceEntity.getRscPath()));
        helper.addInline(resourceEntity.getRscId(), res);
        mailSender.send(message);
    }

    @Override
    public void sendResourceMailCc(ResourceEntity resourceEntity) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setCc(resourceEntity.getCc());
        helper.setTo(resourceEntity.getTo());
        helper.setSubject(resourceEntity.getSubject());
        helper.setText(resourceEntity.getText(), true);
        FileSystemResource res = new FileSystemResource(new File(resourceEntity.getRscPath()));
        helper.addInline(resourceEntity.getRscId(), res);
        mailSender.send(message);
    }
}

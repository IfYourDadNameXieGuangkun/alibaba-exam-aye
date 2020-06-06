package com.alibaba.api.common.utils;

import org.springframework.stereotype.Component;


/**
 * Created by summer on 2017/5/4.
 */
@Component
public interface MailService{
    void sendSimpleMail(String to, String subject, String content);

    void sendHtmlMail(String to, String subject, String content);

    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
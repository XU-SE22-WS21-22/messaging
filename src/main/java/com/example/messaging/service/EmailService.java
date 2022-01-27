package com.example.messaging.service;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService {

        Session newSession = null;
        MimeMessage mimeMessage = null;
        public static void main(String args[]) throws AddressException, MessagingException, IOException
        {
            EmailService mail = new EmailService();
            mail.setupServerProperties();
            mail.draftEmail("email@email.com","subject","message");
            mail.sendEmail();
        }

        private void sendEmail() throws MessagingException {
            String fromUser = "pqr@gmail.com";  //We need a gmail account
            String fromUserPassword = "*****";  //and a password
            String emailHost = "smtp.gmail.com";
            Transport transport = newSession.getTransport("smtp");
            transport.connect(emailHost, fromUser, fromUserPassword);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            System.out.println("Email successfully sent!!!");
        }

        private MimeMessage draftEmail(String recipient, String subject, String body) throws AddressException, MessagingException, IOException {
            String emailRecipient = recipient;
            String emailSubject = subject;
            String emailBody = body;
            mimeMessage = new MimeMessage(newSession);

            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipient));
            mimeMessage.setSubject(emailSubject);
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(emailBody,"html/text");
            MimeMultipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(bodyPart);
            mimeMessage.setContent(multiPart);
            return mimeMessage;
        }

        private void setupServerProperties() {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.port", "547");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            newSession = Session.getDefaultInstance(properties,null);
        }

    }


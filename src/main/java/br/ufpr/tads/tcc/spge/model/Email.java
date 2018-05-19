/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.model;

import java.io.Serializable;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Tom
 */
public class Email implements Serializable {

    private String destinatario;
    private String assunto;
    private String texto;

    public Email() {
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void enviarEmail() throws MessagingException {
        Properties props = new Properties();
        // Parâmetros de conexão com servidor Gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session1 = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("spgetcc@gmail.com", "spgetcc2018");
            }
        });
        session1.setDebug(true);
        Message message = new MimeMessage(session1);
        message.setFrom(new InternetAddress("spgetcc@gmail.com")); //Remetente
        Address[] toUser = InternetAddress //Destinatário
                .parse(getDestinatario());
        message.setRecipients(Message.RecipientType.TO, toUser);
        message.setSubject(getAssunto());//Assunto
        message.setText(getTexto());
        Transport.send(message);
    }
}

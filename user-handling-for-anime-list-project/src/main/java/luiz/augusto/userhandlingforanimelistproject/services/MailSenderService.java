package luiz.augusto.userhandlingforanimelistproject.services;

public interface MailSenderService {

    void sendSimpleMail(String toEmail, String body, String subject);
}

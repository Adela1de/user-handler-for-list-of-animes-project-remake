package luiz.augusto.userhandlingforanimelistproject.events.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import luiz.augusto.userhandlingforanimelistproject.events.RegistrationCompleteEvent;
import luiz.augusto.userhandlingforanimelistproject.services.MailSenderService;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
public class ApplicationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;
    private final MailSenderService mailSenderService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event)
    {
        var token = UUID.randomUUID().toString();
        var user = event.getUser();
        userService.saveVerificationTokenForUser(user, token);

        var urlConfirmation = event.getApplicationUrl() + "/users/confirmRegistration?token=" + token;
        var urlResend = event.getApplicationUrl() + "/users/resendVerificationToken?token=" + token;
        mailSenderService.sendSimpleMail(user.getEmail(),
                "Click the link to verify your e-mail: " +
                        urlConfirmation +
                        " \n " +
                        "Or click this link to resend the verification token: " +
                        urlResend,
                "E-mail confirmation");
    }
}

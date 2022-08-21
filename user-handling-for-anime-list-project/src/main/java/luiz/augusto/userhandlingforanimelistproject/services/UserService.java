package luiz.augusto.userhandlingforanimelistproject.services;

import luiz.augusto.userhandlingforanimelistproject.entities.User;
import luiz.augusto.userhandlingforanimelistproject.entities.VerificationToken;
import luiz.augusto.userhandlingforanimelistproject.requests.LogInRequestBody;

public interface UserService {

    User registerUser(User user);

    VerificationToken saveVerificationTokenForUser(User user, String token);

    String validateToken(String token);

    VerificationToken getVerificationTokenOrElseThrowObjectNotFoundException(String token);

    void saveVerificationToken(VerificationToken token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User verifyCredentials(LogInRequestBody logInRequestBody);
}

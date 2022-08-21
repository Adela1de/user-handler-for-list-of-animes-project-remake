package luiz.augusto.userhandlingforanimelistproject.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.userhandlingforanimelistproject.entities.User;
import luiz.augusto.userhandlingforanimelistproject.requests.LogInRequestBody;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "logIn")
public class LogInController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<User> logIn(@RequestBody LogInRequestBody logInRequestBody)
    {
        var user = userService.verifyCredentials(logInRequestBody);
        return ResponseEntity.ok().body(user);
    }
}

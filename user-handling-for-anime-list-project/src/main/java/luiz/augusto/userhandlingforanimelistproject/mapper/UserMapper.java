package luiz.augusto.userhandlingforanimelistproject.mapper;

import lombok.RequiredArgsConstructor;
import luiz.augusto.userhandlingforanimelistproject.entities.User;
import luiz.augusto.userhandlingforanimelistproject.requests.UserPostRequestBody;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class UserMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static User toUser(UserPostRequestBody userPostRequestBody)
    {
        User user = mapper.map(userPostRequestBody, User.class);
        return user;
    }

}

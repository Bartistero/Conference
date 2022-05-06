package pl.sterniczuk.conference.service.user;

import lombok.Getter;
import lombok.Setter;
import pl.sterniczuk.conference.model.User;

@Getter
@Setter
public class UserDto {
    String login;
    String email;

    public static User UserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
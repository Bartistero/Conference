package pl.sterniczuk.conference.service.user;

import lombok.*;
import pl.sterniczuk.conference.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    String login;
    String email;

    public static User UserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
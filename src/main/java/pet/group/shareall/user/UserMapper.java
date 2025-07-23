package pet.group.shareall.user;

import org.springframework.stereotype.Component;
import pet.group.shareall.user.dto.UserGetDto;
import pet.group.shareall.user.dto.UserPostDto;

@Component("userMapper")
public class UserMapper {

    public UserModel toEntity(UserPostDto dto) {
        return new UserModel(
          dto.getName(),
          dto.getEmail()
        );
    }

    public UserGetDto toDto(UserModel user) {
        return new UserGetDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}

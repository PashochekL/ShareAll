package pet.group.shareall.user;

import org.springframework.stereotype.Component;
import pet.group.shareall.user.dto.getDto;
import pet.group.shareall.user.dto.postDto;

@Component
public class mapper {

    public model toEntity(postDto dto) {
        return new model (
          dto.getName(),
          dto.getEmail(),
          dto.getPhone(),
          dto.getBirthday()
        );
    }

    public getDto toDto(model user) {
        return new getDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getBirthday()
        );
    }
}

package pet.group.shareall.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pet.group.shareall.exception.EmailAlreadyExistsException;
import pet.group.shareall.exception.NotFoundException;
import pet.group.shareall.user.dto.UserGetDto;
import pet.group.shareall.user.dto.UserPostDto;
import pet.group.shareall.user.dto.UserUpdateDto;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final UserMapper mapper;

    public UserGetDto create(UserPostDto dto) {
        if (userRepo.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException("Пользователь с таким email уже существует: " + dto.getEmail());
        }
        UserModel user = mapper.toEntity(dto);

        userRepo.save(user);
        return mapper.toDto(user);
    }

    public UserGetDto getInfo(Long id) {
        UserModel user = userRepo.findById(id).orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        return mapper.toDto(user);
    }

    public UserGetDto changeUser(Long id, UserUpdateDto dto) {
        UserModel user = userRepo.findById(id).orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        if (dto.getEmail() != null) {
            if (userRepo.existsByEmail(dto.getEmail())) {
                throw new EmailAlreadyExistsException("Пользователь с таким email уже существует: " + dto.getEmail());
            }
            user.setEmail(dto.getEmail());
        }
        if (dto.getName() != null) {
            user.setName(dto.getName());
        }

        userRepo.save(user);
        return mapper.toDto(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}

package pet.group.shareall.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pet.group.shareall.user.dto.getDto;
import pet.group.shareall.user.dto.postDto;

@Service
@AllArgsConstructor
public class service {

    private final repository repo;
    private final mapper userMapper;

    public void create(postDto dto) {
        model user = userMapper.toEntity(dto);
        repo.save(user);
    }

    public getDto getInfo(Long id) {
        model user = repo.findById(id).orElseThrow(() -> new RuntimeException("пользователь не найден"));
        return userMapper.toDto(user);
    }

    public void changeUser(Long id, postDto dto) {
        model user = repo.findById(id).orElseThrow(() -> new RuntimeException("пользователь не найден"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setBirthday(dto.getBirthday());

        repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}

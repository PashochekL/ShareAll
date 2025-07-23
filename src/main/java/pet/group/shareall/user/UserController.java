package pet.group.shareall.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.group.shareall.user.dto.UserGetDto;
import pet.group.shareall.user.dto.UserPostDto;
import pet.group.shareall.user.dto.UserUpdateDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserGetDto> create(@RequestBody @Valid UserPostDto dto) {
        UserGetDto userDto = userService.create(dto);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserGetDto> get(@PathVariable Long userId) {
        UserGetDto userInfo = userService.getInfo(userId);
        return ResponseEntity.ok(userInfo);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserGetDto> change(@PathVariable Long userId, @RequestBody @Valid UserUpdateDto dto) {
        UserGetDto userInfo = userService.changeUser(userId, dto);
        return ResponseEntity.ok(userInfo);
    }

    @DeleteMapping("{userId}")
    public void delete(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}

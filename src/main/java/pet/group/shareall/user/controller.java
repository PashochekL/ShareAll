package pet.group.shareall.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.group.shareall.user.dto.getDto;
import pet.group.shareall.user.dto.postDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class controller {

    private final service userService;

    @PostMapping("/register")
    public void create(@RequestBody postDto dto) {
        userService.create(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<getDto> get(@PathVariable Long id) {
        getDto userInfo = userService.getInfo(id);
        return ResponseEntity.ok(userInfo);
    }

    @PutMapping("/change{id}")
    public void change(@PathVariable Long id, @RequestBody postDto dto) {
        userService.changeUser(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

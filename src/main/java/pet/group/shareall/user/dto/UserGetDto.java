package pet.group.shareall.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserGetDto {
    private Long id;
    private String name;
    private String email;
}

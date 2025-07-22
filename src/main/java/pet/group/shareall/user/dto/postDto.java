package pet.group.shareall.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class postDto {
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
}

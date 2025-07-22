package pet.group.shareall.user.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@AllArgsConstructor
public class getDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
}

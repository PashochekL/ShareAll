package pet.group.shareall.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserDto {
    private Long id;
    private String name;
}

package pet.group.shareall.item.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import pet.group.shareall.item.EnumItem;

@Data
@AllArgsConstructor
public class ItemPostDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private String available;
}

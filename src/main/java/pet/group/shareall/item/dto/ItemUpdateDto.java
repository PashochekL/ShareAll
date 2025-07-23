package pet.group.shareall.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemUpdateDto {
    private String name;
    private String description;
    private String available;
}

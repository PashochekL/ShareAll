package pet.group.shareall.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemGetDto {
    private Long id;
    private String name;
    private String description;
    private String available;
}

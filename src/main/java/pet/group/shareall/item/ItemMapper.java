package pet.group.shareall.item;

import org.springframework.stereotype.Component;
import pet.group.shareall.item.dto.ItemGetDto;
import pet.group.shareall.item.dto.ItemPostDto;
import pet.group.shareall.user.UserModel;

@Component("itemMapper")
public class ItemMapper {

    public ItemModel toEntity(ItemPostDto dto, UserModel user) {
        return new ItemModel(
          dto.getName(),
          dto.getDescription(),
          dto.getAvailable(),
          user
        );
    }

    public ItemGetDto toDto(ItemModel model) {
        return new ItemGetDto(
          model.getId(),
          model.getName(),
          model.getDescription(),
          model.getAvailable()
        );
    }
}

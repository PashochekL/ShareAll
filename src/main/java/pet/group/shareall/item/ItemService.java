package pet.group.shareall.item;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pet.group.shareall.exception.NotFoundException;
import pet.group.shareall.item.dto.ItemGetDto;
import pet.group.shareall.item.dto.ItemPostDto;
import pet.group.shareall.item.dto.ItemUpdateDto;
import pet.group.shareall.user.UserModel;
import pet.group.shareall.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepo;
    private final UserRepository userRepo;
    private final ItemMapper mapper;

    public ItemGetDto createItems(Long userId, ItemPostDto post) {
        UserModel user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        ItemModel item = mapper.toEntity(post, user);

        itemRepo.save(item);

        return mapper.toDto(item);
    }

    public ItemGetDto getItem(Long userId, Long itemId) {
        userRepo.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        ItemModel item = itemRepo.findById(itemId).orElseThrow(() -> new NotFoundException("Вещь не найдена"));

        return mapper.toDto(item);
    }

    public ItemGetDto updateItems(Long userId, Long itemId, ItemUpdateDto dto) {
        userRepo.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        ItemModel item = itemRepo.findById(itemId).orElseThrow(() -> new NotFoundException("Вещь не найдена"));

        if (dto.getName() != null) {
            item.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            item.setDescription(dto.getDescription());
        }
        if (dto.getAvailable() != null) {
            item.setAvailable(dto.getAvailable());
        }

        itemRepo.save(item);
        return mapper.toDto(item);
    }

    public List<ItemGetDto> getAllItems(Long userId) {
        userRepo.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        List<ItemModel> listItems = itemRepo.findAllByUserId(userId);

        return listItems.stream().map(mapper::toDto).toList();
    }

    public List<ItemGetDto> getSearchItems (Long userId, String text) {
        userRepo.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        List<ItemModel> result;

        if (text == null || text.trim().isEmpty()) {
            return List.of();
        }
        if ("false".equalsIgnoreCase(text)) {
            result = itemRepo.findByAvailable(text.toLowerCase());
        }
        else {
            result = itemRepo.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(text, text);
        }
        return result.stream().map(mapper::toDto).toList();
    }
}

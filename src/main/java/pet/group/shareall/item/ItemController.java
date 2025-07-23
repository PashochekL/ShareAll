package pet.group.shareall.item;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.group.shareall.item.dto.ItemGetDto;
import pet.group.shareall.item.dto.ItemPostDto;
import pet.group.shareall.item.dto.ItemUpdateDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService service;

    @PostMapping()
    public ResponseEntity<ItemGetDto> create(@RequestHeader("X-Sharer-User-Id") Long userId,
                                             @Valid @RequestBody ItemPostDto post) {
        ItemGetDto result = service.createItems(userId, post);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemGetDto> getInfo(@RequestHeader("X-Sharer-User-Id") Long userId,
                                              @PathVariable Long itemId) {
        ItemGetDto infoItem = service.getItem(userId, itemId);
        return ResponseEntity.ok(infoItem);
    }

    @PatchMapping("/{itemId}")
    public ResponseEntity<ItemGetDto> change(@RequestHeader("X-Sharer-User-Id") Long userId,
                                             @PathVariable Long itemId, @Valid @RequestBody ItemUpdateDto dto) {
        ItemGetDto infoItem = service.updateItems(userId, itemId, dto);
        return ResponseEntity.ok(infoItem);
    }

    @GetMapping()
    public ResponseEntity<List<ItemGetDto>> getAll(@RequestHeader("X-Sharer-User-Id") Long userId) {
        List<ItemGetDto> itemsList = service.getAllItems(userId);
        return ResponseEntity.ok(itemsList);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ItemGetDto>> searchItems(@RequestHeader("X-Sharer-User-Id") Long userId,
                                                        @RequestParam(value = "text") String searchString) {
        List<ItemGetDto> itemsList = service.getSearchItems(userId, searchString);
        return ResponseEntity.ok(itemsList);
    }
}

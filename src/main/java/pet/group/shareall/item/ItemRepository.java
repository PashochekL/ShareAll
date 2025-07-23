package pet.group.shareall.item;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {
    List<ItemModel> findAllByUserId(Long userId);

    List<ItemModel> findByAvailable(String available);
    List<ItemModel> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

}

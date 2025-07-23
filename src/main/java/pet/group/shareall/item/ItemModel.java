package pet.group.shareall.item;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.group.shareall.user.UserModel;

@Data
@Table(name = "items")
@Entity
@NoArgsConstructor
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String available;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public ItemModel(String name, String description, String available, UserModel user) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.user = user;
    }
}

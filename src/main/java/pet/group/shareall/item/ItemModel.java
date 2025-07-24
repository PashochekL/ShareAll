package pet.group.shareall.item;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.group.shareall.booking.BookingModel;
import pet.group.shareall.user.UserModel;

import java.util.List;

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

    @OneToMany(mappedBy = "item")
    private List<BookingModel> bookings;

    public ItemModel(String name, String description, String available, UserModel user) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.user = user;
    }
}

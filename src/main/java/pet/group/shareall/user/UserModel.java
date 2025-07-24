package pet.group.shareall.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.group.shareall.booking.BookingModel;
import pet.group.shareall.item.ItemModel;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<ItemModel> items = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<BookingModel> bookings;

    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

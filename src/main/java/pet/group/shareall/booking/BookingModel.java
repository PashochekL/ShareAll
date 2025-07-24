package pet.group.shareall.booking;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.group.shareall.item.ItemModel;
import pet.group.shareall.user.UserModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table(name = "booking")
@Entity
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startBookingDate;
    private LocalDate endBookingDate;
    private String approved;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private ItemModel item;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public BookingModel(LocalDate startBookingDate, LocalDate endBookingDate, String approved,
                        ItemModel item, UserModel user) {
        this.startBookingDate = startBookingDate;
        this.endBookingDate = endBookingDate;
        this.approved = approved;
        this.item = item;
        this.user = user;
    }
}

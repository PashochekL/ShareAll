package pet.group.shareall.booking;

import org.springframework.stereotype.Component;
import pet.group.shareall.booking.dto.BookingGetDto;
import pet.group.shareall.booking.dto.BookingPostDto;
import pet.group.shareall.item.ItemModel;
import pet.group.shareall.user.UserModel;

@Component
public class BookingMapper {

    public BookingModel toEntity(UserModel user, ItemModel item, BookingPostDto dto) {
        return new BookingModel (
                dto.getStartBookingDate(),
                dto.getEndBookingDate(),
                dto.getApproved(),
                item,
                user
        );
    }

    public BookingGetDto toDto(BookingModel booking) {
        return new BookingGetDto(
                booking.getId(),
                booking.getStartBookingDate(),
                booking.getEndBookingDate(),
                booking.getApproved()
        );
    }
}

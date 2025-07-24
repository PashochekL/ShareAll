package pet.group.shareall.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookingGetDto {
    private Long id;
    private LocalDate startBookingDate;
    private LocalDate endBookingDate;
    private String approved;
}

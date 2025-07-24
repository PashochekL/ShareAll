package pet.group.shareall.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookingPostDto {
    @NotNull
    private LocalDate startBookingDate;
    @NotNull
    private LocalDate endBookingDate;
    @NotNull
    private String approved;
    @NotNull
    private Long itemId;
}

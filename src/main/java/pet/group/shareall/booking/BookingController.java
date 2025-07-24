package pet.group.shareall.booking;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.group.shareall.booking.dto.BookingApproveDto;
import pet.group.shareall.booking.dto.BookingGetDto;
import pet.group.shareall.booking.dto.BookingPostDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private final BookingService service;

    @PostMapping()
    public ResponseEntity<BookingGetDto> create(@RequestHeader("X-Sharer-User-Id") Long userId,
                                                @Valid @RequestBody BookingPostDto dto) {
        BookingGetDto result = service.createBooking(userId, dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{bookingId}/approve/{itemId}")
    public ResponseEntity<BookingGetDto> approve(@RequestHeader("X-Sharer-User-Id") Long userId,
                                                 @PathVariable Long itemId, Long bookingId,
                                                 @RequestBody BookingApproveDto dto) {
        BookingGetDto result = service.approveBooking(userId, itemId, bookingId, dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping()
    public ResponseEntity<BookingGetDto> getInfo(@RequestHeader("X-Sharer-User-Id") Long userId,
                                                 @PathVariable Long bookingId) {
        BookingGetDto result = service.getInfoBooking(userId, bookingId);
        return ResponseEntity.ok(result);
    }
}

package pet.group.shareall.booking;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pet.group.shareall.booking.dto.BookingApproveDto;
import pet.group.shareall.booking.dto.BookingGetDto;
import pet.group.shareall.booking.dto.BookingPostDto;
import pet.group.shareall.exception.NotFoundException;
import pet.group.shareall.exception.NotFreeItem;
import pet.group.shareall.item.ItemModel;
import pet.group.shareall.item.ItemRepository;
import pet.group.shareall.user.UserModel;
import pet.group.shareall.user.UserRepository;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final ItemRepository itemRepo;
    private final BookingMapper mapper;

    public BookingGetDto createBooking(Long userId, BookingPostDto dto) {
        UserModel user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        ItemModel item = itemRepo.findById(dto.getItemId()).orElseThrow(() -> new NotFoundException("Вещь не найдена"));

        if (item.getAvailable() == null || item.getAvailable().equals("false")) {
            throw new NotFreeItem("Данная вещь уже забронирована");
        }

        BookingModel booking = mapper.toEntity(user, item, dto);
        bookingRepo.save(booking);

        return mapper.toDto(booking);
    }

    public BookingGetDto approveBooking(Long userId, Long itemId, Long bookingId, BookingApproveDto dto) {
        UserModel user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        BookingModel booking = bookingRepo.findById(bookingId).
                orElseThrow(() -> new NotFoundException("Такого бронирования не найдено"));
        itemRepo.findById(itemId).orElseThrow(() -> new NotFoundException("Вещь не найдена"));

        ItemModel item = user.getItems().stream().filter(itemModel -> itemModel.getId().equals(itemId)).findFirst()
                .orElseThrow(() -> new NotFoundException("Вещь не существует или не принадлежит этому пользователю"));

        item.setAvailable(dto.getApproved());
        itemRepo.save(item);

        return mapper.toDto(booking);
    }

    public BookingGetDto getInfoBooking(Long userId, Long bookingId) {
        userRepo.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        BookingModel booking = bookingRepo.findById(bookingId).
                orElseThrow(() -> new NotFoundException("Такого бронирования не найдено"));

        return mapper.toDto(booking);
    }
}

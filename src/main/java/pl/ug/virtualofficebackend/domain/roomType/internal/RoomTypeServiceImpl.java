package pl.ug.virtualofficebackend.domain.roomType.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.roomType.boundary.RoomTypeService;
import pl.ug.virtualofficebackend.domain.roomType.entity.RoomType;

import javax.validation.Valid;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    private RoomTypeRepository roomTypeRepository;

    // TODO: Add exception handling (https://www.baeldung.com/spring-mvc-custom-validator)

    @Autowired
    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public RoomType save(@Valid RoomType roomType) {
        return this.roomTypeRepository.save(roomType);
    }

    public RoomType get(long id) {
        return this.roomTypeRepository.findById(id).orElse(null);
    }

    public List<RoomType> getAll() {
        return this.roomTypeRepository.findAll();
    }

    public RoomType put(long id, @Valid RoomType roomType) {
        roomType.setId(id);
        return this.roomTypeRepository.save(roomType);
    }

    public void delete(long id) {
        this.roomTypeRepository.deleteById(id);
    }
}

package pl.ug.virtualofficebackend.domain.room.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.room.boundary.RoomService;
import pl.ug.virtualofficebackend.domain.room.entity.Room;

import javax.validation.Valid;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room save(@Valid Room room) {
        return this.roomRepository.save(room);
    }

    public List<Room> save(@Valid List<Room> rooms) {
        return this.roomRepository.saveAll(rooms);
    }

    public Room get(long id) {
        return this.roomRepository.findById(id).orElse(null);
    }

    public List<Room> getAll() {
        return this.roomRepository.findAll();
    }

    public Room put(long id, @Valid Room room) {
        room.setId(id);
        return this.roomRepository.save(room);
    }

    public void delete(long id) {
        this.roomRepository.deleteById(id);
    }
}

package andrew.coursework.service.characteristic;

import andrew.coursework.model.Characteristic;

import java.util.List;

public interface ICharacteristicService {
    List<Characteristic> getAll();
    Characteristic insert(Characteristic characteristic);
    Characteristic update(Characteristic characteristic);
    Characteristic getById(int id);
    void delete(int id);
}

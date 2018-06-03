package andrew.coursework.service.characteristic;

import andrew.coursework.model.Characteristic;
import andrew.coursework.repository.CharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicService implements ICharacteristicService{
    @Autowired
    CharacteristicRepository repository;
    @Override
    public List<Characteristic> getAll() {
        return (List<Characteristic>)repository.findAll();
    }

    @Override
    public Characteristic insert(Characteristic characteristic) {
        return repository.save(characteristic);
    }

    @Override
    public Characteristic update(Characteristic characteristic) {
        return repository.save(characteristic);
    }

    @Override
    public Characteristic getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

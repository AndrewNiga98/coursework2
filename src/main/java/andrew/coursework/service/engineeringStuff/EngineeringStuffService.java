package andrew.coursework.service.engineeringStuff;

import andrew.coursework.model.EngineeringStuff;
import andrew.coursework.repository.EngineeringStuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineeringStuffService implements IEngineeringStuffService {
    @Autowired
    EngineeringStuffRepository repository;
    @Override
    public List<EngineeringStuff> getAll() {
        return (List<EngineeringStuff>)repository.findAll();
    }

    @Override
    public EngineeringStuff insert(EngineeringStuff engineeringStuff) {
        return repository.save(engineeringStuff);
    }

    @Override
    public EngineeringStuff update(EngineeringStuff engineeringStuff) {
        return repository.save(engineeringStuff);
    }

    @Override
    public EngineeringStuff getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}

package andrew.coursework.service.objectsCharacteristics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import andrew.coursework.model.Objects_characteristics;
import andrew.coursework.repository.ObjectsCharacteristicsRepository;

@Service
public class ObjectsCharacteristicsService implements IObjectsCharacteristicsService  {

    @Autowired
    ObjectsCharacteristicsRepository repository;
    @Override
    public List<Objects_characteristics> getAll() {
        return (List<Objects_characteristics>)repository.findAll();
    }

    @Override
    public Objects_characteristics insert(Objects_characteristics object) {
        return repository.save(object);
    }

    @Override
    public Objects_characteristics update(Objects_characteristics object) {
        return repository.save(object);
    }

    @Override
    public Objects_characteristics getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}

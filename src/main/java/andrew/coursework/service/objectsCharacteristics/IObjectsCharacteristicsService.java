package andrew.coursework.service.objectsCharacteristics;

import andrew.coursework.model.Objects_characteristics;

import java.util.List;

public interface IObjectsCharacteristicsService {

    List<Objects_characteristics> getAll();
    Objects_characteristics insert(Objects_characteristics object);
    Objects_characteristics update(Objects_characteristics object);
    Objects_characteristics getById(int id);
    void delete(int id);
}


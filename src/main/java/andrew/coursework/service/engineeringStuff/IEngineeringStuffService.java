package andrew.coursework.service.engineeringStuff;

import andrew.coursework.model.EngineeringStuff;

import java.util.List;

public interface IEngineeringStuffService {
    List<EngineeringStuff> getAll();
    EngineeringStuff insert(EngineeringStuff engineeringStuff);
    EngineeringStuff update(EngineeringStuff engineeringStuff);
    EngineeringStuff getById(int id);
    void delete(int id);
}

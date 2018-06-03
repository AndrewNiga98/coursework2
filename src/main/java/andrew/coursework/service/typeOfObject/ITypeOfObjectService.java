package andrew.coursework.service.typeOfObject;

import andrew.coursework.model.TypeOfObject;

import java.util.List;

public interface ITypeOfObjectService {
    List<TypeOfObject> getAll();
    TypeOfObject insert(TypeOfObject typeOfObject);
    TypeOfObject update(TypeOfObject typeOfObject);
    TypeOfObject getById(int id);
    void delete(int id);
}

package andrew.coursework.service.object;

import andrew.coursework.model.Object;

import java.util.List;

public interface IObjectService {
    List<Object> getAll();
    Object insert(Object object);
    Object update(Object object);
    Object getById(int id);
    void delete(int id);
}

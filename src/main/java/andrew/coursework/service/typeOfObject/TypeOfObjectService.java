package andrew.coursework.service.typeOfObject;

import andrew.coursework.model.TypeOfObject;
import andrew.coursework.repository.TypeOfObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfObjectService implements ITypeOfObjectService{
    @Autowired
    TypeOfObjectRepository repository;
    @Override
    public List<TypeOfObject> getAll() {
        return (List<TypeOfObject>)repository.findAll();
    }

    @Override
    public TypeOfObject insert(TypeOfObject typeOfObject) {
        return repository.save(typeOfObject);
    }

    @Override
    public TypeOfObject update(TypeOfObject typeOfObject) {
        return repository.save(typeOfObject);
    }

    @Override
    public TypeOfObject getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

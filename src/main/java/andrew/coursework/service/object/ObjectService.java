package andrew.coursework.service.object;

import andrew.coursework.model.Object;
import andrew.coursework.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectService implements IObjectService{
    @Autowired
    ObjectRepository repository;
    @Override
    public List<Object> getAll() {
        return (List<Object>)repository.findAll();
    }

    @Override
    public Object insert(andrew.coursework.model.Object object) {
        return repository.save(object);
    }

    @Override
    public Object update(andrew.coursework.model.Object object) {
        return repository.save(object);
    }

    @Override
    public Object getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

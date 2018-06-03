package andrew.coursework.service.constructionTechnology;

import andrew.coursework.model.ConstructionTechnology;
import andrew.coursework.repository.ConstructionTechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructionTechnologyService implements IConstructionTechnologyService{
    @Autowired
    ConstructionTechnologyRepository repository;
    @Override
    public List<ConstructionTechnology> getAll() {
        return (List<ConstructionTechnology>)repository.findAll();
    }

    @Override
    public ConstructionTechnology insert(ConstructionTechnology constructionTechnology) {
        return repository.save(constructionTechnology);
    }

    @Override
    public ConstructionTechnology update(ConstructionTechnology constructionTechnology) {
        return repository.save(constructionTechnology);
    }

    @Override
    public ConstructionTechnology getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

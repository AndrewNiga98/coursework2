package andrew.coursework.service.material;

import andrew.coursework.model.Material;
import andrew.coursework.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService implements IMaterialService{
    @Autowired
    MaterialRepository repository;
    @Override
    public List<Material> getAll() {
        return (List<Material>)repository.findAll();
    }

    @Override
    public Material insert(Material machinery) {
        return repository.save(machinery);
    }

    @Override
    public Material update(Material machinery) {
        return repository.save(machinery);
    }

    @Override
    public Material getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

package andrew.coursework.service.machinery;

import andrew.coursework.model.Machinery;
import andrew.coursework.repository.MachineryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineryService implements IMachineryService{
    @Autowired
    MachineryRepository repository;
    @Override
    public List<Machinery> getAll() {
        return (List<Machinery>)repository.findAll();
    }

    @Override
    public Machinery insert(Machinery machinery) {
        return repository.save(machinery);
    }

    @Override
    public Machinery update(Machinery machinery) {
        return repository.save(machinery);
    }

    @Override
    public Machinery getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

package andrew.coursework.service.subordinatePersonnel;

import andrew.coursework.model.SubordinatePersonnel;
import andrew.coursework.repository.SubordinatePersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubordinatePersonnelService implements ISubordinatePersonnelService{
    @Autowired
    SubordinatePersonnelRepository repository;
    @Override
    public List<SubordinatePersonnel> getAll() {
        return (List<SubordinatePersonnel>)repository.findAll();
    }

    @Override
    public SubordinatePersonnel insert(SubordinatePersonnel subordinatePersonnel) {
        return repository.save(subordinatePersonnel);
    }

    @Override
    public SubordinatePersonnel update(SubordinatePersonnel subordinatePersonnel) {
        return repository.save(subordinatePersonnel);
    }

    @Override
    public SubordinatePersonnel getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

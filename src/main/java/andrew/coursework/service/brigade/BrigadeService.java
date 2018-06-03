package andrew.coursework.service.brigade;

import andrew.coursework.model.Brigade;
import andrew.coursework.repository.BrigadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrigadeService implements IBrigadeService{
    @Autowired
    BrigadeRepository repository;
    @Override
    public List<Brigade> getAll() {
        return (List<Brigade>)repository.findAll();
    }

    @Override
    public Brigade insert(Brigade area) {
        return repository.save(area);
    }

    @Override
    public Brigade update(Brigade area) {
        return repository.save(area);
    }

    @Override
    public Brigade getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

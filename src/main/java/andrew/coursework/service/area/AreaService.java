package andrew.coursework.service.area;

import andrew.coursework.model.Area;
import andrew.coursework.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements IAreaService {
    @Autowired
    AreaRepository repository;
    @Override
    public List<Area> getAll() {
        return (List<Area>)repository.findAll();
    }

    @Override
    public Area insert(Area area) {
        return repository.save(area);
    }

    @Override
    public Area update(Area area) {
        return repository.save(area);
    }

    @Override
    public Area getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

package andrew.coursework.service.estimate;

import andrew.coursework.model.Estimate;
import andrew.coursework.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstimateService implements IEstimateService{
    @Autowired
    EstimateRepository repository;
    @Override
    public List<Estimate> getAll() {
        return (List<Estimate>)repository.findAll();
    }

    @Override
    public Estimate insert(Estimate estimate) {
        return repository.save(estimate);
    }

    @Override
    public Estimate update(Estimate estimate) {
        return repository.save(estimate);
    }

    @Override
    public Estimate getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}

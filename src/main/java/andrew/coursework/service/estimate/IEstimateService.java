package andrew.coursework.service.estimate;

import andrew.coursework.model.Estimate;

import java.util.List;

public interface IEstimateService {
    List<Estimate> getAll();
    Estimate insert(Estimate estimate);
    Estimate update(Estimate estimate);
    Estimate getById(int id);
    void delete(int id);
}

package andrew.coursework.service.buildingManagement;

import andrew.coursework.model.BuildingManagement;
import andrew.coursework.repository.BuildingManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingManagementService implements IBuildingManagementService{
    @Autowired
    BuildingManagementRepository repository;
    @Override
    public List<BuildingManagement> getAll() {
        return (List<BuildingManagement>)repository.findAll();
    }

    @Override
    public BuildingManagement insert(BuildingManagement buildingManagement) {
        return repository.save(buildingManagement);
    }

    @Override
    public BuildingManagement update(BuildingManagement buildingManagement) {
        return repository.save(buildingManagement);
    }

    @Override
    public BuildingManagement getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    @Override
    public List<BuildingManagement> getAll1()
    {
        return (List<BuildingManagement>)repository.findAll();
    }

}

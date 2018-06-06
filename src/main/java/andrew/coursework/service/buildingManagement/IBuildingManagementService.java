package andrew.coursework.service.buildingManagement;


import andrew.coursework.model.BuildingManagement;

import java.util.List;

public interface IBuildingManagementService {
    List<BuildingManagement> getAll();
    BuildingManagement insert(BuildingManagement buildingManagement);
    BuildingManagement update(BuildingManagement buildingManagement);
    BuildingManagement getById(int id);
    List<BuildingManagement> getAll1();
    void delete(int id);
}

package andrew.coursework.controller;

import andrew.coursework.model.BuildingManagement;
import andrew.coursework.service.buildingManagement.BuildingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class BuildingManagementController {

    @Autowired
    BuildingManagementService service;
    @RequestMapping("/building_management")
    public List<BuildingManagement> getAll() {
        return service.getAll();
    }

    @RequestMapping("/building_management/get")
    public BuildingManagement getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/building_management/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/building_management/insert")
    public BuildingManagement insert(@RequestParam String name, String chief)
    {
        BuildingManagement buildingManagement = new BuildingManagement(name, chief);
        return service.insert(buildingManagement);

    }

    @RequestMapping("/building_management/update")
    public BuildingManagement update(@RequestParam int id, String name, String chief)
    {
        BuildingManagement buildingManagement = new BuildingManagement(name, chief);
        buildingManagement.setId(id);
        return service.update(buildingManagement);

    }
}

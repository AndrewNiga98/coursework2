package andrew.coursework.controller;

import andrew.coursework.model.BuildingManagement;
import andrew.coursework.model.EngineeringStuff;
import andrew.coursework.model.SubordinatePersonnel;
import andrew.coursework.service.subordinatePersonnel.SubordinatePersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SubordinatePersonnelController {

    @Autowired
    SubordinatePersonnelService service;
    @RequestMapping("/subordinate_personnel")
    public List<SubordinatePersonnel> getAll()
    {
        List<SubordinatePersonnel> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(SubordinatePersonnel::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/subordinate_personnel/get")
    public SubordinatePersonnel getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/subordinate_personnel/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/subordinate_personnel/insert")
    public SubordinatePersonnel insert(@RequestParam String position, int buildingmanagementId, int engineeringstuffId) {

        BuildingManagement buildingManagement = new BuildingManagement(null, null);
        buildingManagement.setId(buildingmanagementId);
        EngineeringStuff engineeringStuff = new EngineeringStuff(null, null, null);
        engineeringStuff.setId(engineeringstuffId);
        SubordinatePersonnel subordinatePersonnel = new SubordinatePersonnel(position, buildingManagement, engineeringStuff);
        return service.insert(subordinatePersonnel);

    }

    @RequestMapping("/subordinate_personnel/update")
    public SubordinatePersonnel update(@RequestParam int id, String position, int buildingmanagementId, int engineeringstuffId)
    {
        BuildingManagement buildingManagement = new BuildingManagement(null, null);
        buildingManagement.setId(buildingmanagementId);
        EngineeringStuff engineeringStuff = new EngineeringStuff(null, null, null);
        engineeringStuff.setId(engineeringstuffId);
        SubordinatePersonnel subordinatePersonnel = new SubordinatePersonnel(position, buildingManagement, engineeringStuff);
        subordinatePersonnel.setId(id);
        return service.insert(subordinatePersonnel);

    }
}

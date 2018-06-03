package andrew.coursework.controller;

import andrew.coursework.model.BuildingManagement;
import andrew.coursework.model.EngineeringStuff;
import andrew.coursework.service.engineeringStuff.EngineeringStuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EngineeringStuffController {

    @Autowired
    EngineeringStuffService service;
    @RequestMapping("/engineering_stuff")
    public List<EngineeringStuff> getAll()
    {
        List<EngineeringStuff> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(EngineeringStuff::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/engineering_stuff/get")
    public EngineeringStuff getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/engineering_stuff/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/engineering_stuff/insert")
    public EngineeringStuff insert(@RequestParam  String name, String position, int buildingId)
    {
        BuildingManagement buildingManagement = new BuildingManagement(null, null);
        buildingManagement.setId(buildingId);
        EngineeringStuff engineeringStuff = new EngineeringStuff(name, position, buildingManagement);
        return service.insert(engineeringStuff);
    }

    @RequestMapping("/engineering_stuff/update")
    public EngineeringStuff update(@RequestParam int id, String name, String position, int buildingId)
    {
        BuildingManagement buildingManagement = new BuildingManagement(null, null);
        buildingManagement.setId(buildingId);
        EngineeringStuff engineeringStuff = new EngineeringStuff(name, position, buildingManagement);
        engineeringStuff.setId(id);
        return service.insert(engineeringStuff);

    }
}

package andrew.coursework.controller;

import andrew.coursework.model.Area;
import andrew.coursework.model.BuildingManagement;
import andrew.coursework.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AreaController {
    @Autowired
    AreaService service;

    @RequestMapping("/areas")
    public List<Area> getAll()
    {
        List<Area> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Area::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/areas/get")
    public Area getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/areas/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/areas/insert")
    public Area insert(@RequestParam String name, String chief, int buildingManagementId)
    {
        BuildingManagement buildingManagement = new BuildingManagement(null, null);
        buildingManagement.setId(buildingManagementId);
        Area area = new Area(name, chief, buildingManagement);
        return service.insert(area);

    }

    @RequestMapping("/areas/update")
    public Area update(@RequestParam int id, String name, String chief, int buildingManagementId)
    {
        BuildingManagement buildingManagement = new BuildingManagement(null, null);
        buildingManagement.setId(buildingManagementId);
        Area area = new Area(name, chief, buildingManagement);
        area.setId(id);
        return service.update(area);

    }
}

package andrew.coursework.controller;

import andrew.coursework.model.Brigade;
import andrew.coursework.model.ConstructionTechnology;
import andrew.coursework.model.Object;
import andrew.coursework.service.brigade.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BrigadeController {

    @Autowired
    BrigadeService service;
    @RequestMapping("/brigades")
    public List<Brigade> getAll()
    {
        List<Brigade> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Brigade::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/brigades/get")
    public Brigade getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/brigades/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/brigades/insert")
    public Brigade insert(@RequestParam  String brigadier, int constructionTechnologyId, int objectId)
    {
        ConstructionTechnology constructionTechnology = new ConstructionTechnology(null);
        Object object = new Object(null, null, null);
        object.setId(objectId);
        constructionTechnology.setId(constructionTechnologyId);
        Brigade brigade = new Brigade(brigadier, constructionTechnology, object);
        return service.insert(brigade);


    }

    @RequestMapping("/brigades/update")
    public Brigade update(@RequestParam int id, String brigadier, int constructionTechnologyId, int objectId)
    {
        /*BuildingManagement buildingManagement = new BuildingManagement(null);
        buildingManagement.setId(buildingManagementId);
        Area area = new Area(chief_of_area, buildingManagement);
        area.setId(id);
        return service.update(area);*/

        ConstructionTechnology constructionTechnology = new ConstructionTechnology(null);
        constructionTechnology.setId(constructionTechnologyId);
        Object object = new Object(null, null, null);
        object.setId(objectId);
        Brigade brigade = new Brigade(brigadier, constructionTechnology, object);
        brigade.setId(id);
        return service.update(brigade);

    }
}

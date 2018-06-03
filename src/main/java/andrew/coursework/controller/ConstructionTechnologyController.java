package andrew.coursework.controller;

import andrew.coursework.model.ConstructionTechnology;
import andrew.coursework.service.constructionTechnology.ConstructionTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ConstructionTechnologyController {

    @Autowired
    ConstructionTechnologyService service;
    @RequestMapping("/construction_technology")
    public List<ConstructionTechnology> getAll()
    {
        List<ConstructionTechnology> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(ConstructionTechnology::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/construction_technology/get")
    public ConstructionTechnology getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/construction_technology/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/construction_technology/insert")
    public ConstructionTechnology insert(@RequestParam  String name)
    {
        ConstructionTechnology constructionTechnology = new ConstructionTechnology(name);
        return service.insert(constructionTechnology);

    }

    @RequestMapping("/construction_technology/update")
    public ConstructionTechnology update(@RequestParam int id, String name)
    {
        ConstructionTechnology constructionTechnology =  new ConstructionTechnology(name);
        constructionTechnology.setId(id);
        return service.update(constructionTechnology);

    }
}

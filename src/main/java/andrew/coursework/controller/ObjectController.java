package andrew.coursework.controller;

import andrew.coursework.model.Area;
import andrew.coursework.model.Object;
import andrew.coursework.model.TypeOfObject;
import andrew.coursework.service.object.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ObjectController {

    @Autowired
    ObjectService service;
    @RequestMapping("/objects")
    public List<Object> getAll()
    {
        List<Object> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Object::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("objects/get")
    public Object getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/objects/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/objects/insert")
    public Object insert(@RequestParam String name, int typeId, int areaId) {

        TypeOfObject typeOfObject = new TypeOfObject(null);
        typeOfObject.setId(typeId);
        Area area = new Area(null, null, null);
        area.setId(areaId);
        Object object = new Object(name, typeOfObject, area);
        return service.insert(object);

    }

    @RequestMapping("/objects/update")
    public Object update(@RequestParam int id, String name, int typeId, int areaId)
    {
        TypeOfObject typeOfObject = new TypeOfObject(null);
        typeOfObject.setId(typeId);
        Area area = new Area(null, null, null);
        area.setId(areaId);
        Object object = new Object(name, typeOfObject, area);
        object.setId(id);
        return service.insert(object);

    }

}

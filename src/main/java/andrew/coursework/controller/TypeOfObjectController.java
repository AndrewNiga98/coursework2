package andrew.coursework.controller;

import andrew.coursework.model.TypeOfObject;
import andrew.coursework.service.typeOfObject.TypeOfObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TypeOfObjectController {

    @Autowired
    TypeOfObjectService service;
    @RequestMapping("/type_of_object")
    public List<TypeOfObject> getAll()
    {
        List<TypeOfObject> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(TypeOfObject::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/type_of_object/get")
    public TypeOfObject getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/type_of_object/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/type_of_object/insert")
    public TypeOfObject insert(@RequestParam String name) {

        TypeOfObject typeOfObject = new TypeOfObject(name);
        return service.insert(typeOfObject);

    }

    @RequestMapping("/type_of_object/update")
    public TypeOfObject update(@RequestParam int id, String name)
    {
        TypeOfObject typeOfObject = new TypeOfObject(name);
        typeOfObject.setId(id);
        return service.insert(typeOfObject);
    }
}

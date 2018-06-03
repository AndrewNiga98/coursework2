package andrew.coursework.controller;

import andrew.coursework.model.Material;
import andrew.coursework.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MaterialController {

    @Autowired
    MaterialService service;
    @RequestMapping("/material")
    public List<Material> getAll()
    {
        List<Material> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Material::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/material/get")
    public Material getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/material/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/material/insert")
    public Material insert(@RequestParam String name) {

        Material material = new Material(name);
        return service.insert(material);

    }

    @RequestMapping("/material/update")
    public Material update(@RequestParam int id, String name)
    {
        Material material = new Material(name);
        material.setId(id);
        return service.update(material);

    }
}

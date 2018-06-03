package andrew.coursework.controller;

import andrew.coursework.model.Machinery;
import andrew.coursework.service.machinery.MachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MachineryController {

    @Autowired
    MachineryService service;
    @RequestMapping("/machinery")
    public List<Machinery> getAll()
    {
        List<Machinery> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Machinery::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/machinery/get")
    public Machinery getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/machinery/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/machinery/insert")
    public Machinery insert(@RequestParam String name) {

        Machinery machinery = new Machinery(name);
        return service.insert(machinery);

    }

    @RequestMapping("/machinery/update")
    public Machinery update(@RequestParam int id, String name)
    {
        Machinery machinery = new Machinery(name);
        machinery.setId(id);
        return service.update(machinery);

    }
}

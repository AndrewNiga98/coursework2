package andrew.coursework.controller;

import andrew.coursework.model.Characteristic;
import andrew.coursework.service.characteristic.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CharacteristicController {

    @Autowired
    CharacteristicService service;
    @RequestMapping("/characteristics")
    public List<Characteristic> getAll()
    {
        List<Characteristic> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Characteristic::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/characteristics/get")
    public Characteristic getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/characteristics/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/characteristics/insert")
    public Characteristic insert(@RequestParam  String name)
    {
      Characteristic characteristic = new Characteristic(name);
      return service.insert(characteristic);

    }

    @RequestMapping("/characteristics/update")
    public Characteristic update(@RequestParam int id, String name)
    {
        Characteristic characteristic =  new Characteristic(name);
        characteristic.setId(id);
        return service.update(characteristic);

    }
}

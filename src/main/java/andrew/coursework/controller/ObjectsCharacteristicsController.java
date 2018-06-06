package andrew.coursework.controller;

import andrew.coursework.model.Characteristic;
import andrew.coursework.model.Object;
import andrew.coursework.model.Objects_characteristics;
import andrew.coursework.service.objectsCharacteristics.ObjectsCharacteristicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api")
public class ObjectsCharacteristicsController {

    @Autowired
    ObjectsCharacteristicsService service;
    @RequestMapping("/objects_characteristics")
    public List<Objects_characteristics> getAll()
    {
        List<Objects_characteristics> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Objects_characteristics::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/objects_characteristics/get")
    public Objects_characteristics getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/objects_characteristics/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/objects_characteristics/insert")
    public Objects_characteristics insert(@RequestParam int objectId, int characteristicId, String value ) {

        Object object = new Object(null, null, null);
        object.setId(objectId);
        Characteristic characteristic = new Characteristic(null);
        characteristic.setId(characteristicId);
        Objects_characteristics objects_characteristics = new Objects_characteristics(object, characteristic, value);
        return service.insert(objects_characteristics);

    }

    @RequestMapping("/objects_characteristics/update")
    public Objects_characteristics update(@RequestParam int id, int objectId, int characteristicId, String value )
    {
        Object object = new Object(null, null, null);
        object.setId(objectId);
        Characteristic characteristic = new Characteristic(null);
        characteristic.setId(characteristicId);
        Objects_characteristics objects_characteristics = new Objects_characteristics(object, characteristic, value);
        objects_characteristics.setId(id);
        return service.update(objects_characteristics);

    }
}

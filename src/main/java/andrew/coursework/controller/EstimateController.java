package andrew.coursework.controller;


import andrew.coursework.model.Estimate;
import andrew.coursework.model.Material;
import andrew.coursework.model.Object;
import andrew.coursework.service.estimate.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EstimateController {
    @Autowired
    EstimateService service;
    @RequestMapping("/estimate")
    public List<Estimate> getAll()
    {
        List<Estimate> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Estimate::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/estimate/get")
    public Estimate getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/estimate/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/estimate/insert")
    public Estimate insert(@RequestParam int amount, int materialId, int objectId)
    {
        Material material = new Material(null);
        material.setId(materialId);
        Object object = new Object(null, null, null);
        object.setId(objectId);
        Estimate estimate = new Estimate(amount, material, object);
        return service.insert(estimate);
    }

    @RequestMapping("/estimate/update")
    public Estimate update(@RequestParam int id, int amount, int materialId, int objectId)
    {
        Material material = new Material(null);
        material.setId(materialId);
        Object object = new Object(null, null, null);
        object.setId(objectId);
        Estimate estimate = new Estimate(amount, material, object);
        estimate.setId(id);
        return service.insert(estimate);

    }

}

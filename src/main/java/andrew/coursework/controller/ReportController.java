package andrew.coursework.controller;

import andrew.coursework.model.Material;
import andrew.coursework.model.Object;
import andrew.coursework.model.Report;
import andrew.coursework.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ReportController {

    @Autowired
    ReportService service;
    @RequestMapping("/report")
    public List<Report> getAll()
    {
        List<Report> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Report::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/report/get")
    public Report getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/report/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/report/insert")
    public Report insert(@RequestParam int amount, Date date, int objectId, int materialId) {

        Object object = new Object(null, null, null);
        object.setId(objectId);
        Material material = new Material(null);
        material.setId(materialId);
        Report report = new Report(amount, date, object, material);
        return service.insert(report);

    }

    @RequestMapping("/report/update")
    public Report update(@RequestParam int id, int amount, Date date, int objectId, int materialId)
    {
        Object object = new Object(null, null, null);
        object.setId(objectId);
        Material material = new Material(null);
        material.setId(materialId);
        Report report = new Report(amount, date, object, material);
        report.setId(id);
        return service.insert(report);

    }
}

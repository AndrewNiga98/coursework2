package andrew.coursework.controller;

import andrew.coursework.model.ConstructionTechnology;
import andrew.coursework.model.Machinery;
import andrew.coursework.model.Object;
import andrew.coursework.model.WorkingSchedule;
import andrew.coursework.service.workingSchedule.WorkingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class WorkingScheduleController {

    @Autowired
    WorkingScheduleService service;
    @RequestMapping("/working_schedule")
    public List<WorkingSchedule> getAll()
    {
        List<WorkingSchedule> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(WorkingSchedule::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/working_schedule/get")
    public WorkingSchedule getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/working_schedule/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/working_schedule/insert")
    public WorkingSchedule insert(@RequestParam LocalDate start_of_job, LocalDate end, int constructionTechnologyId, int objectId, int machineryId) {

        ConstructionTechnology constructionTechnology = new ConstructionTechnology(null);
        constructionTechnology.setId(constructionTechnologyId);
        Object object = new Object(null, null, null);
        object.setId(objectId);
        Machinery machinery = new Machinery(null);
        machinery.setId(machineryId);
        WorkingSchedule workingSchedule = new WorkingSchedule(start_of_job, end, constructionTechnology, object, machinery);
        return service.insert(workingSchedule);



    }

    @RequestMapping("/working_schedule/update")
    public WorkingSchedule update(@RequestParam int id, LocalDate start_of_job, LocalDate end, int constructionTechnologyId, int objectId, int machineryId)
    {
        ConstructionTechnology constructionTechnology = new ConstructionTechnology(null);
        constructionTechnology.setId(constructionTechnologyId);
        Object object = new Object(null, null, null);
        object.setId(objectId);
        Machinery machinery = new Machinery(null);
        machinery.setId(machineryId);
        WorkingSchedule workingSchedule = new WorkingSchedule(start_of_job, end, constructionTechnology, object, machinery);
        workingSchedule.setId(id);
        return service.update(workingSchedule);
    }
}

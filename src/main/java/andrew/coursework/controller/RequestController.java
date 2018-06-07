package andrew.coursework.controller;

import andrew.coursework.model.*;
import andrew.coursework.model.Object;
import andrew.coursework.service.request.RequestService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/request")

public class RequestController {

    @Autowired
    RequestService requestService;

    @RequestMapping("/request1")
    List<BuildingManagement> selectAllBManagement()
    {
        return requestService.selectAllBManagement();
    }

    @RequestMapping("/request2")
    List<Area> selectAllArea()
    {
        return requestService.selectAllArea();
    }

    @RequestMapping("/request3")
    List<EngineeringStuff> selectEngineersByBuildingManagement(@RequestParam int managementId)
    {
        return requestService.selectEngineersByBuildingManagement(managementId);
    }

    @RequestMapping("/request4")
    List<Object> selectObjectByArea(@RequestParam int areaId)
    {
        return requestService.selectObjectByArea(areaId);
    }

    @RequestMapping("/request5")
    List<Object> selectObjectByBuildingManagement(@RequestParam int managementId)
    {
        return requestService.selectObjectByBuildingManagement(managementId);
    }
    @RequestMapping("/request6")
    List<Employee> selectEmployeeByObject(@RequestParam int objectId)
    {
        return requestService.selectEmployeeByObject(objectId);
    }
   /* @RequestMapping("/request7")
    List<WorkingSchedule> selectMachineryByManagement(@RequestParam int managementId)
    {
        return requestService.selectMachineryByManagement(managementId);
    }*/

   @RequestMapping("/request7")
   List<WorkingSchedule> selectMachineryByObject(@RequestParam int objectId)
   {
       return requestService.selectMachineryByObject(objectId);
   }

   @RequestMapping("/request8")
    List<WorkingSchedule> selectMachineryByManagement(@RequestParam int managementId)
   {
       return requestService.selectMachineryByManagement(managementId);
   }

   @RequestMapping("/request9")
   List<Report> selectReportByObject(@RequestParam int objectId)
   {
       return requestService.selectReportByObject(objectId);
   }




}

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




}

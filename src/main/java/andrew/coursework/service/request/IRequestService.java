package andrew.coursework.service.request;

import andrew.coursework.model.*;
import andrew.coursework.model.Object;
import andrew.coursework.repository.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public interface IRequestService {

    List<BuildingManagement> selectAllBManagement();
    List<Area> selectAllArea();
    List<EngineeringStuff> selectEngineersByBuildingManagement(int managementId);
    /*List <EngineeringStuff> selectEngineersByArea(String areaName);*/
    List <Object> selectObjectByBuildingManagement(int managementId);
    List <Object> selectObjectByArea(int areaId);
    List <Employee> selectEmployeeByObject(int objectId);
    List <WorkingSchedule> selectMachineryByObject(int objectId);
    List <WorkingSchedule> selectMachineryByManagement(int managementId);
    List <Report> selectReportByObject(int objectId);
    /* List <Object> selectObjectByScheduleAndTechnology(Date from, Date to, String technology);
    /* List <Object> selectObjectByManagementAndScheduleAndTechnology(Date from, Date to, String technology, String management);
    /* List <ConstructionTechnology> selectTechnologyByDate();
    /* List <ConstructionTechnology> selectTechnologyByDateOnArea(String areaName);
    /* List <ConstructionTechnology> selectTechnologyByDateOnManagement(String managementName);
    /* List <Material> selectMaterial();
    /* List <Material> selectMaterialOnArea(String areaName);
    /* List <Material> selectMaterialOnManagement(String managementName);
    /* List <ConstructionTechnology> selectTechnology(String numberOfBrigade, Date from, Date To);
    /* List <Brigade> selectBrigade(String constructionTechnology, Date from, Date to);*/



}

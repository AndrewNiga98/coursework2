package andrew.coursework.service.request;

import andrew.coursework.model.*;
import andrew.coursework.model.Object;
import org.springframework.stereotype.Service;
import andrew.coursework.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;
@Service
public class RequestService implements IRequestService{

    @Autowired
    BuildingManagementRepository buildingManagementRepository;
    @Autowired
    AreaRepository areaRepository;
    @Autowired
    EngineeringStuffRepository engineeringStuffRepository;
    @Autowired
    ObjectRepository objectRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    WorkingScheduleRepository workingScheduleRepository;
    @Autowired
    ReportRepository reportRepository;
    @Override
    public List<BuildingManagement> selectAllBManagement()
    {
        return buildingManagementRepository.selectAllBManagement();
    }
    @Override
    public List<Area> selectAllArea()
    {
        return areaRepository.selectAllArea();
    }
    @Override
    public List<EngineeringStuff> selectEngineersByBuildingManagement(int managementId)
    {
        return engineeringStuffRepository.selectEngineersByBuildingManagement(managementId);
    }

    @Override
    public List <Object> selectObjectByArea(int areaId)
    {
        return objectRepository.selectObjectByArea(areaId);
    }

    @Override
    public List <Object> selectObjectByBuildingManagement(int managementId)
    {
        return objectRepository.selectObjectByBuildingManagement(managementId);
    }
    @Override
    public List <Employee> selectEmployeeByObject(int objectId)
    {
        return employeeRepository.selectEmployeeByObject(objectId);
    }

    @Override
    public List <WorkingSchedule> selectMachineryByObject(int objectId)
    {
        return workingScheduleRepository.selectMachineryByObject(objectId);
    }

   @Override
    public List <WorkingSchedule> selectMachineryByManagement(int managementId)
    {
        return workingScheduleRepository.selectMachineryByManagement(managementId);
    }
    @Override
    public List <Report> selectReportByObject(int objectId)
    {
        return reportRepository.selectReportByObject(objectId);
    }
    /*@Override
    public List <EngineeringStuff> selectEngineersByArea(String areaName)
    {
        return engineeringStuffRepository.
    }/*


    @Override
    public List <Machinery> selectMachineryByObject(String objectName);
  /*   @Override
    public List <Report> selectReportByObject(String objectName);
  /*   @Override
    public List <Object> selectObjectByScheduleAndTechnology(Date from, Date to, String technology);
  /*   @Override
    public List <Object> selectObjectByManagementAndScheduleAndTechnology(Date from, Date to, String technology, String management);
  /*   @Override
    public List <ConstructionTechnology> selectTechnologyByDate();
  /*   @Override
    public List <ConstructionTechnology> selectTechnologyByDateOnArea(String areaName);
  /*   @Override
    public List <ConstructionTechnology> selectTechnologyByDateOnManagement(String managementName);
  /*   @Override
    public List <Material> selectMaterial();
  /*   @Override
    public List <Material> selectMaterialOnArea(String areaName);
   /*  @Override
    public List <Material> selectMaterialOnManagement(String managementName);
 /*    @Override
    public List <ConstructionTechnology> selectTechnology(String numberOfBrigade, Date from, Date To);
  /*   @Override
    public List <Brigade> selectBrigade(String constructionTechnology, Date from, Date to);*/


}

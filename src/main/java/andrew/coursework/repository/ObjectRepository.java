package andrew.coursework.repository;

import andrew.coursework.model.Object;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectRepository extends CrudRepository<Object, Integer>{

    @Query("select objects From Object objects where objects.area.id=:areaId")
    List<Object> selectObjectByArea(@Param("areaId") int areaId);
    @Query("select objects From Object objects where objects.area.buildingManagement.id=:managementId")
    List<Object> selectObjectByBuildingManagement(@Param("managementId") int managementId);
}

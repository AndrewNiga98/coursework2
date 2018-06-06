package andrew.coursework.repository;

import andrew.coursework.model.Area;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {

    @Query("select area from Area area")
    List<Area> selectAllArea();
}

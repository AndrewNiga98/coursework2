package andrew.coursework.repository;

import andrew.coursework.model.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {
    @Query("select report from Report report where report.object.id=:objectId")
    List<Report> selectReportByObject(@Param("objectId") int objectId);
}

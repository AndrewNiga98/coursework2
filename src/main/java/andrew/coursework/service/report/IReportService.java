package andrew.coursework.service.report;

import andrew.coursework.model.Report;

import java.util.List;

public interface IReportService {

    List<Report> getAll();
    Report insert(Report report);
    Report update(Report report);
    Report getById(int id);
    void delete(int id);
}

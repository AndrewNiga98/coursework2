package andrew.coursework.service.report;

import andrew.coursework.model.Report;
import andrew.coursework.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService{
    @Autowired
    ReportRepository repository;
    @Override
    public List<Report> getAll() {
        return (List<Report>)repository.findAll();
    }

    @Override
    public Report insert(Report report) {
        return repository.save(report);
    }

    @Override
    public Report update(Report report) {
        return repository.save(report);
    }

    @Override
    public Report getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

package andrew.coursework.service.subordinatePersonnel;

import andrew.coursework.model.SubordinatePersonnel;

import java.util.List;

public interface ISubordinatePersonnelService {
    List<SubordinatePersonnel> getAll();
    SubordinatePersonnel insert(SubordinatePersonnel subordinatePersonnel);
    SubordinatePersonnel update(SubordinatePersonnel subordinatePersonnel);
    SubordinatePersonnel getById(int id);
    void delete(int id);
}

package andrew.coursework.service.machinery;

import andrew.coursework.model.Machinery;

import java.util.List;

public interface IMachineryService {
    List<Machinery> getAll();
    Machinery insert(Machinery machinery);
    Machinery update(Machinery machinery);
    Machinery getById(int id);
    void delete(int id);
}

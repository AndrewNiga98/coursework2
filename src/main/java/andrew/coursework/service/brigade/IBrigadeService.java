package andrew.coursework.service.brigade;


import andrew.coursework.model.Brigade;

import java.util.List;

public interface IBrigadeService {
    List<Brigade> getAll();
    Brigade insert(Brigade brigade);
    Brigade update(Brigade brigade);
    Brigade getById(int id);
    void delete(int id);
}

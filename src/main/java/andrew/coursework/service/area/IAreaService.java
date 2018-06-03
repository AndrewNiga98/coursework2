package andrew.coursework.service.area;


import andrew.coursework.model.Area;

import java.util.List;

public interface IAreaService {
    List<Area> getAll();
    Area insert(Area area);
    Area update(Area area);
    Area getById(int id);
    void delete(int id);
}

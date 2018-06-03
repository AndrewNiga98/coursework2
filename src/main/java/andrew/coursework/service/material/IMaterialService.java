package andrew.coursework.service.material;

import andrew.coursework.model.Material;

import java.util.List;

public interface IMaterialService {

    List<Material> getAll();
    Material insert(Material machinery);
    Material update(Material machinery);
    Material getById(int id);
    void delete(int id);
}

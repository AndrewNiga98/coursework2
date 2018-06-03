package andrew.coursework.service.constructionTechnology;

import andrew.coursework.model.ConstructionTechnology;

import java.util.List;

public interface IConstructionTechnologyService {
    List<ConstructionTechnology> getAll();
    ConstructionTechnology insert(ConstructionTechnology constructionTechnology);
    ConstructionTechnology update(ConstructionTechnology constructionTechnology);
    ConstructionTechnology getById(int id);
    void delete(int id);
}

package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "construction_technology")
@EntityListeners(AuditingEntityListener.class)
public class ConstructionTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;

    public ConstructionTechnology(String nameOfTechnology) {
        this.name = nameOfTechnology;
    }
    public ConstructionTechnology()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTechnology() {
        return name;
    }

    public void setNameOfTechnology(String nameOfTechnology) {
        this.name = nameOfTechnology;
    }
}

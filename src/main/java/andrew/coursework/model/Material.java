package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "material")
@EntityListeners(AuditingEntityListener.class)
public class Material {
    @Id
    @GeneratedValue
    public int id;
    public String name;

    public Material(String name) {
        this.name = name;
    }

    public Material() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

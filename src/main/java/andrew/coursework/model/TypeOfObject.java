package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "type_of_object")
@EntityListeners(AuditingEntityListener.class)
public class TypeOfObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;

    public TypeOfObject(String name) {
        this.name = name;
    }

    public TypeOfObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfType() {
        return name;
    }

    public void setNameOfType(String nameOfType) {
        this.name = nameOfType;
    }
}

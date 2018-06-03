package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "object")
@EntityListeners(AuditingEntityListener.class)
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    @ManyToOne
    TypeOfObject typeOfObject;
    @ManyToOne
    Area area;

    public Object(String name_of_object, TypeOfObject typeOfObject, Area area) {
        this.name = name_of_object;
        this.typeOfObject = typeOfObject;
        this.area = area;
    }

    public Object() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_of_object() {
        return name;
    }

    public void setName_of_object(String name_of_object) {
        this.name = name_of_object;
    }

    public TypeOfObject getTypeOfObject() {
        return typeOfObject;
    }

    public void setTypeOfObject(TypeOfObject typeOfObject) {
        this.typeOfObject = typeOfObject;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}

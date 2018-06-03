package andrew.coursework.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "machinery")
@EntityListeners(AuditingEntityListener.class)
public class Machinery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;

    public Machinery(String typeOfMachinery) {
        this.name = typeOfMachinery;
    }

    public Machinery() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfMachinery() {
        return name;
    }

    public void setTypeOfMachinery(String typeOfMachinery) {
        this.name = typeOfMachinery;
    }
}

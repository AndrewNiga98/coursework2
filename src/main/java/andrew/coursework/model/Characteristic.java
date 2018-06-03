package andrew.coursework.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "characteristic")
@EntityListeners(AuditingEntityListener.class)
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;

    public Characteristic(String name) {
        this.name = name;
    }

    public Characteristic()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCharacteristic() {
        return name;
    }

    public void setNameOfCharacteristic(String name) {
        this.name = name;
    }
}

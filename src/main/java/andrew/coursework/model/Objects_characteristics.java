package andrew.coursework.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "objects_characteristics")
@EntityListeners(AuditingEntityListener.class)
public class Objects_characteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    //@Column(name = "object_id")
    @ManyToOne(fetch=FetchType.EAGER)
    Object object;
    //@Column(name = "characteristic_id")
    @ManyToOne(fetch=FetchType.EAGER)
    Characteristic characteristic;
    @Column(name = "value")
    public String value;

    public Objects_characteristics (Object object, Characteristic characteristic, String value)
    {
        this.object = object;
        this.characteristic = characteristic;
        this.value = value;
    }

    public Objects_characteristics()
    {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }
}

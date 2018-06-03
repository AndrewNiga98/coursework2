package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "building_management")
@EntityListeners(AuditingEntityListener.class)
public class BuildingManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_of_management") //вказуєш назву рядка таблиці, щоб не міняти модель
    public int id;
    public String name;
    @Column(name = "chief_of_management") //тут теж
    public String chief;

    public BuildingManagement(String name, String chief)
    {
        this.name = name;
        this.chief = chief;
    }

   public BuildingManagement()
   {

   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getchief() {
        return chief;
    }

    public void setchief(String chief) {
        this.chief = chief;
    }
}

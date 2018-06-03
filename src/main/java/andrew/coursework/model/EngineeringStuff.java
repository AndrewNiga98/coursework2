package andrew.coursework.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "engineering_stuff")
@EntityListeners(AuditingEntityListener.class)
public class EngineeringStuff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String position;
    @ManyToOne
    BuildingManagement buildingManagement;

    public EngineeringStuff(String fullname, String position, BuildingManagement buildingManagement) {
        this.name = fullname;
        this.position = position;
        this.buildingManagement = buildingManagement;
    }

    public EngineeringStuff()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return name;
    }

    public void setFullname(String fullname) {
        this.name = fullname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BuildingManagement getBuildingManagement() {
        return buildingManagement;
    }

    public void setBuildingManagement(BuildingManagement buildingManagement) {
        this.buildingManagement = buildingManagement;
    }
}

package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "subordinate_personnel")
@EntityListeners(AuditingEntityListener.class)
public class SubordinatePersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String position;
    @ManyToOne
    BuildingManagement buildingManagement;
    @ManyToOne
    EngineeringStuff engineeringStuff;

    public SubordinatePersonnel(String position, BuildingManagement buildingManagement, EngineeringStuff engineeringStuff) {
        this.position = position;
        this.buildingManagement = buildingManagement;
        this.engineeringStuff = engineeringStuff;
    }

    public SubordinatePersonnel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public EngineeringStuff getEngineeringStuff() {
        return engineeringStuff;
    }

    public void setEngineeringStuff(EngineeringStuff engineeringStuff) {
        this.engineeringStuff = engineeringStuff;
    }
}

package andrew.coursework.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "area")
@EntityListeners(AuditingEntityListener.class)

public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String name;
    private String chief_of_area;
    @ManyToOne
    private BuildingManagement buildingManagement;

    public Area(String name, String chief_of_area, BuildingManagement buildingManagement)
    {
        this.name = name;
        this.chief_of_area = chief_of_area;
        this.buildingManagement = buildingManagement;
    }

    public Area ()
    {

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

    public String getChief_of_area() {
        return chief_of_area;
    }

    public void setChief_of_area(String chief_of_area) {
        this.chief_of_area = chief_of_area;
    }

    public BuildingManagement getBuildingManagement() {
        return buildingManagement;
    }

    public void setBuildingManagement(BuildingManagement buildingmanagement) {
        this.buildingManagement = buildingmanagement;
    }
}

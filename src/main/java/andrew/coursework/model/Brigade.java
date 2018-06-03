package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "brigade")
@EntityListeners(AuditingEntityListener.class)
public class Brigade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String brigadier;
    @ManyToOne
    ConstructionTechnology constructionTechnology;
    @ManyToOne
    Object object; //CHANGE

    public Brigade(String brigadier, ConstructionTechnology constructionTechnology, Object object)
    {
        this.brigadier = brigadier;
        this.constructionTechnology = constructionTechnology;
        this.object = object;
    }

    public Brigade()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrigadier() {
        return brigadier;
    }

    public void setBrigadier(String brigadier) {
        this.brigadier = brigadier;
    }

    public ConstructionTechnology getConstructionTechnology() {
        return constructionTechnology;
    }

    public void setConstructionTechnology(ConstructionTechnology constructionTechnology) {
        this.constructionTechnology = constructionTechnology;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

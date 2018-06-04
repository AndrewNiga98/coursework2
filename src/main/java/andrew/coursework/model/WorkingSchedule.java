package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "working_schedule")
@EntityListeners(AuditingEntityListener.class)
public class WorkingSchedule {

    @Id
    @GeneratedValue
    public int id;
    public Date startOfJob;
    public Date endOfJob;
    @ManyToOne
    ConstructionTechnology constructionTechnology;
    @ManyToOne
    Object object;
    @ManyToOne
    Machinery machinery;

    public WorkingSchedule(Date startOfJob, Date endOfJob, ConstructionTechnology constructionTechnology, Object object, Machinery machinery) {
        this.startOfJob = startOfJob;
        this.endOfJob = endOfJob;
        this.constructionTechnology = constructionTechnology;
        this.object = object;
        this.machinery = machinery;
    }

    public WorkingSchedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartOfJob() {
        return startOfJob;
    }

    public void setStartOfJob(Date startOfJob) {
        this.startOfJob = startOfJob;
    }

    public Date getEndOfJob() {
        return endOfJob;
    }

    public void setEndOfJob(Date endOfJob) {
        this.endOfJob = endOfJob;
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

    public Machinery getMachinery() {
        return machinery;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
    }
}

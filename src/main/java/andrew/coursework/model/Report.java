package andrew.coursework.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "Report")
@EntityListeners(AuditingEntityListener.class)
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public int spentAmount;
    public Date endOfJob;
    @ManyToOne
    Object object;
    @ManyToOne
    Material material;

    public Report(int spentAmount, Date endOfJob, Object object, Material material) {
        this.spentAmount = spentAmount;
        this.endOfJob = endOfJob;
        this.object = object;
        this.material = material;
    }

    public Report() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(int spentAmount) {
        this.spentAmount = spentAmount;
    }

    public Date getEndOfJob() {
        return endOfJob;
    }

    public void setEndOfJob(Date endOfJob) {
        this.endOfJob = endOfJob;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}

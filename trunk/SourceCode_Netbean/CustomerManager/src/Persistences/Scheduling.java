/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistences;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author db2admin
 */
@Entity
@Table(name = "SCHEDULING", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Scheduling.findAll", query = "SELECT s FROM Scheduling s"),
    @NamedQuery(name = "Scheduling.findById", query = "SELECT s FROM Scheduling s WHERE s.id = :id"),
    @NamedQuery(name = "Scheduling.findByTime", query = "SELECT s FROM Scheduling s WHERE s.time = :time"),
    @NamedQuery(name = "Scheduling.findByMinute", query = "SELECT s FROM Scheduling s WHERE s.minute = :minute"),
    @NamedQuery(name = "Scheduling.findByDateschedule", query = "SELECT s FROM Scheduling s WHERE s.dateschedule = :dateschedule")})
public class Scheduling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "TIME")
    private Integer time;
    @Column(name = "MINUTE")
    private Integer minute;
    @Column(name = "DATESCHEDULE")
    @Temporal(TemporalType.DATE)
    private Date dateschedule;

    public Scheduling() {
    }

    public Scheduling(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Date getDateschedule() {
        return dateschedule;
    }

    public void setDateschedule(Date dateschedule) {
        this.dateschedule = dateschedule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scheduling)) {
            return false;
        }
        Scheduling other = (Scheduling) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return time + ":" + minute;
    }

}

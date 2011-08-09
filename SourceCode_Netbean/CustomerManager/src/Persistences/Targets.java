/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistences;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author db2admin
 */
@Entity
@Table(name = "TARGETS", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Targets.findAll", query = "SELECT t FROM Targets t"),
    @NamedQuery(name = "Targets.findById", query = "SELECT t FROM Targets t WHERE t.id = :id"),
    @NamedQuery(name = "Targets.findByMonth", query = "SELECT t FROM Targets t WHERE t.month = :month"),
    @NamedQuery(name = "Targets.findByYear", query = "SELECT t FROM Targets t WHERE t.year = :year"),
    @NamedQuery(name = "Targets.findByTarget", query = "SELECT t FROM Targets t WHERE t.target = :target")})
public class Targets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "MONTH")
    private Integer month;
    @Column(name = "YEAR")
    private Integer year;
    @Column(name = "TARGET")
    private Long target;

    public Targets() {
    }

    public Targets(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
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
        if (!(object instanceof Targets)) {
            return false;
        }
        Targets other = (Targets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Targets[id=" + id + "]";
    }

}

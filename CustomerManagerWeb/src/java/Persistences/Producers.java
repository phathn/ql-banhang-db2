/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistences;

import java.io.Serializable;
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
 * @author letuan
 */
@Entity
@Table(name = "PRODUCERS", catalog = "", schema = "DB2AMIN")
@NamedQueries({
    @NamedQuery(name = "Producers.findAll", query = "SELECT p FROM Producers p"),
    @NamedQuery(name = "Producers.findById", query = "SELECT p FROM Producers p WHERE p.id = :id"),
    @NamedQuery(name = "Producers.findByName", query = "SELECT p FROM Producers p WHERE p.name = :name"),
    @NamedQuery(name = "Producers.findByNation", query = "SELECT p FROM Producers p WHERE p.nation = :nation")})
public class Producers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", length = 150)
    private String name;
    @Column(name = "NATION", length = 150)
    private String nation;

    public Producers() {
    }

    public Producers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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
        if (!(object instanceof Producers)) {
            return false;
        }
        Producers other = (Producers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Producers[id=" + id + "]";
    }

}

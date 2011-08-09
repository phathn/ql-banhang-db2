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
 * @author db2admin
 */
@Entity
@Table(name = "OTHERCONFIGS", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Otherconfigs.findAll", query = "SELECT o FROM Otherconfigs o"),
    @NamedQuery(name = "Otherconfigs.findById", query = "SELECT o FROM Otherconfigs o WHERE o.id = :id"),
    @NamedQuery(name = "Otherconfigs.findByCodeexpireday", query = "SELECT o FROM Otherconfigs o WHERE o.codeexpireday = :codeexpireday"),
    @NamedQuery(name = "Otherconfigs.findByEmailcompany", query = "SELECT o FROM Otherconfigs o WHERE o.emailcompany = :emailcompany"),
    @NamedQuery(name = "Otherconfigs.findByPasswordemailcompany", query = "SELECT o FROM Otherconfigs o WHERE o.passwordemailcompany = :passwordemailcompany")})
public class Otherconfigs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "CODEEXPIREDAY")
    private Integer codeexpireday;
    @Column(name = "EMAILCOMPANY", length = 150)
    private String emailcompany;
    @Column(name = "PASSWORDEMAILCOMPANY", length = 150)
    private String passwordemailcompany;

    public Otherconfigs() {
    }

    public Otherconfigs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodeexpireday() {
        return codeexpireday;
    }

    public void setCodeexpireday(Integer codeexpireday) {
        this.codeexpireday = codeexpireday;
    }

    public String getEmailcompany() {
        return emailcompany;
    }

    public void setEmailcompany(String emailcompany) {
        this.emailcompany = emailcompany;
    }

    public String getPasswordemailcompany() {
        return passwordemailcompany;
    }

    public void setPasswordemailcompany(String passwordemailcompany) {
        this.passwordemailcompany = passwordemailcompany;
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
        if (!(object instanceof Otherconfigs)) {
            return false;
        }
        Otherconfigs other = (Otherconfigs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Otherconfigs[id=" + id + "]";
    }

}

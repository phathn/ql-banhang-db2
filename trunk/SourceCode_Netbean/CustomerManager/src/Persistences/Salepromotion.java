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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SALEPROMOTION", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Salepromotion.findAll", query = "SELECT s FROM Salepromotion s"),
    @NamedQuery(name = "Salepromotion.findById", query = "SELECT s FROM Salepromotion s WHERE s.id = :id"),
    @NamedQuery(name = "Salepromotion.findByCode", query = "SELECT s FROM Salepromotion s WHERE s.code = :code"),
    @NamedQuery(name = "Salepromotion.findByDatestore", query = "SELECT s FROM Salepromotion s WHERE s.datestore = :datestore")})
public class Salepromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "CODE", length = 150)
    private String code;
    @Column(name = "DATESTORE")
    @Temporal(TemporalType.DATE)
    private Date datestore;
    @JoinColumn(name = "IDCUSTOMER", referencedColumnName = "ID")
    @ManyToOne
    private Customers idcustomer;

    public Salepromotion() {
    }

    public Salepromotion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDatestore() {
        return datestore;
    }

    public void setDatestore(Date datestore) {
        this.datestore = datestore;
    }

    public Customers getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Customers idcustomer) {
        this.idcustomer = idcustomer;
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
        if (!(object instanceof Salepromotion)) {
            return false;
        }
        Salepromotion other = (Salepromotion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Salepromotion[id=" + id + "]";
    }

}

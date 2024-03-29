/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistences;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author db2admin
 */
@Entity
@Table(name = "CUSTOMERCATEGORIES", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Customercategories.findAll", query = "SELECT c FROM Customercategories c"),
    @NamedQuery(name = "Customercategories.findById", query = "SELECT c FROM Customercategories c WHERE c.id = :id"),
    @NamedQuery(name = "Customercategories.findByName", query = "SELECT c FROM Customercategories c WHERE c.name = :name"),
    @NamedQuery(name = "Customercategories.findByDiscount", query = "SELECT c FROM Customercategories c WHERE c.discount = :discount")})
public class Customercategories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", length = 150)
    private String name;
    @Column(name = "DISCOUNT", precision = 24)
    private Float discount;
    @OneToMany(mappedBy = "idcategory")
    private Collection<Customers> customersCollection;

    public Customercategories() {
    }

    public Customercategories(Integer id) {
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

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
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
        if (!(object instanceof Customercategories)) {
            return false;
        }
        Customercategories other = (Customercategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Customercategories[id=" + id + "]";
    }

}

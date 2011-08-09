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
@Table(name = "DISTRIBUTORS", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Distributors.findAll", query = "SELECT d FROM Distributors d"),
    @NamedQuery(name = "Distributors.findById", query = "SELECT d FROM Distributors d WHERE d.id = :id"),
    @NamedQuery(name = "Distributors.findByName", query = "SELECT d FROM Distributors d WHERE d.name = :name")})
public class Distributors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", length = 150)
    private String name;
    @OneToMany(mappedBy = "iddistributor")
    private Collection<Products> productsCollection;

    public Distributors() {
    }

    public Distributors(Integer id) {
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

    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
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
        if (!(object instanceof Distributors)) {
            return false;
        }
        Distributors other = (Distributors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Distributors[id=" + id + "]";
    }

}

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
@Table(name = "PRODUCTCATEGORIES", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Productcategories.findAll", query = "SELECT p FROM Productcategories p"),
    @NamedQuery(name = "Productcategories.findById", query = "SELECT p FROM Productcategories p WHERE p.id = :id"),
    @NamedQuery(name = "Productcategories.findByName", query = "SELECT p FROM Productcategories p WHERE p.name = :name"),
    @NamedQuery(name = "Productcategories.findByDescription", query = "SELECT p FROM Productcategories p WHERE p.description = :description")})
public class Productcategories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", length = 150)
    private String name;
    @Column(name = "DESCRIPTION", length = 150)
    private String description;
    @OneToMany(mappedBy = "idproductcategory")
    private Collection<Products> productsCollection;

    public Productcategories() {
    }

    public Productcategories(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Productcategories)) {
            return false;
        }
        Productcategories other = (Productcategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Productcategories[id=" + id + "]";
    }

}

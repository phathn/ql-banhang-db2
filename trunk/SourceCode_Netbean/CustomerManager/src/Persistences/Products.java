/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistences;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author db2admin
 */
@Entity
@Table(name = "PRODUCTS", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id"),
    @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price"),
    @NamedQuery(name = "Products.findByQuantity", query = "SELECT p FROM Products p WHERE p.quantity = :quantity")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", length = 150)
    private String name;
    @Column(name = "PRICE")
    private long price;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;
    @JoinColumn(name = "IDDISTRIBUTOR", referencedColumnName = "ID")
    @ManyToOne
    private Distributors iddistributor;
    @JoinColumn(name = "IDPRODUCER", referencedColumnName = "ID")
    @ManyToOne
    private Producers idproducer;
    @JoinColumn(name = "IDPRODUCTCATEGORY", referencedColumnName = "ID")
    @ManyToOne
    private Productcategories idproductcategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproduct")
    private Collection<Orderdetails> orderdetailsCollection;

    public Products() {
    }

    public Products(Integer id) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Distributors getIddistributor() {
        return iddistributor;
    }

    public void setIddistributor(Distributors iddistributor) {
        this.iddistributor = iddistributor;
    }

    public Producers getIdproducer() {
        return idproducer;
    }

    public void setIdproducer(Producers idproducer) {
        this.idproducer = idproducer;
    }

    public Productcategories getIdproductcategory() {
        return idproductcategory;
    }

    public void setIdproductcategory(Productcategories idproductcategory) {
        this.idproductcategory = idproductcategory;
    }

    public Collection<Orderdetails> getOrderdetailsCollection() {
        return orderdetailsCollection;
    }

    public void setOrderdetailsCollection(Collection<Orderdetails> orderdetailsCollection) {
        this.orderdetailsCollection = orderdetailsCollection;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Products[id=" + id + "]";
    }

}

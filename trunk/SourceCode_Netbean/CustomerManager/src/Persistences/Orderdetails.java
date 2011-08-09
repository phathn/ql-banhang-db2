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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author db2admin
 */
@Entity
@Table(name = "ORDERDETAILS", catalog = "", schema = "DB2ADMIN")
@NamedQueries({
    @NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o"),
    @NamedQuery(name = "Orderdetails.findById", query = "SELECT o FROM Orderdetails o WHERE o.id = :id"),
    @NamedQuery(name = "Orderdetails.findByQuantity", query = "SELECT o FROM Orderdetails o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orderdetails.findByPrice", query = "SELECT o FROM Orderdetails o WHERE o.price = :price")})
public class Orderdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "PRICE")
    private long price;
    @JoinColumn(name = "IDORDER", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Orders idorder;
    @JoinColumn(name = "IDPRODUCT", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Products idproduct;

    public Orderdetails() {
    }

    public Orderdetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Orders getIdorder() {
        return idorder;
    }

    public void setIdorder(Orders idorder) {
        this.idorder = idorder;
    }

    public Products getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Products idproduct) {
        this.idproduct = idproduct;
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
        if (!(object instanceof Orderdetails)) {
            return false;
        }
        Orderdetails other = (Orderdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistences.Orderdetails[id=" + id + "]";
    }

}

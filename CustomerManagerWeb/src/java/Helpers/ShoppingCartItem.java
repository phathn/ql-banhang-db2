/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Helpers;

import java.util.Date;

/**
 *
 * @author db2admin
 */
public class ShoppingCartItem {
    private int _idCustomer;
    private int _idProduct;
    private int _quantity;

    /**
     * @return the _idCustomer
     */
    public int getIdCustomer() {
        return _idCustomer;
    }

    /**
     * @param idCustomer the _idCustomer to set
     */
    public void setIdCustomer(int idCustomer) {
        this._idCustomer = idCustomer;
    }

    /**
     * @return the _idProduct
     */
    public int getIdProduct() {
        return _idProduct;
    }

    /**
     * @param idProduct the _idProduct to set
     */
    public void setIdProduct(int idProduct) {
        this._idProduct = idProduct;
    }

    /**
     * @return the _quantity
     */
    public int getQuantity() {
        return _quantity;
    }

    /**
     * @param quantity the _quantity to set
     */
    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }
}

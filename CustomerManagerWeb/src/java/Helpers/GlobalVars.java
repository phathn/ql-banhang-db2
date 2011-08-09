/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author db2admin
 */
public class GlobalVars {

    public static ShoppingCart ObjShoppingCart;
    public static long GOLDEN_CUSTOMER = 20000;
    public static long SILVER_CUSTOMER = 10000;
    public static long BRONZE_CUSTOMER = 5000;
    
    public static boolean IsProductExistInCart(ArrayList<ShoppingCartItem> Cart, int idproduct, AtomicReference<ShoppingCartItem> item) {
        if (Cart.size() == 0) {
            return false;
        }
        for (int i = 0; i < Cart.size(); i++) {
            if(Cart.get(i).getIdProduct() == idproduct){
                item.set(Cart.get(i));
                return true;
            }
        }
        return false;
    }
}

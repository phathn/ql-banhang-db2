/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTable;


import java.util.Comparator;
import java.util.Date;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ColumnSorterByName implements Comparator {

    int colIndex;
    boolean ascending;

    /**
     * Hởi tạo 1 đối tượng Comparator
     * @param colIndex: sort theo cột
     * @param ascending: true(tăng từ trên xuống dưới), false(tăng từ dưới lên trên)
     */
    ColumnSorterByName(int colIndex, boolean ascending) {
        this.colIndex = colIndex;
        this.ascending = ascending;
    }

    /**
     * sort các dòng dữ liệu của 1 DefaultTableModel, thực hiện so sánh 2 giá trị của 2
     * dòng theo cột dùng để sort
     * @param a: dòng thứ nhất
     * @param b: dòng thứ hai
     * @return
     */
    public int compare(Object a, Object b) {
        Vector v1 = (Vector) a;
        Vector v2 = (Vector) b;
        Object o1 = v1.get(colIndex);
        Object o2 = v2.get(colIndex);

        // Treat empty strains like nulls
        if (o1 instanceof String && ((String) o1) == null) {
            o1 = null;
        }
        if (o2 instanceof String && ((String) o2) == null) {
            o2 = null;
        }

        // Sort nulls so they appear last, regardless
        // of sort order
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return 1;
        } else if (o2 == null) {
            return -1;
        } else if (o1 instanceof Comparable) {
            if (ascending) {
                return ((String) o1).toUpperCase().compareTo(((String) o2).toUpperCase());
            } else {
                return ((String) o2).toUpperCase().compareTo(((String) o1).toUpperCase());
            }
        } else {
            if (ascending) {
                return ((String) o1).toUpperCase().compareTo(((String) o2).toUpperCase());
            } else {
                return ((String) o2).toUpperCase().compareTo(((String) o1).toUpperCase());
            }
        }
    }
}


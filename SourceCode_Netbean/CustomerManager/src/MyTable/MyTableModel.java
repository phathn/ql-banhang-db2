/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MyTable;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class MyTableModel extends DefaultTableModel {

    private boolean isEdit;
    /**
     *  Construct a table model with specified data and columnNames
     * @param data: mảng chức các dòng dữ liệu
     * @param columnNames: mảng chứa tên các cột của bảng
     * @param type: true (editable), false(non-editable)
     */
    public MyTableModel(Vector data, Vector columnNames, boolean type) {
        super(data, columnNames);
        this.isEdit = type;
    }

    /** Override this method to return true if cell is editable */
    @Override
    public boolean isCellEditable(int row, int column) {
        if (!this.isEdit)//false -> disable Edit
        {
            return false;
        }
        return true;//true -> enable edit
    }

}

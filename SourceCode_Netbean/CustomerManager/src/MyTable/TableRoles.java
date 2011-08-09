/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MyTable;

import Helpers.GlobalVariables;
import Persistences.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author db2admin
 */
public class TableRoles {
    private static Vector<String> arrCol = new Vector<String>(3);
    //mang chua du lieu cac dong
    private static Vector<Object> arrRow;
    //mang luu giu ten cac cot
    private static String[] columnNames;
    private static int PREFERRED_SIZE = 12;
    private static Color whiteSmoke = new Color(245, 245, 245);

    public static void sortAllRowByyFullName(DefaultTableModel model, int colIndex, boolean ascending) {
        Vector data = model.getDataVector();
        Collections.sort(data, new ColumnSorterByName(colIndex, ascending));
        model.fireTableStructureChanged();
    }

    public static void loadDataIntoTableBook(JTable table, ArrayList<Roles> lstItem) {
        table.setRowHeight(18);
        arrCol = new Vector<String>();
        columnNames = new String[]{"", "ID", "RoleName"};
        for (String strNameCol : columnNames) {
            arrCol.add(strNameCol);
        }

        addElementIntoTableAddressBook(lstItem);
        //them dong, cot
        MyTableModel model = new MyTableModel(arrRow, arrCol, false);
        table.setModel(model);
        //thuc hien sort column theo tung loai (thu muc, file)
        //thu muc tang tu tren xuong duoi
        //sau do den file tang tu tren xuong duoi
        table.setAutoCreateColumnsFromModel(false);
        sortAllRowByyFullName(model, 2, true);
        ///////////////
        editTableAddressBook(table);
    }

    /**
     * Đưa các files/folders con của file ứng với đường dẫn path1
     * vào 1 table theo kiểu full screen
     * @param path1: đường dẫn chứa files/folders cần load
     */
    public static void addElementIntoTableAddressBook(ArrayList<Roles> lstItem) {
        //arraylsit chua tat cac cac file tuong ung voi thu muc
        //co duong dan strTempPathLeft
        arrRow = new Vector<Object>();
        /////////////////
        for (int i = 0; i < lstItem.size(); i++) {
            JLabel lb = new JLabel();
            String pathImages;
            pathImages = System.getProperty("user.dir") + File.separator +
                    "src/Images/vcard.png";

            ImageIcon imageIcon = new ImageIcon(pathImages);
            if (imageIcon.getIconWidth() > PREFERRED_SIZE || imageIcon.getIconHeight() > PREFERRED_SIZE) {
                imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(
                        PREFERRED_SIZE, PREFERRED_SIZE, Image.SCALE_SMOOTH));
            }

            lb.setIcon(imageIcon);
            lb.setName(String.valueOf(lstItem.get(i).getId()));
            lb.setHorizontalAlignment(SwingConstants.CENTER);
            /////
            //them cac phan tu vao mang
            Vector<Object> a = new Vector<Object>();
            a.add(lb);//add icon
            a.add(lstItem.get(i).getId());
            a.add(lstItem.get(i).getRolename());

            arrRow.add(a);
        }
    }

    public static void editTableAddressBook(JTable table1) {
        TableColumn column = null;
        //dieu chinh kich thuoc, do rong cac cot
        for (int i = 0; i < 3; i++) {
            column = table1.getColumnModel().getColumn(i);
            switch (i) {
                case 0://icon
                    column.setResizable(false);
                    column.setPreferredWidth(16);
                    break;
                case 1://id
                    column.setPreferredWidth(50);
                    break;
                case 2://name
                    column.setPreferredWidth(200);
                    break;
            }

        }
        //tuy chinh font, ung voi cac item trong table (in dam)
        Font font = GlobalVariables.g_font;
        table1.setFont(font);
        table1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table1.setSelectionBackground(Color.WHITE);
        table1.setSelectionForeground(Color.RED);

        TableColumn labelColumn = table1.getColumn("");
        labelColumn.setCellRenderer(new MyImageCellRenderer());
    }
}

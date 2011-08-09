/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MyTable;

/**
 *
 * @author db2admin
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
public class MyImageListCellRenderer extends DefaultListCellRenderer {

    /** Override this method in DefaultTableCellRenderer */
    /**
     * Returns the default table cell renderer<p>
     * During a printing operation, this method will be called with isSelected
     * and hasFocus values of false to prevent selection and focus from appearing
     * in the printed output. To do other customization based on whether or not the
     * table is being printed, check the return value from JComponent.isPaintingForPrint().<p>
     * @param table: the JTable
     * @param value:  the value to assign to the cell at [row, column]
     * @param isSelected: true if cell is selected
     * @param isFocused: true if cell has focus
     * @param row: the row of the cell to render
     * @param column: the column of the cell to render
     * @return: The default table cell renderer
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean isFocused) {
        if (value instanceof JLabel) {
            JLabel lb = (JLabel) value;
            lb.setOpaque(true);
            if (isSelected) {
                lb.setBackground(SystemColor.textHighlight);
                lb.setForeground(Color.white);
            } else {
                lb.setBackground(Color.white);
                lb.setForeground(Color.black);
            }
            return lb;
        }

        return null;
    }
}
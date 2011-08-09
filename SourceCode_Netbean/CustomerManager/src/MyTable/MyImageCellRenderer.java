/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTable;

/**
 *
 * @author le tuan
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author le tuan
 */
public class MyImageCellRenderer extends DefaultTableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

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
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean isFocused, int row, int column) {

        if (value instanceof JLabel) {
            JLabel lb = (JLabel) value;
            lb.setOpaque(true);
            if (isSelected) {
                if (table.getValueAt(row, 1) instanceof String) {
                    return lb;
                } else {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                }
            } else {
                lb.setForeground(Color.black);
                lb.setBackground(Color.white);
            }
            return lb;
        } else {
            if (value instanceof JTextField) {
                JTextField textField = (JTextField) value;
                textField.setEditable(false);
                textField.setBorder(null);
                if (row != -1 && isSelected) {
                    textField.setForeground(Color.red);
                } else {
                    textField.setForeground(Color.black);
                }

                return textField;
            }
        }
        return this;
    }
}

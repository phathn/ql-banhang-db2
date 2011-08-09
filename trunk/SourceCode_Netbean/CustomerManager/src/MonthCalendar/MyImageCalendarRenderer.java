/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonthCalendar;

/**
 *
 * @author le tuan
 */
import MonthCalendar.CellTable;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author le tuan
 */
public class MyImageCalendarRenderer extends DefaultTableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
    ArrayList<CellTable> cells;

    public MyImageCalendarRenderer() {
        super();
    }

    public MyImageCalendarRenderer(ArrayList<CellTable> cells) {
        super();
        this.cells = cells;
    }

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
        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, isFocused, row, column);
        if (value instanceof JLabel) {
            JLabel lb = (JLabel) value;
            lb.setOpaque(true);
            if (lb.getName().equals("None")) {
                if (isSelected) {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                } else {
                    lb.setForeground(Color.black);
                    lb.setBackground(Color.white);
                }
            } else if (lb.getName().equals("Important")) {
                if (isSelected) {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                } else {
                    lb.setForeground(Color.black);
                    lb.setBackground(new Color(255, 146, 129));
                }
            } else if (lb.getName().equals("Business")) {
                if (isSelected) {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                } else {
                    lb.setForeground(Color.black);
                    lb.setBackground(new Color(124, 152, 223));
                }
            } else if (lb.getName().equals("Personal")) {
                if (isSelected) {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                } else {
                    lb.setForeground(Color.black);
                    lb.setBackground(new Color(153, 212, 102));
                }
            } else if (lb.getName().equals("Vacation")) {
                if (isSelected) {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                } else {
                    lb.setForeground(Color.black);
                    lb.setBackground(new Color(229, 224, 193));
                }
            } else if (lb.getName().equals("Travel Required")) {
                if (isSelected) {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                } else {
                    lb.setForeground(Color.black);
                    lb.setBackground(new Color(128, 235, 237));
                }
            } else if (lb.getName().equals("Need Preparation")) {
                if (isSelected) {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                } else {
                    lb.setForeground(Color.black);
                    lb.setBackground(new Color(201, 199, 128));
                }
            } else if (lb.getName().equals("BirthDay")) {
                if (isSelected) {
                    lb.setForeground(Color.white);
                    lb.setBackground(SystemColor.textHighlight);
                } else {
                    lb.setForeground(Color.black);
                    lb.setBackground(new Color(191, 162, 245));
                }
            }
            return lb;
        } else if (value instanceof JPanel) {
            JPanel pn = (JPanel) value;
            if (truocSau(cells, row, column)) {
                if (isFocused) {
                    pn.setBackground(new Color(232,239,255));
                } else {
                    pn.setBackground(new Color(255, 244, 188));
                }
                return pn;
            }
            if (isFocused) {
                pn.setBackground(new Color(232,239,255));
            } else {
                pn.setBackground(new Color(255, 255, 213));
            }
            return pn;
        } else {
            if (isSelected) {
                renderer.setForeground(Color.white);
                renderer.setBackground(SystemColor.textHighlight);
            } else {
                if (row >= 0 && row < 12) {
                    renderer.setBackground(new Color(255, 255, 213));
                } else if (row >= 12 && row < 24) {
                    renderer.setBackground(new Color(255, 244, 188));
                }
            }
            return renderer;
        }
    //return this;
    }

    public boolean truocSau(ArrayList<CellTable> cells, int row, int col) {
        for (CellTable cell : cells) {
            if (row == cell.getRow() && col == cell.getColumn()) {
                return true;
            }
        }
        return false;
    }
}

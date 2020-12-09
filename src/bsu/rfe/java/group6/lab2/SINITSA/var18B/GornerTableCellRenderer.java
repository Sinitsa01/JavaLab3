package bsu.rfe.java.group6.lab2.SINITSA.var18B;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private String needle = null;
    @SuppressWarnings("unused")
	private String needleTwo = null;
    private DecimalFormat formatter =(DecimalFormat) NumberFormat.getInstance();
    public GornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(5);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble =
                formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    
    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        if (col == 0 || col == 1) {
            double col1 = (Double) table.getValueAt(row, col);
            int Col1 = (int) col1;
            col1 -= Col1;
            double r;
            if(col==0) {
            	 r = (Double) table.getValueAt(row ,0);
            }else {  r = (Double) table.getValueAt(row ,1);}
            int sum = 0;
            for(int i=0;i<4;i++) {
            	r*=10;
            	sum+=r%10;
            	
            }
            if (sum%10==0&&sum!=0) {
            	panel.setBackground(Color.GREEN);
            	sum=0;
            }
            else panel.setBackground(Color.WHITE);
            sum=0;
            
        }

        if(col==2){
            double y = (Double) table.getValueAt(row ,1);
            boolean check;
            String str = Double.toString(y);
            String[] Str = str.split("\\.");
            if (Str[0].equals(Str[1]))check = true;
            else  check = false;
          
            panel.remove(0);
            JCheckBox jCheckBox = new JCheckBox();
            jCheckBox.setSelected(check);
            panel.add(jCheckBox);
            panel.setBackground(Color.WHITE);
            return panel;
        }else{
            panel.remove(0);
            panel.add(label);
        }
        if(col == 1) {
            if (needle != null && needle.equals(formattedDouble)) {
                panel.setBackground(Color.RED);
            }
        }
        return panel;
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }

    public void setNeedleTwo(String needle) {
        this.needleTwo= needle;
    }
}

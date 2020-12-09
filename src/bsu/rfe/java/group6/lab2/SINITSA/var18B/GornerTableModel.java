package bsu.rfe.java.group6.lab2.SINITSA.var18B;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
private Double[] coefficients;
private Double from;
private Double to;
private Double step;
public GornerTableModel(Double from, Double to, Double step,

Double[] coefficients) {

this.from = from;
this.to = to;
this.step = step;
this.coefficients = coefficients;
}
public Double getFrom() {
return from;
}
public Double getTo() {
return to;
}
public Double getStep() {
return step;
}
public int getColumnCount() {
// � ������ ������ ��� �������
return 2;
}
public int getRowCount() {
// ��������� ���������� ����� ����� ������� � ������ �������
// ������ �� ���� �������������
return new Double(Math.ceil((to-from)/step)).intValue()+1;
}
public Object getValueAt(int row, int col) {
// ��������� �������� X ��� ������_������� + ���*�����_������
double x = from + step*row;
if (col==0) {
// ���� ������������� �������� 1-�� �������, �� ��� X
return x;
} else {
// ���� ������������� �������� 2-�� �������, �� ��� ��������
// ����������
Double result = 0.0;
return result;
}
}
public String getColumnName(int col) {
switch (col) {
case 0:
// �������� 1-�� �������
return "�������� X";
default:
// �������� 2-�� �������
return "�������� ����������";
}
}
public Class<?> getColumnClass(int col) {
// � � 1-�� � �� 2-�� ������� ��������� �������� ���� Double
return Double.class;
}
}

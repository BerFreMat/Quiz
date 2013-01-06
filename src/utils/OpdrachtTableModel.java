package utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.Opdracht;
import model.OpdrachtCategorie;
import model.OpdrachtSoort;

import exceptions.*;

public class OpdrachtTableModel extends DefaultTableModel {

	private String[] columnnames;
	private List<Opdracht> opdrachtenlijst;
	private List<Integer> maxscores;
	private static final int MAXSCORE = 2;
	
	
	public OpdrachtTableModel(List<Opdracht> opdrachtlist) throws NullPointerException{
		
		opdrachtenlijst = new ArrayList<Opdracht>();
		opdrachtenlijst = opdrachtlist;
		maxscores = new ArrayList<Integer>(); 
		/**for (int i=0;i<opdrachtenlijst.size();i++){
			maxscores.set(i,MAXSCORE);
		}*/
		columnnames = new String[]{"ID","Categorie","Type","Vraag","MaxScore"};
	}
	
	public void opdrachtVerwijderen(int rownr) {
		
		this.removeRow(rownr);
		opdrachtenlijst.remove(rownr);
		
		maxscores.remove(rownr);
		
		//let the table know about the changes
		fireTableDataChanged();
		
		}

	
	public void opdrachtToevoegen(Opdracht opd) throws OpdrachtNietToegevoegdException{
		
		opdrachtenlijst.add(opd);
		
		maxscores.add(MAXSCORE);
		
		//let the table know about the changes
		fireTableDataChanged();
	}
	
	public String getColumnName(int ColIndex){
		return (ColIndex<=columnnames.length)?columnnames[ColIndex]:null;
	}
	
	@Override
	public int getRowCount() {
		
		return (opdrachtenlijst==null)?0:opdrachtenlijst.size();
	}

	@Override
	public int getColumnCount() {
		
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object value;
		
		switch(columnIndex){
		case 0:
		case 1: value=opdrachtenlijst.get(rowIndex).getCategorie(); break;
		case 2: value=opdrachtenlijst.get(rowIndex).getOpdrachtSoort(); break;
		case 3: value=opdrachtenlijst.get(rowIndex).getVraag(); break;
		case 4: value=maxscores.get(rowIndex); break;
		default: throw new IndexOutOfBoundsException("Column index out of bounds" + columnIndex);
		}
		return value;
	}
	
	public int getMaxScoreVanVraag(int rowIndex){
		return maxscores.get(rowIndex);
	}
	
	public boolean isCellEditable(int row, int col){
		if (col==4){
			return true;
		}
		else{
			return false;
		}
	}
	 @Override
	 public Class<?> getColumnClass(int columnIndex) {
		Class<?> clazz;
		switch (columnIndex) {
		case 0:
		case 1:
			clazz = OpdrachtCategorie.class;
			break;
		case 2:
			clazz = OpdrachtSoort.class;
			break;
		case 3:
			clazz = String.class;
			break;
		case 4:
			clazz = Integer.class;
			break;
		default:
			throw new IndexOutOfBoundsException("Column index out of bounds: " + columnIndex);
		}
		return clazz;
	 }
	
	@Override 
    public void setValueAt(Object value, int row, int col) {
        
    	if (value.getClass().equals(Integer.class)&&col==4){
        	maxscores.set(row,Integer.parseInt(value.toString()));
            fireTableCellUpdated(row, col);
    	}


    }



}

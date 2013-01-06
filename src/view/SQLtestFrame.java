package view;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import model.Opdracht;

public class SQLtestFrame extends JFrame {

	private JList opdrJList;
	private DefaultListModel<Opdracht> opdrlistmodel;
	private List<Opdracht> opdrlijst;
	
	public SQLtestFrame(List<Opdracht> listopdr) {
		
		this.opdrlijst = listopdr;
		
		getContentPane().setEnabled(false);
		setBounds(100, 100, 1050, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		opdrlistmodel = new DefaultListModel<Opdracht>();
		
		if(!opdrlistmodel.equals(null))
		{
			for (Opdracht opd:this.opdrlijst)
			{
				opdrlistmodel.addElement(opd);
			}	
		}
		
		opdrJList = new JList<Opdracht>(opdrlistmodel);
		opdrJList.setBounds(10, 10, 300, 300);
		getContentPane().add(opdrJList);
	}

}

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.*;
import model.*;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Checkbox;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;

public class QuizToevoegenFrame extends JFrame {

	private OpstartController opstartcontroller;
	private ToevoegenQuizController toevoegenquizcontroller;
	
	private JTextField txtOnderwerp;

	private JButton btnOpdrachtToevoegen, btnOpdrachtVerwijderen, btnAnnuleer,btnRegistreerQuiz, btnToonAlleOpdrachten;
	private JComboBox cmbVan, cmbTot, cmbxStatus, cmbTypeFilter,cmbCategorieFilter, cmbAuteur;
	
	private Checkbox chbxTest, chbxUniekeDeelname;
	
	private List<Opdracht> alleopdrachtenList, opdrachtenGeselecteerdList;
	
	private DefaultListModel<Opdracht> listmodelAlleOpdrachten, listmodelToeTeVoegenOpdrachten;
	private JList opdrachtenNogNietToegevoegdJList; //JList met opdrachten die nog kunnen worden toegevoegd
	private JList opdrachtenReedsToegevoegdJList; //JList waarin de toe te voegen opdrachten komen
	private JTable opdrachtenReedsToegevoegdJTable; 

	public QuizStatus getQuizStatus(){
		return QuizStatus.valueOf(this.cmbxStatus.getSelectedItem().toString());
	}
	
	public boolean getIsTest(){
		return this.chbxTest.getState();
		
	}
	
	public boolean getIsUniekeDeelname(){
		return this.chbxUniekeDeelname.getState();
		
	}
	
	//Toegankelijk maken van de lijst met geselecteerde opdrachten naar de buitenwereld
	public List<Opdracht> getOpdrachtenGeselecteerdList() {
		vulLijstGeselecteerdeOpdrachten();
		return this.opdrachtenGeselecteerdList;
	}


	
	//All getters to expose the required fields to the outside world (especially the ToevoegenQuizcontroller)
	public JButton getBtnRegistreerQuiz()
	{
		return this.btnRegistreerQuiz;
	}
	
	public JButton getbtnAnnuleer()
	{
		return this.btnAnnuleer;
	}
	
	public String getOnderwerp(){
		return txtOnderwerp.getText();
	}
	
	public Leraar getAuteur(){
		return (Leraar)this.cmbAuteur.getSelectedItem();
	}
	
		
	public Leerjaar getLeerjaarVan(){
		return Leerjaar.valueOf(this.cmbVan.getSelectedItem().toString());
	}
	
	public Leerjaar getLeerjaarTot(){
		return Leerjaar.valueOf(this.cmbTot.getSelectedItem().toString());
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizToevoegenFrame frame = new QuizToevoegenFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//initiële opvulling van de defaultlistmodel om de jlist met opdrachten te vullen
	private void vulListModelMetAlleOpdrachten(){
		if(!alleopdrachtenList.equals(null))
		{
			for (Opdracht opd:this.alleopdrachtenList)
			{
				listmodelAlleOpdrachten.addElement(opd);
			}	
		}
	}
	
	private String[] zetListOpdrachtenOmNaarStringArrayVoorJList(List<Opdracht> lijstvanopdrachten) {
		int aantalopdrachten = lijstvanopdrachten.size();
		
		String[] opdrlijst = new String[aantalopdrachten-1];
		
			for(int i=0;i<=aantalopdrachten;i++){
				opdrlijst[i]= String.format("%3d",lijstvanopdrachten.get(i).getOpdrachtId()) +"\t" 
						+ lijstvanopdrachten.get(i).getVraag().substring(0, 20) +"\t" 
						+ lijstvanopdrachten.get(i).getCategorie().toString().substring(0, 8)+"\t" 
						+ lijstvanopdrachten.get(i).getOpdrachtSoort().toString().substring(0,8) +"\n";	
			}
			
			return opdrlijst;

	}
	
	
	
	/**
	 * basic constructor
	 */
	public QuizToevoegenFrame(){
		
	}
	
	
	/**
	 * Constructor met OpstartController en ToevoegenQuizController als parameters
	 */
	public QuizToevoegenFrame(OpstartController opstrtcontrller, ToevoegenQuizController tvgenquizcntrller) {
		super("Nieuwe Quiz Aanmaken");
		this.opstartcontroller = opstrtcontrller;
		this.toevoegenquizcontroller = tvgenquizcntrller;
		
		this.alleopdrachtenList = tvgenquizcntrller.getOpdrachtenLijst();
		this.opdrachtenGeselecteerdList = new ArrayList<Opdracht>();
		
		getContentPane().setEnabled(false);
		setBounds(100, 100, 752, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblOnderwerp = new JLabel("Onderwerp");
		lblOnderwerp.setBounds(12, 0, 97, 30);
		lblOnderwerp.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(lblOnderwerp);
		
		txtOnderwerp = new JTextField();
		txtOnderwerp.setBounds(127, 1, 207, 29);
		txtOnderwerp.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(txtOnderwerp);
		txtOnderwerp.setColumns(5);
		
		JLabel lblLeerjaar = new JLabel("Leerjaar");
		lblLeerjaar.setHorizontalAlignment(SwingConstants.LEFT);
		lblLeerjaar.setBounds(12, 33, 97, 30);
		getContentPane().add(lblLeerjaar);
		
		this.btnRegistreerQuiz = new JButton("Registreer Quiz");
		btnRegistreerQuiz.setBounds(575, 0, 163, 25);
		getContentPane().add(btnRegistreerQuiz);
		
		btnAnnuleer = new JButton("Annuleer");
		btnAnnuleer.setBounds(575, 33, 163, 25);
		getContentPane().add(btnAnnuleer);
		
		JLabel lblVan = new JLabel("Van:");
		lblVan.setBounds(39, 75, 70, 15);
		getContentPane().add(lblVan);
		
		JLabel lblTot = new JLabel("tot:");
		lblTot.setBounds(199, 75, 70, 15);
		getContentPane().add(lblTot);
		
		cmbVan = new JComboBox(Leerjaar.values());
		cmbVan.setBounds(100, 70, 97, 24);
		getContentPane().add(cmbVan);
		
		cmbTot = new JComboBox(Leerjaar.values());
		cmbTot.setBounds(245, 70, 97, 24);
		getContentPane().add(cmbTot);
		
		chbxTest = new Checkbox("");
		chbxTest.setBounds(48, 106, 115, 23);
		getContentPane().add(chbxTest);
		
		JLabel lblTest = new JLabel("Test");
		lblTest.setHorizontalAlignment(SwingConstants.LEFT);
		lblTest.setBounds(12, 102, 97, 30);
		getContentPane().add(lblTest);
		
		JLabel lblUniekeDeelname = new JLabel("Unieke Deelname");
		lblUniekeDeelname.setHorizontalAlignment(SwingConstants.LEFT);
		lblUniekeDeelname.setBounds(12, 139, 124, 30);
		getContentPane().add(lblUniekeDeelname);
		
		chbxUniekeDeelname = new Checkbox("");
		chbxUniekeDeelname.setBounds(156, 142, 115, 23);
		getContentPane().add(chbxUniekeDeelname);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuteur.setBounds(12, 176, 124, 30);
		getContentPane().add(lblAuteur);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(12, 212, 124, 30);
		getContentPane().add(lblStatus);
		
		cmbxStatus = new JComboBox(QuizStatus.values());
		cmbxStatus.setBounds(100, 218, 169, 24);
		getContentPane().add(cmbxStatus);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 254, 726, 5);
		getContentPane().add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 340, 726, 5);
		getContentPane().add(separator_2);
		
		this.btnOpdrachtToevoegen = new JButton(">");
		btnOpdrachtToevoegen.setBounds(379, 424, 44, 25);
		getContentPane().add(btnOpdrachtToevoegen);
		
		this.btnOpdrachtVerwijderen = new JButton("<");
		btnOpdrachtVerwijderen.setBounds(379, 469, 44, 25);
		getContentPane().add(btnOpdrachtVerwijderen);
		
		JLabel lblType = new JLabel("Type");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setBounds(12, 257, 44, 30);
		getContentPane().add(lblType);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategorie.setBounds(233, 257, 82, 30);
		getContentPane().add(lblCategorie);
		
		cmbTypeFilter = new JComboBox(OpdrachtSoort.values());
		cmbTypeFilter.setBounds(48, 260, 122, 24);
		getContentPane().add(cmbTypeFilter);
		
		cmbCategorieFilter = new JComboBox(OpdrachtCategorie.values());
		cmbCategorieFilter.setBounds(317, 260, 122, 24);
		getContentPane().add(cmbCategorieFilter);
		
		btnToonAlleOpdrachten = new JButton("Toon Alle Opdrachten");
		btnToonAlleOpdrachten.setBounds(142, 299, 217, 25);
		getContentPane().add(btnToonAlleOpdrachten);
		
		
		cmbAuteur = new JComboBox(Leraar.values());
		cmbAuteur.setBounds(100, 179, 169, 24);
		getContentPane().add(cmbAuteur);
		
		
		
		
		//Opdrachtenlijst omvormen naar een Array van Strings om in de lijst te gebruiken
		List<Opdracht> lijstvanopdrachten = this.opstartcontroller.getOpdrachten();
		int aantalopdrachten = lijstvanopdrachten.size();
		
		String[] opdrlijst = new String[aantalopdrachten];
		try{		
			for(int i=0;i<aantalopdrachten;i++){
				opdrlijst[i]= String.format("%3d",lijstvanopdrachten.get(i).getOpdrachtId()) +"\t" 
						+ lijstvanopdrachten.get(i).getVraag().substring(0, 20) +"\t" 
						+ lijstvanopdrachten.get(i).getCategorie().toString().substring(0, 8)+"\t" 
						+ lijstvanopdrachten.get(i).getOpdrachtSoort().toString().substring(0,8) +"\n";								
				//System.out.printf(opdrlijst[i]);
			}
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
		
		//JList tonen met opdrachten die kunnen worden toegevoegd
		listmodelAlleOpdrachten = new DefaultListModel<Opdracht>();
		vulListModelMetAlleOpdrachten();
		opdrachtenNogNietToegevoegdJList = new JList(listmodelAlleOpdrachten);
		opdrachtenNogNietToegevoegdJList.setVisibleRowCount(10);
		opdrachtenNogNietToegevoegdJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//add(new JScrollPane(listAlleOpdrachten));
		opdrachtenNogNietToegevoegdJList.setBounds(50, 400, 300, 300);
		getContentPane().add(opdrachtenNogNietToegevoegdJList);
		
		//JList tonen met opdrachten die kunnen worden toegevoegd
		listmodelToeTeVoegenOpdrachten = new DefaultListModel<Opdracht>();
		opdrachtenReedsToegevoegdJList = new JList(listmodelToeTeVoegenOpdrachten);
		opdrachtenReedsToegevoegdJList.setVisibleRowCount(10);
		opdrachtenReedsToegevoegdJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//add(new JScrollPane(listAlleOpdrachten));
		opdrachtenReedsToegevoegdJList.setBounds(450, 400, 300, 300);
		getContentPane().add(opdrachtenReedsToegevoegdJList);
		
		opdrachtenReedsToegevoegdJTable = new JTable();
		opdrachtenReedsToegevoegdJTable.setVisible(true);
		opdrachtenReedsToegevoegdJTable.setBounds(450, 800, 300, 300);
		opdrachtenReedsToegevoegdJTable.setBackground(new Color(150));
		getContentPane().add(opdrachtenReedsToegevoegdJTable);
		
		
		//event handling
		AddRemoveButtonHandler addremoveopdrHandler = new AddRemoveButtonHandler();
		btnOpdrachtToevoegen.addActionListener(addremoveopdrHandler);
		btnOpdrachtVerwijderen.addActionListener(addremoveopdrHandler);
	
	}
	
	
	//Vul een List met de geselecteerde opdrachten
	private void vulLijstGeselecteerdeOpdrachten(){
		int aantalopdr = this.listmodelToeTeVoegenOpdrachten.getSize();
		for(int i=0;i<=aantalopdr-1;i++)
		{
			Opdracht nopdr = listmodelToeTeVoegenOpdrachten.get(i);
			opdrachtenGeselecteerdList.add(nopdr);
		}
	}
	
	
	//inner class for handling of '<' and '>' buttons
			private class AddRemoveButtonHandler implements ActionListener
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					String string = ""; //string to be added or removed in either lists
					
					if(e.getSource()==btnOpdrachtToevoegen){
						if(opdrachtenNogNietToegevoegdJList.getSelectedValue()!=null){
							Opdracht opdr = (Opdracht)opdrachtenNogNietToegevoegdJList.getSelectedValue();
							listmodelToeTeVoegenOpdrachten.addElement(opdr);
							listmodelAlleOpdrachten.removeElement(opdr);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Gelieve een opdracht te selecteren","Geen selectie",JOptionPane.PLAIN_MESSAGE);
						}
					}
					else if (e.getSource()==btnOpdrachtVerwijderen){
						if(opdrachtenReedsToegevoegdJList.getSelectedValue()!=null){
							Opdracht opdr = (Opdracht)opdrachtenReedsToegevoegdJList.getSelectedValue();
							listmodelAlleOpdrachten.addElement(opdr);
							listmodelToeTeVoegenOpdrachten.removeElement(opdr);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Gelieve een opdracht te selecteren","Geen selectie",JOptionPane.PLAIN_MESSAGE);
						}
					}
				}
				
			}

}

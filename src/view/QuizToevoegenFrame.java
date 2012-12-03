package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.*;
import model.*;
import java.awt.GridLayout;
import javax.swing.JLabel;
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

import javax.swing.border.BevelBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;

public class QuizToevoegenFrame extends JFrame {

	private OpstartController opstartcontroller;
	private ToevoegenQuizController toevoegenquizcontroller;
	private JTextField txtOnderwerp;
	private JTable tblOpdrachtenToeTeVoegen;
	

	
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
		getContentPane().setEnabled(false);
		setBounds(100, 100, 752, 677);
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
		
		JButton btnRegistreerQuiz = new JButton("Registreer Quiz");
		btnRegistreerQuiz.setBounds(575, 0, 163, 25);
		getContentPane().add(btnRegistreerQuiz);
		
		JButton btnAnnuleer = new JButton("Annuleer");
		btnAnnuleer.setBounds(575, 33, 163, 25);
		getContentPane().add(btnAnnuleer);
		
		JLabel lblVan = new JLabel("Van:");
		lblVan.setBounds(39, 75, 70, 15);
		getContentPane().add(lblVan);
		
		JLabel lblTot = new JLabel("tot:");
		lblTot.setBounds(199, 75, 70, 15);
		getContentPane().add(lblTot);
		
		JComboBox cmbVan = new JComboBox(Leerjaar.values());
		cmbVan.setBounds(100, 70, 97, 24);
		getContentPane().add(cmbVan);
		
		JComboBox cmbTot = new JComboBox(Leerjaar.values());
		cmbTot.setBounds(245, 70, 97, 24);
		getContentPane().add(cmbTot);
		
		Checkbox chbxTest = new Checkbox("");
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
		
		Checkbox checkbox = new Checkbox("");
		checkbox.setBounds(156, 142, 115, 23);
		getContentPane().add(checkbox);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuteur.setBounds(12, 176, 124, 30);
		getContentPane().add(lblAuteur);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(12, 212, 124, 30);
		getContentPane().add(lblStatus);
		
		JComboBox cmbxStatus = new JComboBox(QuizStatus.values());
		cmbxStatus.setBounds(100, 218, 169, 24);
		getContentPane().add(cmbxStatus);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 254, 726, 5);
		getContentPane().add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 340, 726, 5);
		getContentPane().add(separator_2);
		
		JButton btnOpdrachtToevoegen = new JButton(">");
		btnOpdrachtToevoegen.setBounds(379, 424, 44, 25);
		getContentPane().add(btnOpdrachtToevoegen);
		
		JButton btnOpdrachtVerwijderen = new JButton("<");
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
		
		JComboBox cmbTypeFilter = new JComboBox(OpdrachtSoort.values());
		cmbTypeFilter.setBounds(48, 260, 122, 24);
		getContentPane().add(cmbTypeFilter);
		
		JComboBox cmbCategorieFilter = new JComboBox(OpdrachtCategorie.values());
		cmbCategorieFilter.setBounds(317, 260, 122, 24);
		getContentPane().add(cmbCategorieFilter);
		
		JButton btnToonAlleOpdrachten = new JButton("Toon Alle Opdrachten");
		btnToonAlleOpdrachten.setBounds(142, 299, 217, 25);
		getContentPane().add(btnToonAlleOpdrachten);
		
		
		JComboBox cmbAuteur = new JComboBox(Leraar.values());
		cmbAuteur.setBounds(100, 179, 169, 24);
		getContentPane().add(cmbAuteur);
		
		
		//Opdrachtenlijst omvormen naar een Array van Strings om in de lijst te gebruiken
		int aantalopdrachten = this.opstartcontroller.getOpdrachten().size();
		String[] opdrlijst = new String[aantalopdrachten];
		try{		
		for(int i=0;i<=aantalopdrachten;i++){
			opdrlijst[i]= this.opstartcontroller.getOpdrachten().get(i).getOpdrachtId() +"\t" 
					+ String.format("%-15s\t", this.opstartcontroller.getOpdrachten().get(i).getVraag()) +"\t" 
					+ String.format("%-10s\t",this.opstartcontroller.getOpdrachten().get(i).getCategorie()) +"\n";
			System.out.printf("%-15s\t",opdrlijst[i]);
		}}
		catch(Exception exc){System.out.println(exc.getMessage());}
		JList listAlleOpdrachten = new JList(opdrlijst);
		listAlleOpdrachten.setBounds(22, 357, 1, 1);
		getContentPane().add(listAlleOpdrachten);
		
		

		
		
		//event handlers
		btnRegistreerQuiz.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				Quiz nieuwequiz = new Quiz(txtOnderwerp.getText());
				
				try {
					toevoegenquizcontroller.quiztoevoegen(nieuwequiz);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		});
		
		
		

	}
}

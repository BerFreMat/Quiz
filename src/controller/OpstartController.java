package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;

import persistency.DAOFacade;
import persistency.TextDAOFacade;

import model.*;
import view.*;
/**
 * Controller class voor DAO en catalogus
 * @author java
 *
 */

public class OpstartController {

	private DAOFacade daofacade;
	private List<Opdracht> opdrachtcatalogus;
	
	private ToevoegenQuizController toevoegenquizcontroller;
	private SQLtestController sqltestcontroller;
	
	private JFrame toevoegenquizframe;
	private Menu menu;
	
	/**
	 * Constructor OpstartController, leest DAO, opdracht catalogus
	 */
	public OpstartController(){
		
		try {
			daofacade = new TextDAOFacade();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			opdrachtcatalogus = daofacade.getOpdrachten();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		/**
		 * menu opstarten met de menukeuzes
		 */
		menu = new Menu("Beheren van opdrachten","TestSQLConnectie","Beheren van quizzen/testen","Deelnemen aan quiz",
				"Overzicht scores","Quiz rapport","Instellingen van de quiz applicatie");
		
	}
	
	/**
	 * Maakt opdrachtencatalogus (lijst van opdrachten ingeladen uit TextDAOFacade) toegankelijk
	 * @return
	 */
	
	public List<Opdracht> getOpdrachten(){
		return opdrachtcatalogus;
	}
	
	/**
	 * Menu opties
	 */
	public void execute(){
		int keuze = menu.getMenuKeuze();
		
		switch(keuze){
		case 1: toevoegenquizcontroller = new ToevoegenQuizController(daofacade, this);		
				break;
		case 2: sqltestcontroller = new SQLtestController();
				break;
		default: 
			if (keuze != menu.getStopWaarde()){
	    	IO.toonStringMetVenster("Je hebt een verkeerde keuze gemaakt!!!");
	    	keuze = menu.getMenuKeuze();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new OpstartController().execute();
	}

}

package controller;

import java.util.List;

import javax.swing.JFrame;

import persistency.DAOFacade;
import persistency.TextDAOFacade;

import model.*;
import view.*;


public class OpstartController {

	private DAOFacade daofacade;
	private List<Opdracht> opdrachtcatalogus; //beter een OpdrachtCatalogus return type voor daofacade?
	
	private ToevoegenQuizController toevoegenquizcontroller;
	private SQLtestController sqltestcontroller;
	
	private JFrame toevoegenquizframe;
	private Menu menu;
	
	
	public OpstartController(){
		
		
		//inlezen daofacade
		try {
			daofacade = new TextDAOFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		opdrachtcatalogus = daofacade.getOpdrachten();
		
		//menu opstarten met de menukeuzes
		menu = new Menu("Beheren van opdrachten","TestSQLConnectie","Beheren van quizzen/testen","Deelnemen aan quiz",
				"Overzicht scores","Quiz rapport","Instellingen van de quiz applicatie");
		
	}
	
	//Maakt opdrachtencatalogus (lijst van opdrachten ingeladen uit TextDAOFacade) toegankelijk
	public List<Opdracht> getOpdrachten(){
		return opdrachtcatalogus;
	}
	
	
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

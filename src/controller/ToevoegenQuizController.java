package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.swing.JFrame;

import DatumGregorian.Datum;

import persistency.DAOFacade;

import view.QuizToevoegenFrame;

import exceptions.ReedsBestaandeQuizException;
import model.*;

public class ToevoegenQuizController {

	private DAOFacade daofacade;
	private List<Opdracht> opdrachtenlijst;
	private List<Opdracht> opdrachtenNogToeTeVoegen;
	private List<Opdracht> opdrachtenToegevoegd;
	private QuizToevoegenFrame quiztoevoegenframe;
	
	/**
	 * Constructor met opstartcontroller en daofacade params	
	 * @param df
	 * @param opstartcontroller
	 */
	public ToevoegenQuizController(DAOFacade df, OpstartController opstartcontroller){
		this.daofacade = df;
		this.opdrachtenlijst = df.getOpdrachten();
		quiztoevoegenframe = new QuizToevoegenFrame(opstartcontroller, this);
		quiztoevoegenframe.setVisible(true);
		
		//add actionlistener for clicking button QuizToevoegen
		RegistreerQuizClickHandler handler = new RegistreerQuizClickHandler();
		quiztoevoegenframe.getBtnRegistreerQuiz().addActionListener(handler);
		
	}
	
	
	/**
	 * Eventhandler voor klik op de Registreer knop van QuizToevoegenFrame
	 * @author Thomas 
	 *
	 */
	private class RegistreerQuizClickHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
			List<Leerjaar> leerjarenlist = bepaalLeerjaren(quiztoevoegenframe.getLeerjaarVan(), quiztoevoegenframe.getLeerjaarTot());
			int nieuwequizid = daofacade.bepaalLaatsteQuizIDinCatalogus()+1; //bepaalt een id, dat gelijkstaat aan dat van de laatste quiz+1
			List<QuizOpdracht> listqopdr = fakequizopdrachtenlijst(quiztoevoegenframe.getOpdrachtenGeselecteerdList(), nieuwequizid);
			
			
			Quiz nieuwequiz = new Quiz(nieuwequizid, quiztoevoegenframe.getOnderwerp(),leerjarenlist, 
					quiztoevoegenframe.getIsTest(), quiztoevoegenframe.getIsUniekeDeelname(),quiztoevoegenframe.getQuizStatus(),
					quiztoevoegenframe.getAuteur(), listqopdr,new Datum());
			
			
				daofacade.voegQuizToe(nieuwequiz);
				daofacade.schrijfWeg();
				System.out.println("geregistreerd");
			}
				
			catch (ReedsBestaandeQuizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	private List<QuizOpdracht> fakequizopdrachtenlijst(List<Opdracht> opdrlijst, int quizid) throws Exception{
		List<QuizOpdracht> qopdrlijst = new ArrayList<QuizOpdracht>();
		
		if (opdrlijst==null){
			throw new Exception("Geen opdrachten in de lijst");
		}
		for(Opdracht opdr:opdrlijst)
		{
			qopdrlijst.add(new QuizOpdracht(quizid,opdr.getOpdrachtId(),2));
		}
		return qopdrlijst;
	}
	
	/**
	 * Methode om obv 2 leerjaren een List<Leerjaar> terug te geven
	 * @param leerjaarVan
	 * @param leerjaarTot
	 * @return listleraar
	 */
	private List<Leerjaar> bepaalLeerjaren(Leerjaar leerjaarVan, Leerjaar leerjaarTot) {
		List<Leerjaar> listleraar = new ArrayList<Leerjaar>();
		
		if(leerjaarVan.getLeerjaarInt()<=leerjaarTot.getLeerjaarInt()){
			for(Leerjaar leerjaar:EnumSet.range(leerjaarVan,leerjaarTot)){
				listleraar.add(leerjaar);
			}
		}
		return listleraar;
	}
	
	public List<Opdracht> getOpdrachtenLijst(){
		return this.opdrachtenlijst;
	}
		


}

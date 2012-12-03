package controller;

import java.util.List;

import exceptions.ReedsBestaandeQuizException;
import model.*;

public class ToevoegenQuizController {

	private DAOFacade daofacade;
	private List<Opdracht> opdrachtcatalogus;
	private List<Opdracht> opdrachtenNogToeTeVoegen;
	private List<Opdracht> opdrachtenToegevoegd;
	
	public ToevoegenQuizController(DAOFacade df, List<Opdracht> opdrlijst){
		this.daofacade = df;
		this.opdrachtcatalogus = opdrlijst;
		
	}
	
	public void quiztoevoegen(Quiz nieuwequiz){
		try {
			this.daofacade.voegQuizToe(nieuwequiz);
		} catch (ReedsBestaandeQuizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

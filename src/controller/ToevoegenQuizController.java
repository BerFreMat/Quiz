package controller;

import java.util.List;

import javax.swing.JFrame;

import view.QuizToevoegenFrame;

import exceptions.ReedsBestaandeQuizException;
import model.*;

public class ToevoegenQuizController {

	private DAOFacade daofacade;
	private List<Opdracht> opdrachtcatalogus;
	private List<Opdracht> opdrachtenNogToeTeVoegen;
	private List<Opdracht> opdrachtenToegevoegd;
	private JFrame quiztoevoegenframe;
	
	public ToevoegenQuizController(DAOFacade df, OpstartController opstartcontroller){
		this.daofacade = df;
		this.opdrachtcatalogus = df.getOpdrachten();
		quiztoevoegenframe = new QuizToevoegenFrame(opstartcontroller, this);
		
		
		
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

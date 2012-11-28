/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.ReedsBestaandeOpdrachtException;
import exceptions.ReedsBestaandeQuizException;

/**
 * @author java
 *
 */
public class TextDAOFacade implements DAOFacade {

    private QuizCatalogus quizCatalogus;
    private OpdrachtCatalogus opdrachtCatalogus;

    public TextDAOFacade() throws Exception
    {
    	this.quizCatalogus = new QuizCatalogus();
    	this.opdrachtCatalogus = new OpdrachtCatalogus();
    	this.quizCatalogus.lezen();
    	this.opdrachtCatalogus.lezen();
    }
    
	@Override
	public List<Opdracht> getOpdrachten() {
		return opdrachtCatalogus.getOpdrachten();
	}

	@Override
	public List<Opdracht> getOpdrVanType(OpdrachtSoort opdrachtsoort) {
		return opdrachtCatalogus.getOpdrVanType(opdrachtsoort);
	}

	@Override
	public List<Opdracht> getOpdrVanCategorie(OpdrachtCategorie opdrachtCategorie) {
		return opdrachtCatalogus.getOpdrVanCategorie(opdrachtCategorie);
	}

	@Override
	public void schrijfWeg() throws Exception {
		quizCatalogus.schrijfNaarBestand();
		opdrachtCatalogus.schrijfNaarBestand();
	}

	@Override
	public void voegQuizToe(Quiz quiz) throws ReedsBestaandeQuizException {
		quizCatalogus.voegQuizToe(quiz);
		opdrachtCatalogus.voegQuizToe(quiz);
	}
	
	public void voegOpdrachtToe(Opdracht opdracht) throws ReedsBestaandeOpdrachtException  {
		opdrachtCatalogus.voegOpdrachtToe(opdracht);
	}

}

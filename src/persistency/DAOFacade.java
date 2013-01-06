/**
 * 
 */
package persistency;

import java.sql.SQLException;
import java.util.List;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.OpdrachtSoort;
import model.Quiz;

import exceptions.OpdrachtNietGevondenException;
import exceptions.ReedsBestaandeOpdrachtException;
import exceptions.ReedsBestaandeQuizException;

/**
 * @author java
 *
 */
public interface DAOFacade {
	
	public List<Opdracht> getOpdrachten() throws SQLException;
	public List<Opdracht> getOpdrVanType(OpdrachtSoort opdrachtsoort);
	public List<Opdracht> getOpdrVanCategorie(OpdrachtCategorie opdrachtCategorie);
	public void schrijfWeg() throws Exception;
	public void voegQuizToe(Quiz quiz) throws ReedsBestaandeQuizException;
	public void voegOpdrachtToe(Opdracht opdracht) throws ReedsBestaandeOpdrachtException ;
	public OpdrachtCatalogus getOpdrachtCatalogus();
	public int bepaalLaatsteQuizIDinCatalogus();
}

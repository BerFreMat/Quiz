/**
 * 
 */
package model;

import java.util.List;

import exceptions.ReedsBestaandeOpdrachtException;
import exceptions.ReedsBestaandeQuizException;

/**
 * @author java
 *
 */
public interface DAOFacade {
	public List<Opdracht> getOpdrachten();
	public List<Opdracht> getOpdrVanType(OpdrachtSoort opdrachtsoort);
	public List<Opdracht> getOpdrVanCategorie(OpdrachtCategorie opdrachtCategorie);
	public void schrijfWeg() throws Exception;
	public void voegQuizToe(Quiz quiz) throws ReedsBestaandeQuizException;
	public void voegOpdrachtToe(Opdracht opdracht) throws ReedsBestaandeOpdrachtException ;
}

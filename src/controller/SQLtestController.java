package controller;

import java.util.List;

import exceptions.ReedsBestaandeOpdrachtException;
import exceptions.ReedsBestaandeQuizException;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.OpdrachtSoort;
import model.Quiz;

import persistency.*;
import view.*;

public class SQLtestController implements DAOFacade {

	private DAOFacade sqldaofacade;
	private SQLtestFrame sqltestframe;
	
	public SQLtestController(){
		sqldaofacade = new MySQLDAOFacade();
		List<Opdracht> listopdr = sqldaofacade.getOpdrachten();
		
		sqltestframe = new SQLtestFrame(listopdr);
		sqltestframe.setVisible(true);
	}

	@Override
	public List<Opdracht> getOpdrachten() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opdracht> getOpdrVanType(OpdrachtSoort opdrachtsoort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opdracht> getOpdrVanCategorie(
			OpdrachtCategorie opdrachtCategorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void schrijfWeg() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voegQuizToe(Quiz quiz) throws ReedsBestaandeQuizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voegOpdrachtToe(Opdracht opdracht)
			throws ReedsBestaandeOpdrachtException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OpdrachtCatalogus getOpdrachtCatalogus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int bepaalLaatsteQuizIDinCatalogus() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

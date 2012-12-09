package controller;

import java.util.List;

import model.Opdracht;

import persistency.*;
import view.*;

public class SQLtestController {

	private DAOFacade sqldaofacade;
	private SQLtestFrame sqltestframe;
	
	public SQLtestController(){
		sqldaofacade = new MySQLDAOFacade();
		List<Opdracht> listopdr = sqldaofacade.getOpdrachten();
		
		sqltestframe = new SQLtestFrame(listopdr);
		sqltestframe.setVisible(true);
	}
	
}

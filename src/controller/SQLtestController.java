package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Opdracht;

import persistency.*;
import view.*;

public class SQLtestController {

	private DAOFacade sqldaofacade;
	private SQLtestFrame sqltestframe;
	
	public SQLtestController(){
		sqldaofacade = new MySQLDAOFacade();
		List<Opdracht> listopdr;
		try {
			listopdr = sqldaofacade.getOpdrachten();
		} catch (SQLException e) {
			listopdr = new ArrayList<Opdracht>();
			e.printStackTrace();
		}
		
		sqltestframe = new SQLtestFrame(listopdr);
		sqltestframe.setVisible(true);
	}
	
}

package persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.OpdrachtSoort;
import model.OpenVraag;
import model.Quiz;
import exceptions.ReedsBestaandeOpdrachtException;
import exceptions.ReedsBestaandeQuizException;

public class MySQLDAOFacade implements DAOFacade {

	/**
	 * constructor met opening connectie
	 */
	public MySQLDAOFacade(){

		/** testing the connection
		String DB_URL = "jdbc:mysql://localhost/QuizDBGroep2";
		Connection con = DriverManager.getConnection(DB_URL,"root","Nimbus2000");
		
		try{
			
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM QuizDBGroep2.OpdrachtCategorie;");
			
			while(res.next())
			{
				System.out.println(res.getString(2));
			}
		}
		catch(SQLException sqlexc){
			System.out.println(sqlexc.getMessage());
		}
		*/
	
	}
	
	
	@Override
	public List<Opdracht> getOpdrachten() throws SQLException {
		String DB_URL = "jdbc:mysql://localhost/QuizDBGroep2";
		List<Opdracht> listopdracht = new ArrayList<Opdracht>();
		Connection con = DriverManager.getConnection(DB_URL,"root","Nimbus2000");
		
		try{
			
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM QuizDBGroep2.Opdracht INNER JOIN QuizDBGroep2.OpdrachtOpenVraag " +
					"							ON QuizDBGroep2.Opdracht.OpdrachtID = QuizDBGroep2.OpdrachtOpenVraag.OpdrachtID ;");
			
			while(res.next())
			{
				Opdracht nopdr;
				int i = Integer.parseInt(res.getString(5));
				switch (i){
				case 4: nopdr = new OpenVraag(res.getString(1),res.getString(6));
						listopdracht.add(nopdr);
						break;
				default: 
						break;
				}

			}
			
			
		}
		catch(SQLException sqlexc){
			System.out.println(sqlexc.getMessage());
		}
		finally{
			con.close();
		}
		return listopdracht;
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

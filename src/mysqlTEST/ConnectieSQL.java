package mysqlTEST;

import java.sql.*;


import com.mysql.*;
import org.*;

public class ConnectieSQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DB_URL = "jdbc:mysql://localhost/QuizDB";
		
		try{
			Connection con = DriverManager.getConnection(DB_URL,"root","Nimbus2000");
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from QuizDB.Quiz");
			
			while(res.next())
			{
				System.out.println(res.getString(2));
			}
		}
		catch(SQLException sqlexc){
			System.out.println(sqlexc.getMessage());
		}

	}

}

package es.studium.AD12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio4 {

	private final static String user = "root";
	private final static String pass = "Studium2018;";

	private static final String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/AD12_JARC";

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {


		try {

			Class.forName(driver).newInstance();
			Connection dbcon = DriverManager.getConnection(url, user, pass);
			Statement st = dbcon.createStatement();
			String sentencia = "DELETE FROM `titles` ORDER BY emp_no DESC LIMIT 1;";
			st.executeUpdate(sentencia);		    


		} finally {


		}



	}

}

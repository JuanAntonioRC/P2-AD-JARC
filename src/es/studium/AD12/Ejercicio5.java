package es.studium.AD12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio5 {

	private final static String user = "root";
	private final static String pass = "Studium2018;";

	private static final String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/AD12_JARC";

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {


		try {

			Class.forName(driver).newInstance();
			Connection dbcon = DriverManager.getConnection(url, user, pass);
			Statement st = dbcon.createStatement();
			String sentencia = "select * from salaries where salary > (select avg(salary) from salaries) order by salary;";
			ResultSet rs = st.executeQuery(sentencia);
			int columns = rs.getMetaData().getColumnCount();
			StringBuilder message = new StringBuilder();

			while (rs.next()) {
			    for (int i = 1; i <= columns; i++) {
			        message.append(rs.getString(i) + " ");
			    }
			    message.append("\n");
			}

			System.out.println(message); 


		} finally {


		}



	}

}

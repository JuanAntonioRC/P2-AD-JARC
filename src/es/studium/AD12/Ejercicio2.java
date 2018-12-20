package es.studium.AD12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2 {
	
	private final static String user = "root";
	private final static String pass = "Studium2018;";
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/AD12_JARC";

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		String csvFile = "titles.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		try {
			//creamos el bufferedReader para obtener los datos del fichero cvs y se repite hasta que el documento ya no tenga más líneas 
		    br = new BufferedReader(new FileReader(csvFile));
		    
		    while ((line = br.readLine()) != null) {      
		    	//creamos un array de datos que separamos 
		        String[] datos = line.split(cvsSplitBy);
		        //Imprime datos.
		        System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3]);
		       
		       	Class.forName(driver).newInstance();
				Connection dbcon = DriverManager.getConnection(url, user, pass);
			    Statement st = dbcon.createStatement();
			    String sentenciaUpdateNumConnections = "SET GLOBAL max_connections = 100000";
			    String sentencia = "INSERT INTO `AD12_JARC`.`titles` (`emp_no`, `title`, `from_date`, `to_date`) VALUES ('"+ datos[0] + "','" + datos[1] + "','" + datos[2] + "','" + datos[3] + "')";
				st.executeUpdate(sentenciaUpdateNumConnections);
				st.executeUpdate(sentencia);		    }
		    
		    
		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		


	}

}

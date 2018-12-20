package es.studium.AD12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio1 {
	
	
	private final static String user = "root";
	private final static String pass = "Studium2018;";
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/AD12_JARC";
	

	public static void main(String[] args) {
		File file = new File("salaries.xml");
		
		try {
			
			//se crea el documento 
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  Document doc = dBuilder.parse(file);
			  
			  doc.getDocumentElement().normalize();
			  
			  //conseguimos los nodos y los metemos dentro de un NodeList
			  
			  NodeList nList = doc.getElementsByTagName("ROW");
			  System.out.println("Número de filas: " + nList.getLength() + "\n");
			  
			  
			  //se repite por el número de nodos dentro del documento
			  for(int temp = 0; temp < nList.getLength(); temp++) {
				  Node nNode = nList.item(temp);

				  if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				    Element eElement = (Element) nNode;

				    Class.forName(driver).newInstance();
					Connection dbcon = DriverManager.getConnection(url, user, pass);
				    Statement st = dbcon.createStatement();
				    String sentenciaUpdateNumConnections = "SET GLOBAL max_connections = 100000";
				    String sentencia = "INSERT INTO `AD12_JARC`.`salaries` (`emp_no`, `salary`, `from_date`, `to_date`) VALUES ('"+ eElement.getElementsByTagName("emp_no").item(0).getTextContent() + "','" + eElement.getElementsByTagName("salary").item(0).getTextContent() + "','" + eElement.getElementsByTagName("from_date").item(0).getTextContent() + "','" + eElement.getElementsByTagName("to_date").item(0).getTextContent() + "')";
					st.executeUpdate(sentenciaUpdateNumConnections);
				    st.executeUpdate(sentencia);
					
					
				  }
				}
			} catch(Exception e) {
			  e.printStackTrace();
			}
		
	}

}

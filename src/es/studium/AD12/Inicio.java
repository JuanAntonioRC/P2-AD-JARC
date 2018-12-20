package es.studium.AD12;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 218, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImportarXml = new JButton("Importar XML a BD");
		btnImportarXml.setBounds(28, 44, 160, 29);
		contentPane.add(btnImportarXml);
		btnImportarXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if (objetoPulsado.equals(btnImportarXml)) {
					
					Ejercicio1.main(null);
				}
			}
		});
		
		JButton btnImportarCvsA = new JButton("Importar CVS a BD");
		btnImportarCvsA.setBounds(28, 85, 160, 29);
		contentPane.add(btnImportarCvsA);
		btnImportarCvsA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(btnImportarCvsA)) {
					
					try {
						Ejercicio2.main(null);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		JButton btnDoblarSalario = new JButton("Doblar salario");
		btnDoblarSalario.setBounds(28, 126, 160, 29);
		contentPane.add(btnDoblarSalario);
		btnDoblarSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if (objetoPulsado.equals(btnDoblarSalario)) {
					
					try {
						Ejercicio3.main(null);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton btnObtenerYEliminar = new JButton("Obtener y eliminar");
		btnObtenerYEliminar.setBounds(28, 167, 160, 29);
		contentPane.add(btnObtenerYEliminar);
		btnObtenerYEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnObtenerYEliminar)) {
					try {
						Ejercicio4.main(null);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		JButton btnSuperiorAMedia = new JButton("Superior a media");
		btnSuperiorAMedia.setBounds(28, 208, 160, 29);
		contentPane.add(btnSuperiorAMedia);
		btnSuperiorAMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(btnSuperiorAMedia)) {
					
					try {
						Ejercicio5.main(null);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
}

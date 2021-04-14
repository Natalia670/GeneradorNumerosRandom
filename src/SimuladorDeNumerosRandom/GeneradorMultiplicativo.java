package SimuladorDeNumerosRandom;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GeneradorMultiplicativo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneradorMultiplicativo frame = new GeneradorMultiplicativo();
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
	public GeneradorMultiplicativo() {
		setTitle("GENERADOR MULTIPLICATIVO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1172,529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inserte variables iniciales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.setBounds(24, 36, 529, 195);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(113, 35, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(355, 35, 86, 20);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(113, 78, 86, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(113, 125, 86, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("Semilla:");
		lblNewLabel_1.setBounds(57, 38, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00F3dulo:");
		lblNewLabel_2.setBounds(57, 81, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("a: ");
		lblNewLabel_2_1.setBounds(82, 125, 21, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Iteraciones: ");
		lblNewLabel_2_3.setBounds(286, 38, 61, 14);
		panel.add(lblNewLabel_2_3);
		
		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.setBounds(401, 152, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1.setBounds(24, 242, 529, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 25, 509, 184);
		panel_1.add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("Generador Multiplicativo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(499, 0, 162, 28);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prueba de Chi Cuadrada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_1.setBounds(601, 36, 512, 195);
		contentPane.add(panel_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(10, 25, 492, 120);
		panel_1_1.add(textArea_1_1);
		
		JButton btnNewButton_2 = new JButton("Calcular");
		btnNewButton_2.setBounds(413, 156, 89, 23);
		panel_1_1.add(btnNewButton_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prueba de Kolmogorov Smirnov", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_2.setBounds(601, 242, 512, 220);
		contentPane.add(panel_1_2);
		
		JTextArea textArea_1_2 = new JTextArea();
		textArea_1_2.setBounds(10, 32, 492, 130);
		panel_1_2.add(textArea_1_2);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(413, 174, 89, 23);
		panel_1_2.add(btnNewButton);
	}
	
	  public static int multiplicativo(int semilla, int modulo, int a, int iteraciones){
	        if(iteraciones == 0) {
	            return semilla;
	        } else {
	            int resIteracion = (a * multiplicativo(semilla, modulo, a, iteraciones-1)) % modulo;
	            System.out.println("X" + iteraciones + ":");
	            System.out.println("Numero aleatorio: " + resIteracion);
	            return resIteracion;
	        }
	    }
}

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

public class CongruencialMixto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CongruencialMixto frame = new CongruencialMixto();
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
	public CongruencialMixto() {
		setTitle("CONGRUENCIAL MIXTO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1137,774);
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
		textField_1.setBounds(268, 35, 86, 20);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(268, 78, 86, 20);
		panel.add(textField_2);
		
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
		lblNewLabel_2_1.setBounds(246, 35, 21, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("c: ");
		lblNewLabel_2_2.setBounds(246, 80, 12, 17);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Iteraciones: ");
		lblNewLabel_2_3.setBounds(37, 128, 61, 14);
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
		
		JLabel lblNewLabel = new JLabel("M\u00E9todo Congruencial Mixto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(495, -3, 200, 28);
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
		
		JButton btnNewButton_3 = new JButton("Calcular");
		btnNewButton_3.setBounds(413, 173, 89, 23);
		panel_1_2.add(btnNewButton_3);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Validaci\u00F3n de Hull Dobell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_3.setBounds(24, 491, 529, 220);
		contentPane.add(panel_1_3);
		
		JTextArea textArea_1_3 = new JTextArea();
		textArea_1_3.setBounds(10, 25, 494, 150);
		panel_1_3.add(textArea_1_3);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(415, 186, 89, 23);
		panel_1_3.add(btnNewButton);
	}
	
	 public static int congruencial(int semilla, int modulo, int a, int c, int iteraciones){
	        if(iteraciones == 0) {
	            return semilla;
	        } else {
	            int resIteracion = (a * congruencial(semilla, modulo, a, c, iteraciones-1)+c) % modulo;
	            System.out.println("X" + iteraciones + ":");
	            System.out.println("Numero aleatorio: " + resIteracion);
	            return resIteracion;
	        }
	    }

	    public static void comprobacion(int m, int a, int c){
	        if (maximoComunDivisor(c, m) == 1) System.out.println("Pasa primera regla");
	        else System.out.println("No pasa primera regla");

	        if(segundaRegla(m, a)) System.out.println("Pasa segunda regla");
	        else System.out.println("No pasa segunda regla");

	        if(terceraRegla(m, a)) System.out.println("Pasa tercera regla");
	        else System.out.println("No pasa tercera regla");        
	    } 

	    public static int maximoComunDivisor(int a, int b) {
	        if (b == 0) return a;
	        return maximoComunDivisor(b, a % b);
	    }

	    public static int numPrimo(int numero) {
	        if (numero <= 1) {
	            return 0;
	        }
	        int contador = 0;
	        for (int i = (int) Math.sqrt(numero); i > 1; i--) {
	            if (numero % i == 0) {
	                //System.out.println("Contador " + contador + " Numero " + numero + " i " + i);
	                contador++;
	                return i;
	            }
	        }
	        return numero;
	    }

	    public static boolean segundaRegla(int m, int a){
	        int q = numPrimo(m);
	        System.out.println("q " + q + " de m " + m);
	        if (m %  q == 0 && (a-1) % q == 0){
	            return true;
	        } 
	        return false;
	    }

	    public static boolean terceraRegla(int m, int a){
	        if (m % 4 == 0 && (a-1) % 4 == 0){
	            return true;
	        } 
	        return false;
	    }
}

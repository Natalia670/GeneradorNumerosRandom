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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JScrollPane;

public class Congruencial extends JFrame {

	private JPanel contentPane;
	private JTextField semilla;
	private JTextField a;
	private JTextField c;
	private JTextField modulo;
	private JTextField iteraciones;
	static JTextArea resultados = new JTextArea();
	private final JTextField significancia = new JTextField();
	private final JLabel lblNewLabel_2_2_1 = new JLabel("Significancia:");
	static ArrayList<Double> observables = new ArrayList<Double>();
	private JTextField grados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Congruencial frame = new Congruencial();
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
	public Congruencial() {
		setTitle("CONGRUENCIAL");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1172,529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inserte variables iniciales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.setBounds(24, 39, 529, 195);
		contentPane.add(panel);
		panel.setLayout(null);
		
		semilla = new JTextField();
		semilla.setBounds(124, 35, 86, 20);
		panel.add(semilla);
		semilla.setColumns(10);
		
		a = new JTextField();
		a.setBounds(305, 35, 86, 20);
		a.setColumns(10);
		panel.add(a);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(305, 78, 86, 20);
		panel.add(c);
		
		modulo = new JTextField();
		modulo.setColumns(10);
		modulo.setBounds(124, 78, 86, 20);
		panel.add(modulo);
		
		iteraciones = new JTextField();
		iteraciones.setColumns(10);
		iteraciones.setBounds(124, 125, 86, 20);
		panel.add(iteraciones);
		
		JLabel lblNewLabel_1 = new JLabel("Semilla:");
		lblNewLabel_1.setBounds(57, 38, 86, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00F3dulo:");
		lblNewLabel_2.setBounds(57, 81, 73, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("a: ");
		lblNewLabel_2_1.setBounds(274, 35, 21, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("c: ");
		lblNewLabel_2_2.setBounds(274, 80, 21, 17);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Iteraciones: ");
		lblNewLabel_2_3.setBounds(37, 128, 93, 14);
		panel.add(lblNewLabel_2_3);
		
		JButton calcularRes = new JButton("Calcular");
		calcularRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sem = Integer.parseInt(semilla.getText());
				int m = Integer.parseInt(modulo.getText());
				int aInput = Integer.parseInt(a.getText());
				int cInput = Integer.parseInt(c.getText());
				int ite = Integer.parseInt(iteraciones.getText());
				if(sem < 1) {
					resultados.setText("");
					resultados.setText("La semilla debe de ser mayor que 0");
				} else if (ite < 1){
					resultados.setText("");
					resultados.setText("La iteraciÃ³n debe ser mayor a 0");
				} else {
					resultados.setText("");
					congruencial(sem, m, aInput, cInput, ite);
				}
			}
		});
		calcularRes.setBounds(423, 157, 89, 23);
		panel.add(calcularRes);
		significancia.setText("0.05");
		significancia.setColumns(10);
		significancia.setBounds(329, 125, 86, 20);
		
		panel.add(significancia);
		lblNewLabel_2_2_1.setBounds(237, 127, 85, 17);
		
		panel.add(lblNewLabel_2_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1.setBounds(24, 242, 529, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 509, 184);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(resultados);
		
		JLabel lblNewLabel = new JLabel("M\u00E9todo Congruencial");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(513, 0, 142, 28);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prueba de Chi Cuadrada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_1.setBounds(601, 36, 512, 195);
		contentPane.add(panel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 25, 492, 120);
		panel_1_1.add(scrollPane_1);
		
		JTextArea resultadosChi = new JTextArea();
		scrollPane_1.setViewportView(resultadosChi);
		
		grados = new JTextField();
		grados.setText("3");
		grados.setBounds(153, 156, 86, 20);
		panel_1_1.add(grados);
		grados.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Calcular");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ArrayList<Double> b = prueba();
				double signi = Double.parseDouble(significancia.getText());
				int grad = Integer.parseInt(grados.getText());
				resultadosChi.setText("");
				if(observables.size() == 0) {
					resultados.append("Lista vacía");
				}else {
					ChiCuadrada cc = new ChiCuadrada(observables);
					double tabla = cc.ChiTable(grad, signi);
					double chiCuadradaSum = cc.CalcularValores();
					boolean isAccepted = cc.acceptNullHypothesis(chiCuadradaSum, tabla);
					resultadosChi.append("Chi obtenida: " + chiCuadradaSum + "\n");
					resultadosChi.append("Chi tabla: " + tabla + "\n");
					if(isAccepted) resultadosChi.append("Se acepta la hipótesis nula\n");
					else resultadosChi.append("No se acepta la hipótesis nula \n");

				}	
			}
		});
		btnNewButton_2.setBounds(413, 156, 89, 23);
		panel_1_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Grados de libertad:");
		lblNewLabel_3.setBounds(31, 160, 107, 14);
		panel_1_1.add(lblNewLabel_3);
		
	
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prueba de Kolmogorov Smirnov", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_2.setBounds(601, 242, 512, 220);
		contentPane.add(panel_1_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 32, 492, 130);
		panel_1_2.add(scrollPane_2);
		
		JTextArea resultadosSmirnov = new JTextArea();
		scrollPane_2.setViewportView(resultadosSmirnov);
		
		JButton btnSmirnov = new JButton("Calcular");
		btnSmirnov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Faltan validaciones de input
				double signi = Double.parseDouble(significancia.getText());
				
				if(observables.size() > 0) {
					
					resultadosSmirnov.setText("");
					Smirnov smirnov = new Smirnov(observables);
					double d = smirnov.calcular();
					resultadosSmirnov.append("D: " + d + "\n");
					double dAlfa = smirnov.kolmogorovSmirnovTabla(signi);
					resultadosSmirnov.append("D alfa: " + dAlfa + "\n");
					if (smirnov.aceptacionHipostesis(signi)) {
						resultadosSmirnov.append("Se acepta la hipotesis nula \n");
					} else {
						resultadosSmirnov.append("Se rechaza la hipotesis nula \n");
					}
				} else {
					resultadosSmirnov.append("Lista vacia \n");
				}
				
				observables.clear();
			}
		});
		btnSmirnov.setBounds(413, 174, 89, 23);
		panel_1_2.add(btnSmirnov);
		
	}
	
	 public static int congruencial(int semilla, int modulo, int a, int c, int iteraciones){
	        if(iteraciones == 0) {
	            return semilla;
	        } else {
	            int resIteracion = (a * congruencial(semilla, modulo, a, c, iteraciones-1)+c) % modulo;
	            double ri = (double) resIteracion / (double) modulo;
	            observables.add(ri);
	            resultados.append("Iteracion: " + iteraciones + " | No. aleatorio: " + resIteracion + " | Ri: " + ri + "\n");
	            return resIteracion;
	        }
	    }
}

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GeneradorMultiplicativo extends JFrame {

	private JPanel contentPane;
	private JTextField semilla;
	private JTextField iteraciones;
	private JTextField modulo;
	private JTextField a;
	private JTextField significancia;
	static JTextArea resultados = new JTextArea();
	static ArrayList<Double> observables = new ArrayList<Double>();

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
		
		semilla = new JTextField();
		semilla.setBounds(115, 35, 86, 20);
		panel.add(semilla);
		semilla.setColumns(10);
		
		iteraciones = new JTextField();
		iteraciones.setBounds(355, 35, 86, 20);
		iteraciones.setColumns(10);
		panel.add(iteraciones);
		
		modulo = new JTextField();
		modulo.setColumns(10);
		modulo.setBounds(115, 78, 86, 20);
		panel.add(modulo);
		
		a = new JTextField();
		a.setColumns(10);
		a.setBounds(115, 125, 86, 20);
		panel.add(a);
		
		JLabel lblNewLabel_1 = new JLabel("Semilla:");
		lblNewLabel_1.setBounds(57, 38, 61, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00F3dulo:");
		lblNewLabel_2.setBounds(57, 81, 61, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("a: ");
		lblNewLabel_2_1.setBounds(82, 125, 21, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Iteraciones: ");
		lblNewLabel_2_3.setBounds(261, 38, 86, 14);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Significancia:");
		lblNewLabel_2_3_1.setBounds(261, 80, 86, 14);
		panel.add(lblNewLabel_2_3_1);
		
		significancia = new JTextField();
		significancia.setColumns(10);
		significancia.setBounds(355, 75, 86, 20);
		panel.add(significancia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1.setBounds(24, 242, 529, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 509, 184);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(resultados);
		
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sem = Integer.parseInt(semilla.getText());
				int m = Integer.parseInt(modulo.getText());
				int aInput = Integer.parseInt(a.getText());
				int ite = Integer.parseInt(iteraciones.getText());
				if(sem < 1) {
					resultados.setText("");
					resultados.setText("La semilla debe de ser mayor que 0");
				} else if (ite < 1){
					resultados.setText("");
					resultados.setText("La iteración debe ser mayor a 0");
				} else {
					resultados.setText("");
					multiplicativo(sem, m, aInput, ite);
				}
			}
		});
		calcular.setBounds(401, 152, 89, 23);
		panel.add(calcular);
		
		JLabel lblNewLabel = new JLabel("Generador Multiplicativo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(499, 0, 162, 28);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prueba de Chi Cuadrada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_1.setBounds(601, 36, 512, 195);
		contentPane.add(panel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 25, 492, 120);
		panel_1_1.add(scrollPane_1);
		
		JTextArea res_chi = new JTextArea();
		scrollPane_1.setViewportView(res_chi);
		
		JButton calcularChi = new JButton("Calcular");
		calcularChi.setBounds(413, 156, 89, 23);
		panel_1_1.add(calcularChi);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prueba de Kolmogorov Smirnov", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_2.setBounds(601, 242, 512, 220);
		contentPane.add(panel_1_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 32, 492, 130);
		panel_1_2.add(scrollPane_2);
		
		JTextArea res_smirnov = new JTextArea();
		scrollPane_2.setViewportView(res_smirnov);
		
		JButton calcularSmirnov = new JButton("Calcular");
		calcularSmirnov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(observables.size() > 0) {
					double signi = Double.parseDouble(significancia.getText());
					res_smirnov.setText("");
					Smirnov smirnov = new Smirnov(observables);
					double d = smirnov.calcular();
					res_smirnov.append("D: " + d + "\n");
					double dAlfa = smirnov.kolmogorovSmirnovTabla(signi);
					res_smirnov.append("D alfa: " + dAlfa + "\n");
					if (smirnov.aceptacionHipostesis(signi)) {
						res_smirnov.append("Se acepta la hipotesis nula \n");
					} else {
						res_smirnov.append("Se rechaza la hipotesis nula \n");
					}
				} else {
					res_smirnov.append("Lista vacia \n");
				}
			}
		});
		calcularSmirnov.setBounds(413, 174, 89, 23);
		panel_1_2.add(calcularSmirnov);
	}
	
	  public static int multiplicativo(int semilla, int modulo, int a, int iteraciones){
	        if(iteraciones == 0) {
	            return semilla;
	        } else {
	            int resIteracion = (a * multiplicativo(semilla, modulo, a, iteraciones-1)) % modulo;
	            double ri = (double) resIteracion / (double) modulo;
	            observables.add(ri);
	            resultados.append("Iteracion: " + iteraciones + " | No. aleatorio: " + resIteracion + " | Ri: " + ri + "\n");
	            return resIteracion;
	        }
	    }
}

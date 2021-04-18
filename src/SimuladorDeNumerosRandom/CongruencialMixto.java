package SimuladorDeNumerosRandom;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CongruencialMixto extends JFrame {

	private JPanel contentPane;
	private JTextField semilla;
	private JTextField a;
	private JTextField c;
	private JTextField modulo;
	private JTextField iteraciones;
	private JTextField significancia;
	static JTextArea res_hullDobell = new JTextArea();
	static JTextArea resultados = new JTextArea();
	static JTextArea res_smirnov = new JTextArea();
	static ArrayList<Double> observables = new ArrayList<Double>();

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
		
		semilla = new JTextField();
		semilla.setBounds(119, 32, 86, 20);
		panel.add(semilla);
		semilla.setColumns(10);
		
		a = new JTextField();
		a.setBounds(327, 35, 86, 20);
		a.setColumns(10);
		panel.add(a);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(327, 78, 86, 20);
		panel.add(c);
		
		modulo = new JTextField();
		modulo.setColumns(10);
		modulo.setBounds(119, 75, 86, 20);
		panel.add(modulo);
		
		iteraciones = new JTextField();
		iteraciones.setColumns(10);
		iteraciones.setBounds(119, 122, 86, 20);
		panel.add(iteraciones);
		
		JLabel lblNewLabel_1 = new JLabel("Semilla:");
		lblNewLabel_1.setBounds(57, 38, 61, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00F3dulo:");
		lblNewLabel_2.setBounds(57, 81, 61, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("a: ");
		lblNewLabel_2_1.setBounds(305, 35, 21, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("c: ");
		lblNewLabel_2_2.setBounds(305, 80, 21, 17);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Iteraciones: ");
		lblNewLabel_2_3.setBounds(37, 128, 81, 14);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Significancia:");
		lblNewLabel_2_2_1.setBounds(237, 124, 89, 17);
		panel.add(lblNewLabel_2_2_1);
		
		significancia = new JTextField();
		significancia.setColumns(10);
		significancia.setBounds(327, 119, 86, 20);
		panel.add(significancia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1.setBounds(24, 242, 529, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		resultados.setBounds(10, 25, 509, 184);
		panel_1.add(resultados);
		
		JButton calcularResultados = new JButton("Calcular");
		calcularResultados.addActionListener(new ActionListener() {
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
					resultados.setText("La iteración debe ser mayor a 0");
				} else {
					resultados.setText("");
					congruencial(sem, m, aInput, cInput, ite);
				}
			}
		});
		calcularResultados.setBounds(401, 152, 89, 23);
		panel.add(calcularResultados);
		
		JLabel lblNewLabel = new JLabel("M\u00E9todo Congruencial Mixto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(495, -3, 200, 28);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prueba de Chi Cuadrada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_1.setBounds(601, 36, 512, 195);
		contentPane.add(panel_1_1);
		
		JTextArea res_chi = new JTextArea();
		res_chi.setBounds(10, 25, 492, 120);
		panel_1_1.add(res_chi);
		
		JButton calcularChi = new JButton("Calcular");
		calcularChi.setBounds(413, 156, 89, 23);
		panel_1_1.add(calcularChi);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prueba de Kolmogorov Smirnov", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_2.setBounds(601, 242, 512, 220);
		contentPane.add(panel_1_2);
		
		res_smirnov.setBounds(10, 32, 492, 130);
		panel_1_2.add(res_smirnov);
		
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
		calcularSmirnov.setBounds(413, 173, 89, 23);
		panel_1_2.add(calcularSmirnov);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Validaci\u00F3n de Hull Dobell", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1_3.setBounds(24, 491, 529, 220);
		contentPane.add(panel_1_3);
		
		res_hullDobell.setBounds(10, 25, 494, 150);
		panel_1_3.add(res_hullDobell);
		
		JButton calcularHullDobell = new JButton("Calcular");
		calcularHullDobell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m = Integer.parseInt(modulo.getText());
				int aInput = Integer.parseInt(a.getText());
				int cInput = Integer.parseInt(c.getText());
				comprobacion(m, aInput, cInput);
			}
		});
		calcularHullDobell.setBounds(415, 186, 89, 23);
		panel_1_3.add(calcularHullDobell);
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

	    public static void comprobacion(int m, int a, int c){
	        if (maximoComunDivisor(c, m) == 1) res_hullDobell.append("Pasa primera regla \n");
	        else res_hullDobell.append("No pasa primera regla \n");

	        if(segundaRegla(m, a)) res_hullDobell.append("Pasa segunda regla \n");
	        else res_hullDobell.append("No pasa segunda regla \n");

	        if(terceraRegla(m, a)) res_hullDobell.append("Pasa tercera regla \n");
	        else res_hullDobell.append("No pasa tercera regla \n");        
	    } 

	    public static int maximoComunDivisor(int a, int b) {
	        if (b == 0) return a;
	        return maximoComunDivisor(b, a % b);
	    }

	    public static boolean esPrimo(int numero){
	        int contador = 2;
	        boolean primo=true;
	        while ((primo) && (contador!=numero)){
	            if (numero % contador == 0)
	            primo = false;
	            contador++;
	        }
	        return primo;
	    }

	    public static boolean segundaRegla(int m, int a){
	        boolean cumple = false;
	        ArrayList<Integer> primos = new ArrayList<Integer>(); 
	        for(int i = 2; i < m; i++){
	            if(esPrimo(i) && m % i == 0){
	                primos.add(i);
	            }
	        }
	        
	        for(int i = 0; i < primos.size(); i++){
	            System.out.println(primos.get(i));
	            if((a-1) % primos.get(i) == 0){
	                cumple = true;
	            } else {
	                cumple = false;
	                break;
	            }
	        }
	        if(cumple) System.out.println("Cumple");
	        else System.out.println("No cumple");
	        return cumple;
	    }

	    public static boolean terceraRegla(int m, int a){
	        if (m % 4 == 0 && (a-1) % 4 == 0){
	            return true;
	        } 
	        return false;
	    }
}

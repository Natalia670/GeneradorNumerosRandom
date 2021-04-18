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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CongruencialLinealCombinado extends JFrame {

	private JPanel contentPane;
	private JTextField semilla1;
	private JTextField semilla2;
	private JTextField gen1;
	private JTextField gen2;
	private JTextField iteraciones;
	private JTextField mod1;
	private JTextField mod2;
	private static JTextArea textAreaResultados ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CongruencialLinealCombinado frame = new CongruencialLinealCombinado();
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
	public CongruencialLinealCombinado() {
		setTitle("CONGRUENCIAL LINEAL COMBINADO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E9todo Congruencial Lineal Combinado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(159, 11, 259, 26);
		contentPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_2.setBounds(24, 252, 529, 307);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 17, 502, 279);
		panel_2.add(scrollPane);
		
		textAreaResultados = new JTextArea();
		scrollPane.setViewportView(textAreaResultados);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inserte variables iniciales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.setBounds(24, 38, 529, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		semilla1 = new JTextField();
		semilla1.setBounds(27, 48, 112, 29);
		panel.add(semilla1);
		semilla1.setColumns(10);
		
		semilla2 = new JTextField();
		semilla2.setBounds(27, 106, 112, 29);
		panel.add(semilla2);
		semilla2.setColumns(10);
		
		gen1 = new JTextField();
		gen1.setBounds(211, 34, 112, 29);
		panel.add(gen1);
		gen1.setColumns(10);
		
		gen2 = new JTextField();
		gen2.setBounds(211, 93, 112, 29);
		panel.add(gen2);
		gen2.setColumns(10);
		
		iteraciones = new JTextField();
		iteraciones.setBounds(211, 146, 112, 29);
		panel.add(iteraciones);
		iteraciones.setColumns(10);
		
		mod1 = new JTextField();
		mod1.setBounds(393, 48, 112, 29);
		panel.add(mod1);
		mod1.setColumns(10);
		
		mod2 = new JTextField();
		mod2.setBounds(393, 106, 112, 29);
		panel.add(mod2);
		mod2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Semilla 1");
		lblNewLabel_1.setBounds(48, 23, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Semilla 2");
		lblNewLabel_2.setBounds(48, 88, 49, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Generador 1");
		lblNewLabel_3.setBounds(235, 11, 66, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Generador 2");
		lblNewLabel_4.setBounds(235, 74, 66, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Iteraciones");
		lblNewLabel_5.setBounds(235, 132, 66, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Modulo 1");
		lblNewLabel_6.setBounds(421, 23, 49, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Modulo 2");
		lblNewLabel_7.setBounds(421, 88, 49, 14);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float sem1 = Float.parseFloat(semilla1.getText());
				float sem2 = Float.parseFloat(semilla2.getText());
				float g1 = Float.parseFloat(gen1.getText());
				float g2 = Float.parseFloat(gen2.getText());
				float ite = Float.parseFloat(iteraciones.getText());
				float m1 = Float.parseFloat(mod1.getText());
				float m2 = Float.parseFloat(mod2.getText());
				
			       GenLinealComb(sem1, sem2, g1, g2,m1,m2,ite );
			     
			}
		});
		btnNewButton.setBounds(403, 152, 89, 23);
		panel.add(btnNewButton);
	}
	
	   

	    public static void GenLinealComb(float s1, float s2, float g1, float g2, float m1, float m2,  float n){

	        float result1 = s1;
	        float result2 = s2;
	        float mod [] = {m1, m2};
	        float modMax = getModMayor(mod, 2);
	        int itera = 0;
	     
	        for (int i = 0; i<n; i++){
	        	itera++;
	           

	            float res1 = ( result1 * g1) % m1;
	            float res2 = (result2 * g2) % m2;
	           
	            result1 = res1;
	            result2 = res2;

	           
	            float sum = ((res1 - res2) % modMax + modMax) % modMax;
	         
	            textAreaResultados.append(" Iteracion:" + itera + " |Xn: " + res1 + " | Yn: " + res2 + " | Wn: " + sum + "\n");
	            
	        }
	        
	       
	    }
	    
	    public static float getModMayor(float[] a, int total){  
	     float temp;  
	      for (int i = 0; i < total; i++)   
	        {  
	            for (int j = i + 1; j < total; j++)   
	            {  
	                if (a[i] > a[j])   
	                {  
	                    temp = a[i];  
	                    a[i] = a[j];  
	                    a[j] = temp;  
	                }  
	            }  
	        }  
	       return a[total-1];  
	}  
	    
	    
	  
}

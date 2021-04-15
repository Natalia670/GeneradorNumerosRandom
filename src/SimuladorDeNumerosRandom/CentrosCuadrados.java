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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class CentrosCuadrados extends JFrame {

	private JPanel contentPane;
	private JTextField semilla;
	private JTextField iteraciones;
	JTextArea resultados = new JTextArea();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CentrosCuadrados frame = new CentrosCuadrados();
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
	public CentrosCuadrados() {
		setTitle("CENTROS CUADRADOS");
		setBounds(100, 100, 591, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inserte variables iniciales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.setBounds(24, 38, 529, 159);
		contentPane.add(panel);
		
		semilla = new JTextField();
		semilla.setColumns(10);
		
		iteraciones = new JTextField();
		iteraciones.setColumns(10);
			
		JLabel lblNewLabel_1 = new JLabel("Iteraciones: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1 = new JLabel("Semilla:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
	
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hay que hacer validaciones
				
				Integer sem = Integer.parseInt(semilla.getText());
				Integer ite =  Integer.parseInt(iteraciones.getText());
				
				int res = cuadradoMedio(sem.intValue(), ite.intValue());
				System.out.println(res);
				
				String resString = ""+res;
				
				resultados.setText(resString);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(108, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(87)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(102)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(semilla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(iteraciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(219))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(34))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(semilla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(iteraciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_2.setBounds(24, 218, 529, 354);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		resultados.setBounds(25, 28, 477, 304);
		panel_2.add(resultados);
		
		JLabel lblNewLabel = new JLabel("M\u00E9todo de Centros Cuadrados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(196, 11, 192, 14);
		contentPane.add(lblNewLabel);
	}

	public static int cuadradoMedio(int semilla, int iteraciones){

        if(iteraciones == 0) {
            return semilla;
        } else {
            int cuadrado = semilla * semilla;
            String numInicial = "";
            String numCompuesto = "";
            numInicial = cuadrado + "";
            int medio;
            int len = numInicial.length();
            switch(len){
                case 5:
                    numCompuesto = "000"+numInicial;
                    break;
                case 6:
                    numCompuesto = "00"+numInicial;
                    break;
                case 7:
                    numCompuesto = "0"+numInicial;
                    break;
                case 8:
                    numCompuesto = numInicial;
                    break;
            }
            medio = Integer.parseInt(numCompuesto.substring(2, 6));
            //Checar como invertir lo de las iteraciones
            System.out.println("X" + iteraciones + ":");
            System.out.println("Numero aleatorio: " + medio);
            return cuadradoMedio(medio, iteraciones-1);
        }
	}
}

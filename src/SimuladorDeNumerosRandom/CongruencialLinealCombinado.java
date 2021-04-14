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

public class CongruencialLinealCombinado extends JFrame {

	private JPanel contentPane;

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inserte variables iniciales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.setBounds(24, 38, 529, 159);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Procedimiento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1.setBounds(24, 224, 529, 159);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_2.setBounds(24, 413, 529, 159);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("M\u00E9todo Congruencial Lineal Multiplicativo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(159, 11, 259, 26);
		contentPane.add(lblNewLabel);
	}

}

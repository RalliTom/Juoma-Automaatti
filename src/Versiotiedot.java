import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;

public class Versiotiedot {

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void tiedot() {
		
		JFrame frmJuomaautomaattiGuiV = new JFrame();
		frmJuomaautomaattiGuiV.setTitle("Juoma-automaatti GUI v 1.0");
		frmJuomaautomaattiGuiV.getContentPane().setLayout(null);
		frmJuomaautomaattiGuiV.setSize(444,300);
		//frmJuomaautomaattiGuiV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuomaautomaattiGuiV.setVisible(true);

		JLabel lblJuomaautomaattiV = new JLabel("Juoma-automaatti v 1.0");
		lblJuomaautomaattiV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJuomaautomaattiV.setBounds(138, 89, 215, 14);
		frmJuomaautomaattiGuiV.getContentPane().add(lblJuomaautomaattiV);

		JLabel lblTehnytTommiRalli = new JLabel("Tehnyt Tommi Ralli");
		lblTehnytTommiRalli.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTehnytTommiRalli.setBounds(138, 150, 194, 25);
		frmJuomaautomaattiGuiV.getContentPane().add(lblTehnytTommiRalli);

		JLabel lblGraafisenKyttliittymnOhjelmointiharjoitus = new JLabel(
				"Graafisen k\u00E4ytt\u00F6liittym\u00E4n ohjelmointiharjoitus");
		lblGraafisenKyttliittymnOhjelmointiharjoitus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGraafisenKyttliittymnOhjelmointiharjoitus.setBounds(67, 114, 308, 25);
		frmJuomaautomaattiGuiV.getContentPane().add(lblGraafisenKyttliittymnOhjelmointiharjoitus);

		/*
		 * JOptionPane.showMessageDialog(null,
		 * "Juoma-Automaatti v 1.0\nGraafisen käyttöliittymän harjoitustyö\nTehnyt Tommi Ralli"
		 * , "Tietoja", JOptionPane.INFORMATION_MESSAGE);
		 */

	}
}
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

// Esimerkkiratkaisu
/* Ohjelman ratkaisussa pyrin rakentamaan toiminnallisuudet tähän luokkaan ja GUI_Automaattiin pelkän ulkoasun */

public class JuomaAutomaatti {

	private int tee;
	private int kahvi;
	private int kaakao;

	public JuomaAutomaatti() {
		tee = 50;
		kahvi = 50;
		kaakao = 50;
	}

	/*
	 * public JuomaAutomaatti(int tee, int kahvi, int kaakao) { // super(); this.tee
	 * = tee; this.kahvi = kahvi; this.kaakao = kaakao;
	 * 
	 * }
	 */

	// getterit ja setterit
	public int getTee() {
		return tee;
	}

	public void setTee(int tee) {
		this.tee = tee;
	}

	public int getKahvi() {
		return kahvi;
	}

	public void setKahvi(int kahvi) {
		this.kahvi = kahvi;
	}

	public int getKaakao() {
		return kaakao;
	}

	public void setKaakao(int kaakao) {
		this.kaakao = kaakao;
	}

	// juomien valmistusmetodit
	public void valmistaKahvi() {
		if (this.kahvi - 10 < 0) {
			this.kahvi = 0;
			fillErUp();
		}

		else

			try {
				this.kahvi -= 10;
				setKahvi(kahvi);
				if (kahvi <= 20) {
					GUI_Automaatti.KahvinMr.setForeground(Color.RED);
				}
				GUI_Automaatti.KahvinMr.setText("Kahvia: " + kahvi);

			} catch (NullPointerException e) {
				System.out.println("Ei toimi");
			}
	}

	public void valmistaTee() {
		// System.out.println("Odota hetki, teesi valmistuu. ");
		if (this.tee - 10 < 0) {
			this.tee = 0;
			fillErUp();
		}

		else

			try {
				this.tee -= 10;
				setTee(tee);
				if (tee <= 20) {
					GUI_Automaatti.TeenMr.setForeground(Color.RED);
				}
				GUI_Automaatti.TeenMr.setText("Teetä: " + tee);

			} catch (NullPointerException e) {
				System.out.println("Ei!");
			}

	}

	public void valmistaKaakao() {

		if (this.kaakao - 10 < 0) {
			this.kaakao = 0;
			fillErUp();
		}

		else
			try {
				this.kaakao -= 10;
				setKaakao(kaakao);
				if (kaakao <= 20) {
					GUI_Automaatti.KaakaonMr.setForeground(Color.RED);
				}
				GUI_Automaatti.KaakaonMr.setText("Kaakaota: " + kaakao);

			} catch (NullPointerException e) {
				System.out.println("Ei!");
			}

	}

	// täyttömetodit
	public void FillTee() {
		// TODO Auto-generated method stub
		int uusiTee = Integer.parseInt(JOptionPane.showInputDialog(null, "Anna täytettävä määrä: ", "Täytä teetä",
				JOptionPane.INFORMATION_MESSAGE));
		setTee(uusiTee);
		GUI_Automaatti.TeenMr.setText("Teetä: " + getTee());
		if (tee > 20) {
			GUI_Automaatti.TeenMr.setForeground(Color.BLACK);
		}
	}

	public void FillKaakao() {
		int uusiKaakao = Integer.parseInt(JOptionPane.showInputDialog(null, "Anna täytettävä määrä: ", "Täytä kaakaota",
				JOptionPane.INFORMATION_MESSAGE));
		setKaakao(uusiKaakao);
		GUI_Automaatti.KaakaonMr.setText("Kaakaota: " + getKaakao());
		if (kaakao > 20) {
			GUI_Automaatti.KaakaonMr.setForeground(Color.BLACK);
		}
	}

	public void FillKahvi() {
		int uusiKahvi = Integer.parseInt(JOptionPane.showInputDialog(null, "Anna täytettävä määrä: ", "Täytä kahvia",
				JOptionPane.INFORMATION_MESSAGE));
		setKahvi(uusiKahvi);
		GUI_Automaatti.KahvinMr.setText("Kahvia: " + getKahvi());
		if (kahvi > 20) {
			GUI_Automaatti.KahvinMr.setForeground(Color.BLACK);
		}

	}

	// metodi antaa ilmoituksen juoman loppumisesta
	public static void fillErUp() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(GUI_Automaatti.contentPane, "Juoma loppu, täytä säiliö.", "Täytä säiliö",
				JOptionPane.INFORMATION_MESSAGE);
	}

}

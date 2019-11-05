import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.JTextPane;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitellään täällä jotta komponentteihin voidaan viitata mistä tahansa luokan
	// sisältä

	static JLabel KahvinMr;
	static JLabel TeenMr;
	static JLabel KaakaonMr;
	static JPanel contentPane;
	static JOptionPane optionPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;

	/**
	 * Main-metodi, joka käynnistää sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// Käyttöliittymä saa parametrina olion, jonka tiedot se näyttää
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan käyttöliittymä. Huomaa, että otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. Tämä siksi, että voidaan näyttää sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);

		// Ikkunan sisällä olevat graafiset elementit
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnYllpito = new JMenu("Yll\u00E4pito");
		menuBar.add(mnYllpito);

		// Kuuntelija, joka kutsuu metodin JuomaAutomaatti-luokasta
		JMenuItem mntmNewMenuItem = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ja.FillKahvi();
			}
		});
		mnYllpito.add(mntmNewMenuItem);

		JMenuItem mntmAsetaTeenMr = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		// Kuuntelija, joka kutsuu metodin JuomaAutomaatti-luokasta
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.FillTee();
			}
		});
		mnYllpito.add(mntmAsetaTeenMr);

		JMenuItem mntmAsetaKaakaonMr = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		// Kuuntelija, joka kutsuu metodin JuomaAutomaatti-luokasta
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.FillKaakao();
			}
		});
		mnYllpito.add(mntmAsetaKaakaonMr);

		JMenuItem mntmTallennaAutomaatinTila_1 = new JMenuItem("Tallenna automaatin tila");
		// Kuuntelija, joka kutsuu metodin toisesta luokasta
		mntmTallennaAutomaatinTila_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnYllpito.add(mntmTallennaAutomaatinTila_1);

		JMenuItem mntmLataaAutomaatti_1 = new JMenuItem("Lataa automaatti");
		// Kuuntelija, joka kutsuu metodin Sarjallistamista-luokasta
		mntmLataaAutomaatti_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
					int uusikahvi = uusi.getKahvi();
					ja.setKahvi(uusikahvi);
					KahvinMr.setText("Kahvia: " + uusikahvi);
					if (uusikahvi > 20) {
						KahvinMr.setForeground(Color.BLACK);
					}
					
					int uusitee = uusi.getTee();
					ja.setTee(uusitee);
					TeenMr.setText("Teetä: " + uusitee);
					if (uusitee > 20) {
						TeenMr.setForeground(Color.BLACK);
					}
					
					int uusikaakao = uusi.getKaakao();
					ja.setKaakao(uusikaakao);
					KaakaonMr.setText("Kaakaota: " + uusikaakao);
					if (uusikaakao > 20) {
						KaakaonMr.setForeground(Color.BLACK);
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		mnYllpito.add(mntmLataaAutomaatti_1);

		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		// Kuuntelija, joka kutsuu metodin JuomaAutomaatti-luokasta
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Kyllä", "Ei" };
				int response = JOptionPane.showOptionDialog(null, "Haluatko sulkea ohjelman?", "Sulje",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (response == JOptionPane.NO_OPTION) {

				} else if (response == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		mnYllpito.add(mntmLopeta);

		JMenu mnTietojaOhjelmasta = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnTietojaOhjelmasta);

		JMenuItem mntmVersio = new JMenuItem("Versio");
		mntmVersio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot.tiedot();
			}
		});
		mnTietojaOhjelmasta.add(mntmVersio);

		JMenuItem mntmOhje = new JMenuItem("Ohje");
		mntmOhje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mntmVersio,
						"Tilaa juoma napsauttamalla kuvaketta. Kuvakkeen oikealla puolella näkyy paljonko juomaa on jäljellä.\nJuoman loppuessa täytä juoma ylläpito-painikkeen alta.",
						"Ohje", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnTietojaOhjelmasta.add(mntmOhje);

		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton tilaaKahvi = new JButton("");
		tilaaKahvi.setBorderPainted(false);
		tilaaKahvi.setSize(new Dimension(140, 134));

		tilaaKahvi.setBounds(11, 28, 173, 143);
		tilaaKahvi.setHorizontalAlignment(SwingConstants.LEFT);
		tilaaKahvi.setVerticalAlignment(SwingConstants.TOP);
		tilaaKahvi.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/coffee.jpg")));
		contentPane.add(tilaaKahvi);

		// Juomatilausnappien kuuntelijat, kutsuvat metodin JuomaAutomaatti luokasta
		tilaaKahvi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ja.valmistaKahvi();
			}
		});

		JButton tilaaTee = new JButton("");
		tilaaTee.setBorderPainted(false);
		tilaaTee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ja.valmistaTee();
			}
		});
		tilaaTee.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/tea.jpg")));
		tilaaTee.setBounds(11, 210, 173, 143);
		contentPane.add(tilaaTee);

		JButton tilaaKaakao = new JButton("");
		tilaaKaakao.setBorderPainted(false);
		tilaaKaakao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ja.valmistaKaakao();
			}
		});
		tilaaKaakao.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/cocoa.jpg")));
		tilaaKaakao.setBounds(11, 396, 173, 143);
		contentPane.add(tilaaKaakao);

		JLabel lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Arial", Font.PLAIN, 12));
		lblKahvi.setBounds(38, 172, 115, 33);
		contentPane.add(lblKahvi);

		JLabel lblTee = new JLabel("Tee");
		lblTee.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTee.setBounds(38, 358, 115, 33);
		contentPane.add(lblTee);

		JLabel lblKaakao = new JLabel("Kaakao");
		lblKaakao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblKaakao.setBounds(38, 544, 115, 33);
		contentPane.add(lblKaakao);

		KahvinMr = new JLabel("Kahvia: " + ja.getKahvi());
		KahvinMr.setFont(new Font("Arial", Font.PLAIN, 12));
		KahvinMr.setBounds(210, 83, 115, 33);
		contentPane.add(KahvinMr);

		TeenMr = new JLabel("Teet\u00E4: " + ja.getTee());
		TeenMr.setFont(new Font("Arial", Font.PLAIN, 12));
		TeenMr.setBounds(210, 265, 115, 33);
		contentPane.add(TeenMr);

		KaakaonMr = new JLabel();
		KaakaonMr.setText("Kaakaota: " + ja.getKaakao());
		KaakaonMr.setFont(new Font("Arial", Font.PLAIN, 12));
		KaakaonMr.setBounds(210, 446, 115, 33);
		contentPane.add(KaakaonMr);

	}
}

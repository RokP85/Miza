/*
	Ime datoteke: 	Miza.java
	Avtor:			Rok Pirh
	Vhodni podatki: /
	Opis: 			Aplikacija z grafičnim uporabniškim vmesnikom 
	Izhodni podatki:Okno grafičnega upor. vmesnika
*/

// Uvozimo pakete za GUI
import javax.swing.*;

// uvozimo paket za delo z dogodki
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

// Deklariramo javni razred
public class Miza extends JFrame implements ActionListener {
	// Deklariramo zasebne lastnosti
	private JPanel povrsina;
	private JButton dodajJButton;
	private JTextField znamkaPolje, alkoholPolje;
	private JTable tabela;
	private PivskaSteklenicaTableModel modelTabele;
	
	// Deklariramo javno statično metodo, ki se izvede ob zagonu programa
	// Vhodni parametri: hodni prametri iz konzole
	// Potek/opis: ustvari novo okno
	// Vrne vrednost: /
	public static void main(String[] args) {
		
		Miza m = new Miza("Miza s pivskimi steklenicami");
		
	}
	
	// Javni konstruktor
	// Vhodni parametri: n - naslov okna
	// Potek/opis: vrne objekt tipa Miza
	// Vrne vrednost: vrne objekt tipa Miza
	public Miza(String n) {
		
		// Kličemo konstruktor nadrazreda
		super(n);
		// Inicializiramo zasebne lastnosti
		povrsina = new JPanel();
		povrsina.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		povrsina.setBackground(UIManager.getColor("ColorChooser.background"));
		dodajJButton = new JButton("Dodaj steklenico");
		dodajJButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		dodajJButton.setBackground(new Color(0, 153, 204));
		dodajJButton.setForeground(UIManager.getColor("ComboBox.disabledBackground"));
		znamkaPolje = new JTextField(32);
		znamkaPolje.setFont(new Font("Tahoma", Font.BOLD, 12));
		znamkaPolje.setToolTipText("Sem vnesete znamko piva");
		alkoholPolje = new JTextField(8);
		modelTabele = new PivskaSteklenicaTableModel();
		tabela = new JTable(modelTabele);
		
		// Površino dodamo na mizo
		getContentPane().add(povrsina);
		
		// Gumbu za dodajanje dodamo action listener; "this" se nanaša na objekt "m"
		dodajJButton.addActionListener(this);
		
		// Dodamo gumb in vnosna polja na površino
		JLabel label = new JLabel("Znamka: ");
		label.setLabelFor(znamkaPolje);
		povrsina.add(label);
		povrsina.add(znamkaPolje);
		JLabel label_1 = new JLabel("Stopnja alkohola: ");
		label_1.setLabelFor(alkoholPolje);
		povrsina.add(label_1);
		povrsina.add(alkoholPolje);
		povrsina.add(dodajJButton);
		povrsina.add(tabela);
		
		// Pokažemo okno
		setVisible(true);		
		// Nastavimo velikost okna
		setSize(800, 600);
		
		// Nastavimo obnašanje križca X, da konča aplikacijo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		System.out.println("Ustvarjam objekt miza");
	}
	
	// Metoda, ki jo predpisuje vmesnik ActionListener
	// Vhodni parametri: dogodek
	// Potek/opis: doda stklenico v tabelo
	// Vrne vrednost: /
	public void actionPerformed(ActionEvent ae) {
		System.out.println("Dodajam steklenico...");
		System.out.println("Znamka je " + znamkaPolje.getText());
		System.out.println("Stopnja alkohola je " + alkoholPolje.getText());
		
		// Ustvarimo lokalni sprememljivki d in flasa
		//double d = Double.parseDouble(alkoholPolje.getText());
		//PivskaSteklenica flasa = new PivskaSteklenica(znamkaPolje.getText(), 500, d);
		
		// Dodamo objekt v seznam
		modelTabele.addPivskaSteklenica(new PivskaSteklenica(znamkaPolje.getText(), 500, Double.parseDouble(alkoholPolje.getText())));
		
	}
	
	
}
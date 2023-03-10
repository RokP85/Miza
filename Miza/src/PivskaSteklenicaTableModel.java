/*
	Ime datoteke: 	PvskaSteklenicaTableModel.java
	Avtor:			Rok Pirh
	
*/

import javax.swing.table.*;

public class PivskaSteklenicaTableModel extends DefaultTableModel {
	
	// konstruktor
	
	public PivskaSteklenicaTableModel() {
		
		// kliče konstruktor nadrazreda
		super();
		
		// V tabelo dodamo stolpce
		addColumn("Znamka");
		addColumn("Stopnja alkohola");
		
		// Dodamo naslovno vrstico
		// Ustavrimo statičen seznam objektov
		Object[] vrstica = new Object[] {"Znamka test", "Stopnja test"};
		// Dodamo vrstico v tabelo
		addRow(vrstica);
	}
	
	
	// Vhodni parametri: ps - Pivska steklenica
	// Potek/opis: MEtoda, ki doda pivsko steklenico na seznam in v tabelo
	// Vrne vrednost: /
	public void addPivskaSteklenica(PivskaSteklenica ps){
		
		// Ustavrimo statičen seznam objektov
		Object[] vrstica = new Object[] {ps.getZnamkaKolicina(), ps.getStopnjaAlkohola()};
		// Dodamo vrstico v tabelo
		addRow(vrstica);
	
	}
}
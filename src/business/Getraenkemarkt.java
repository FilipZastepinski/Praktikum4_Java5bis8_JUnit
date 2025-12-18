package business;

import java.util.ArrayList;

public class Getraenkemarkt {

	// Artikelnummer
	private String artikelnummer;
	// Einkaufs- und Verkaufspreise
	private float einkaufspreis;
	private float verkaufspreis;
	// Ob mit oder ohne Alkohol
	private String mitAlkohol;
	// Arten der Behältnisse
	private ArrayList<String> behaeltnis;
	
	
	// Signatur darf nicht angepasst werden wegen der ArrayList<String> !!!
	public Getraenkemarkt(String artikelnummer, float einkaufspreis, float verkaufspreis, String mitAlkohol,
			String[] behaeltnis) {
		this.artikelnummer = artikelnummer;
		this.einkaufspreis = einkaufspreis;
		this.verkaufspreis = verkaufspreis;
		this.mitAlkohol = mitAlkohol;
		//this.behaeltnis.addAll(getBehaeltnis());
		setBehaeltnisAusStringArray(behaeltnis);
	}

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public float getEinkaufspreis() {
		return einkaufspreis;
	}

	public void setEinkaufspreis(float einkaufspreis) {
		this.einkaufspreis = einkaufspreis;
	}

	public float getVerkaufspreis() {
		return verkaufspreis;
	}

	public void setVerkaufspreis(float verkaufspreis) {
		this.verkaufspreis = verkaufspreis;
	}

	public String getMitAlkohol() {
		return mitAlkohol;
	}

	public void setMitAlkohol(String mitAlkohol) {
		this.mitAlkohol = mitAlkohol;
	}
	
	// Anpassung ArrayList
	public ArrayList<String> getBehaeltnis() {
		return behaeltnis;
	}
	
	// Anpassung ArrayList
	public void setBehaeltnis(ArrayList<String> behaeltnis) {
		this.behaeltnis = behaeltnis;
	}
	
	// Methode, welche aus einem String-Array eine ArrayList<String>() erstellt und das Attribut behaeltnis belegt
	private void setBehaeltnisAusStringArray(String [] behaeltnis) {
		this.behaeltnis = new ArrayList<String>();
		for(int i = 0; i < behaeltnis.length; i++) {
			//Erg�nzen
			this.behaeltnis.add(i, behaeltnis[i]);
			
		}
	}
	
	// F�r ArrayList angepasst
	public String getBehaeltnisAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for (i = 0; i < this.getBehaeltnis().size() - 1; i++) {
								// kein this.getBehaeltnis()[i] !
			ergebnis = ergebnis + this.getBehaeltnis().get(i) + trenner;
		}				// Auf indize this.getBehaeltnis.get(i) zugreifen wegen ArrayList
		return ergebnis + this.getBehaeltnis().get(i);
	}

	
	public String gibBehaeltnisZurueck(char trenner) {
		return this.getArtikelnummer() + trenner + this.getEinkaufspreis() + trenner + this.getVerkaufspreis() + trenner
				+ this.getMitAlkohol() + trenner + "\n" + this.getBehaeltnisAlsString(trenner) + "\n";
	}
}
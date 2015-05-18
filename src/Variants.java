import java.util.ArrayList;


public class Variants {
	//mainîgie
	public int numurs;
	public int biletesNr;
	public String iegadesAdrese;
	public int uzminetoSkaitluSkaits = 0;
	public ArrayList<Integer> skaitli = new ArrayList<Integer>();
	public int[] izveletieSkaitli = new int [5];
	
	
	//kontruktori
	public Variants(int numurs, int biletesNr, String iegadesAdrese,
			int uzminetoSKaitluSkaits, ArrayList<Integer> skaitli, int[] izveletieSkaitli) {
		super();
		this.numurs = numurs;
		this.biletesNr = biletesNr;
		this.iegadesAdrese = iegadesAdrese;
		this.uzminetoSkaitluSkaits = uzminetoSKaitluSkaits;
		this.skaitli = skaitli;
		this.izveletieSkaitli = izveletieSkaitli;
	}
	
	public Variants(){
		
	}
	
	//set & get
	public int getNumurs() {
		return numurs;
	}

	public void setNumurs(int numurs) {
		this.numurs = numurs;
	}

	public int getBiletesNr() {
		return biletesNr;
	}

	public void setBiletesNr(int biletesNr) {
		this.biletesNr = biletesNr;
	}

	public String getIegadesAdrese() {
		return iegadesAdrese;
	}

	public void setIegadesAdrese(String iegadesAdrese) {
		this.iegadesAdrese = iegadesAdrese;
	}

	public int getUzminetoSkaitluSkaits() {
		return uzminetoSkaitluSkaits;
	}

	public void setUzminetoSkaitluSkaits(int uzminetoSkaitluSkaits) {
		this.uzminetoSkaitluSkaits = uzminetoSkaitluSkaits;
	}

	public ArrayList<Integer> getSkaitli() {
		return skaitli;
	}

	public void setSkaitli(ArrayList<Integer> skaitli) {
		this.skaitli = skaitli;
	}
	
	public void rekinatSkaitlus(int[] skaitli){
		for (int i=0; i<5; i++){
			for (int j=0+i; j<5; j++){
				if (skaitli[i]==izveletieSkaitli[j]){
					uzminetoSkaitluSkaits++;
				}
			}
		}
	}
	
	
	
	
}

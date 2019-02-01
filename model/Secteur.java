package model;
import java.util.Random;

public class Secteur {

	public int proie = 0;
	public int rassacie = 0;
	public int affame = 0;

	public Secteur(int p, int a, int r) {

		proie = p;
		rassacie = r;
		affame = a;

	}

	public Secteur() {

		Random r = new Random();

		proie = r.nextInt(4);
		rassacie = r.nextInt(4);
		affame = r.nextInt(4);

	}

	public void next() {

	}
	

	@Override
	public String toString() {
		return "[" + affame + "," + proie  + "," + rassacie + "]";
	}

	public int getProie() {
		return proie;
	}

	public void setProie(int proie) {
		this.proie = proie;
	}

	public int getRassacie() {
		return rassacie;
	}

	public void setRassacie(int rassacie) {
		this.rassacie = rassacie;
	}

	public int getAffame() {
		return affame;
	}

	public void setAffame(int affame) {
		this.affame = affame;
	}

}

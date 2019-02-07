package model;
import java.util.Observable;
import java.util.Random;

public class Secteur extends Observable{

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
		int nb_max = 5;
		proie = r.nextInt(nb_max);
		rassacie = r.nextInt(nb_max);
		affame = r.nextInt(nb_max);

	}

	public void next() {

		this.setChanged();
		this.notifyObservers();
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

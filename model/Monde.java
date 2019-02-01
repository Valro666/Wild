package model;

import java.util.Arrays;

public class Monde {

	Secteur[][] secteur = null;
	int width;
	int heigth;

	public Monde(int a, int b, int option) {

		width = a;
		heigth = b;
		secteur = new Secteur[a][b];

		switch (option) {
		default:
		case 0:
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					secteur[i][j] = new Secteur();
				}
			}
			break;
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < secteur.length; i++) {
			for (int j = 0; j < secteur[i].length; j++) {
				// secteur[i][j] = new Secteur();
				s = s + secteur[i][j] + " ";
			}
			s = s + "\n";
		}
		return s;
	}

	public Secteur[][] getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur[][] secteur) {
		this.secteur = secteur;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

}

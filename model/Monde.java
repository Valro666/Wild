package model;

import java.util.Observable;

public class Monde extends Observable {

	Secteur[][] secteur = null;
	int width;
	int heigth;
	public MondeFantome mf;

	public Monde(int a, int b, int option) {

		width = a;
		heigth = b;
		secteur = new Secteur[a][b];
		mf = new MondeFantome(a,b);

		switch (option) {
		default:
		case 0:
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					secteur[i][j] = new Secteur(j, i, this);
				}
			}
			break;
		}
	}


	public void nouveau(int a, int b) {
		width = a;
		heigth = b;
		secteur = new Secteur[a][b];

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				secteur[i][j] = new Secteur(i,j,this);
			}
		}

	}


	public void pred_repro_global()
	{
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.heigth; j++) {
				secteur[i][j].predation_reproduction();
			}
		}
	}

	public void deplacementsSecteur_global()
	{
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.heigth; j++) {
				secteur[i][j].choisirDirectionsSecteur();
				secteur[i][j].deplacementsSecteur();
			}
		}
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.heigth; j++) {
				secteur[i][j].vie[0]=mf.secteur[i][j][0];
				secteur[i][j].vie[1]=mf.secteur[i][j][1];
				secteur[i][j].vie[2]=mf.secteur[i][j][2];
			}
		}
		mf.viderMondeFantome();
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

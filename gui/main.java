package gui;

import model.Monde;
import model.Surcouche;

public class main {
	public static void main(String[] a) {
		Monde world = new Monde(30, 30, 0);
		Surcouche sur = new Surcouche(world);
		// System.out.println(world);
		new Fenetre();//sur
	}
}

package gui;

import model.Monde;

public class main {
	public static void main(String[] a) {
		Monde world = new Monde(10, 10, 0);
		System.out.println(world);
		new Fenetre(world);
	}
}

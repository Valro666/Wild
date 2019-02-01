package gui;

import javax.swing.JFrame;

import model.Monde;
import model.Secteur;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Monde world = null;
	Carte carte = null;

	public Fenetre(Monde world) {
		this.world = world;
		carte = new Carte(world);
		this.setName("Jeu de la vie / Valro");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.add(carte);
	}

}

package gui;

import javax.swing.JFrame;

import model.Monde;
import model.Secteur;
import model.Surcouche;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Surcouche sur = null;
	Monde world = null;
	Carte carte = null;

	public Fenetre(Surcouche s) {
		sur = s;
		this.world = sur.getWorld();
		carte = new Carte(sur);
		this.setName("Wild Groupe C");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Option.getInstance().wfen, Option.getInstance().hfen);
		this.add(carte);
	}

}

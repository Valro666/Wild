package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

import model.Secteur;

public class Zone extends JButton {

	Secteur s;

	public Zone(String string, Secteur s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		this.setText(string);

		this.setBorderPainted(false);
		// c = new Color(255 - (r * coul), 255 - (p * coul), 255 - (a *
		// coul));
		// Color c = new Color((a * coul), (p * coul), (r * coul));
		// c.darker();

		// Color c = new Color(255 - (a * coul), 255 - (p * coul), 255 -
		// (r * coul));
		// c = c.darker();
		// this.setBackground(Color.gray);
		this.setOpaque(false);
	}

	public void paint(Graphics g) {
		int v = 255 / 3;

		int ox = 0;
		int oy = 0;
		int larg = this.getWidth() / 3;
		int haut = this.getHeight() / 3;
		// bg
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// affame
		g.setColor(new Color(255, 0, 0));
		g.fillRect(ox, oy, larg, haut * s.affame);

		// proie
		g.setColor(new Color(0, 255, 0));
		g.fillRect(ox + larg, 0, larg, haut * s.proie);

		// rassacie
		g.setColor(new Color(0, 0, 255));
		g.fillRect(ox + larg + larg, 0, larg, haut * s.rassacie);
		// texte
		g.setColor(Color.BLACK);
		g.drawString(s.toString(), this.getWidth() / 2, this.getHeight() / 2);
		// box
		g.setColor(Color.PINK);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());
	}

}

package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import model.Secteur;

public class Zone extends JButton implements Observer {

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
	
	

	public Secteur getS() {
		return s;
	}



	public void setS(Secteur s) {
		this.s = s;
		
	}



	public void paint(Graphics g) {
		// this.setSize(Option.getInstance().wfen/10,
		// Option.getInstance().hfen/10);

		int v = 255 / 4;

		int ox = 0;
		int oy = 0;
		int larg = this.getWidth() / 3;
		int haut = 1 + this.getHeight() / 4;
		// Font f = new Font("mini", 1, 12);
		// g.setFont(f);
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
		g.drawString(s.toString(), 0, this.getHeight() / 2);

		// box
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		repaint();
	}

}

package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Monde;

public class Carte extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton[][] tim = null;

	@SuppressWarnings("unused")
	public Carte(Monde world) {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(world.getWidth(), world.getHeigth()));
		tim = new JButton[world.getWidth()][world.getHeigth()];
		for (int i = 0; i < world.getWidth(); i++) {
			for (int j = 0; j < world.getHeigth(); j++) {

				int coul = 255 / 3;
				int a = 0;
				int r = 0;
				int p = 0;
				Color c = new Color(255 - (a * coul), 255 - (p * coul), 255 - (r * coul));

				if (true) {
					a = world.getSecteur()[i][j].affame;
					r = world.getSecteur()[i][j].rassacie;
					p = world.getSecteur()[i][j].proie;
					if ((a == 3 && r == 3) && r == 3) {
						c = Color.BLACK;
					} else if ((a == 0 && r == 0) && r == 0) {
						c = Color.WHITE;
					} else {
						c = new Color(255 - (a * coul), 255 - (p * coul), 255 - (r * coul));
					}
				} else {
					a = 3;
					r = 3;
					p = 3;
				}
				JButton t = tim[i][j];

				t = new JButton(world.getSecteur()[i][j] + "");
				t.setBorderPainted(false);

				// c = new Color(255 - (r * coul), 255 - (p * coul), 255 - (a * coul));
				c = new Color((a * coul), (p * coul), (r * coul));
				c.darker();

				// Color c = new Color(255 - (a * coul), 255 - (p * coul), 255 - (r * coul));
				// c = c.darker();
				t.setBackground(c);
				// t.setForeground(Color.pink);
				this.add(t);
			}
		}
	}

}

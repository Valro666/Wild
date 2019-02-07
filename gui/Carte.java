package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Secteur;
import model.Surcouche;

public class Carte extends JPanel {

	/**
	 * 
	 */
	Surcouche sur;
	private static final long serialVersionUID = 1L;
	public Zone[][] tim = null;

	@SuppressWarnings("unused")
	public Carte(Surcouche s) {
		// TODO Auto-generated constructor stub
		sur = s;

		GridLayout gl = new GridLayout(sur.getWidth(), sur.getHeigth());
		// gl.setHgap(0);
		// gl.setVgap(10);
		// gl.
		this.setLayout(gl);
		tim = new Zone[sur.getWidth()][sur.getHeigth()];
		for (int i = 0; i < sur.getWidth(); i++) {
			for (int j = 0; j < sur.getHeigth(); j++) {

				int coul = 255 / 4;
				int a = 0;
				int r = 0;
				int p = 0;
				Color c = new Color(255 - (a * coul), 255 - (p * coul), 255 - (r * coul));
				Secteur tmp = sur.getSecteur()[i][j];
				if (true) {

					a = tmp.vie[0];
					r = tmp.vie[2];
					p = tmp.vie[1];
					if ((a == 4 && r == 4) && r == 4) {
						c = Color.BLACK;
					} else if ((a == 0 && r == 0) && r == 0) {
						c = Color.WHITE;
					} else {
						c = new Color(255 - (a * coul), 255 - (p * coul), 255 - (r * coul));
					}
				} else {
					a = 4;
					r = 4;
					p = 4;
				}
				Zone t = tim[i][j];

				t = new Zone(sur.getSecteur()[i][j] + "", tmp);

				// t.setForeground(Color.pink);
				action ac = new action(t, tmp);
				t.addActionListener(ac);
				this.add(t);
				repaint();
			}
		}
	}

	public class action implements ActionListener {
		JButton tin = null;
		Secteur s = null;

		public action(JButton jb, Secteur s) {
			tin = jb;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println(tin.getText());
			sur.getWorld().pred_repro_global();
			sur.getWorld().deplacementsSecteur_global();
			repaint();
		}	

		public void paint(Graphics g) {
			int v = 255 / 4;
			// g.setColor(new Color(s.getAffame() * v, 0, 0));
			// g.drawRect(0, 0, 25, 25);
		}

	}

}

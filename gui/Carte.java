package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Secteur;
import model.Surcouche;

public class Carte extends JPanel implements Observer {

	/**
	 * 
	 */
	Surcouche sur;
	private static final long serialVersionUID = 1L;
	public Zone[][] tim = null;

	JPanel sup;

	public Carte(Surcouche s, JPanel pano) {
		sup = pano;
		init(s);
		this.setPreferredSize(sup.getSize());
	}

	@SuppressWarnings("unused")
	public Carte(Surcouche s) {
		// TODO Auto-generated constructor stub
		init(s);
		sur.addObserver(this);
	}

	@SuppressWarnings("unused")
	public void init(Surcouche s) {
		sur = s;

		s.addObserver(this);

		GridLayout gl = new GridLayout(sur.getWidth(), sur.getHeigth());
		// gl.setHgap(0);
		// gl.setVgap(10);
		// gl.
		this.setLayout(gl);
		this.setBackground(Color.LIGHT_GRAY);
		// gl.layoutContainer(this.);
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

				tim[i][j] = new Zone(sur.getSecteur()[i][j] + "", tmp);
				Zone t = tim[i][j];
				// t.setForeground(Color.pink);
				action ac = new action(t, tmp);
				t.addActionListener(ac);
				// t.setPreferredSize(getSize());
				// t.setSize(this.getWidth() / sur.getWidth(), this.getHeight()
				// /
				// sur.getHeigth());
				// t.setPreferredSize(new Dimension(this.getWidth() /
				// sur.getWidth(),
				// this.getHeight() / sur.getHeigth()));

				// t.setSize(new Dimension(10, 10));
				this.add(t);
				// repaint();
			}
		}
	}

	public class action implements ActionListener {
		JButton tin = null;
		Secteur sec = null;

		public action(JButton jb, Secteur ss) {
			tin = jb;
			sec = ss;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println(tin.getText());
			sur.getWorld().pred_repro_global();
			sur.getWorld().deplacementsSecteur_global();
			repaint();
		}	

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// System.out.println("maj");
		this.removeAll();
		init(sur);
		// for (int x = 0; x < sur.getSecteur().length; x++) {
		// for (int y = 0; y < sur.getSecteur()[x].length; y++) {
		//
		// tim[x][y].setS(sur.getSecteur()[x][y]);
		// }
		// }
	}

}

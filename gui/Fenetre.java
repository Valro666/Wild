package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import model.Monde;
import model.Secteur;
import model.Surcouche;

public class Fenetre extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Surcouche sur = null;
	Monde world = null;
	Carte carte = null;
	JButton reload_button = null;
	JButton play_button = null;
	JButton stop_button = null;
	JButton next_button = null;
	JButton apply_length = null;
	// Container mainContainer= null;
	JPanel mainContainer = null;
	JLabel tp = null;
	JLabel taille = null;
	JLabel labelIn = null;
	JCheckBox show = null;
	JTextField x_grille = null;
	JTextField y_grille = null;
	JPanel topPanel = null;
	JPanel middlePanel = null;
	JPanel btmPanel = null;
	JPanel gridPanel = null;
	JPanel cartePnl = null;
	int sizeX = 20;
	int sizeY = 20;

	public Fenetre() { // Surcouche s
		world = new Monde(sizeX, sizeY, 0);
		sur = new Surcouche(world);
		// sur = s;
		this.world = sur.getWorld();
		sur.addObserver(this);
		// carte = new Carte(sur);
		this.setName("Wild Groupe C");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.DARK_GRAY);
		this.setSize(Option.getInstance().wfen + 50, Option.getInstance().hfen + 50);
		// this.setSize(700,300);
		// this.add(carte);

		// graphics

		reload_button = new JButton();

		try {
			Image img = ImageIO.read(getClass().getResource("images/001-refresh.png"));
			Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			reload_button.setIcon((Icon) new ImageIcon(newimg));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		play_button = new JButton();// play
		try {
			Image img = ImageIO.read(getClass().getResource("images/icons8-next-48.png"));
			Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			play_button.setIcon((Icon) new ImageIcon(newimg));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		stop_button = new JButton();// stop
		try {
			Image img = ImageIO.read(getClass().getResource("images/icons8-stop-96.png"));
			Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			stop_button.setIcon((Icon) new ImageIcon(newimg));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		next_button = new JButton();// suiavnt
		try {
			Image img = ImageIO.read(getClass().getResource("images/icons8-fast-forward-48.png"));
			Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			next_button.setIcon((Icon) new ImageIcon(newimg));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		apply_length = new JButton(); // Appliquer
		try {
			Image img = ImageIO.read(getClass().getResource("images/icons8-ok-filled-50.png"));
			Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			apply_length.setIcon((Icon) new ImageIcon(newimg));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		tp = new JLabel("AC Predateurs");
		tp.setForeground(Color.WHITE);
		taille = new JLabel("Taille");
		taille.setForeground(Color.WHITE);
		labelIn = new JLabel("X");
		labelIn.setForeground(Color.WHITE);

		show = new JCheckBox("Grille", null, true);
		show.setBackground(Color.DARK_GRAY);
		show.setForeground(Color.WHITE);

		x_grille = new JTextField("10", 5);
		y_grille = new JTextField("10", 5);

		reload_button.setContentAreaFilled(false);
		reload_button.setFocusPainted(false);
		reload_button.setForeground(Color.WHITE);

		play_button.setContentAreaFilled(false);
		play_button.setFocusPainted(false);
		play_button.setForeground(Color.WHITE);

		stop_button.setContentAreaFilled(false);
		stop_button.setFocusPainted(false);
		stop_button.setForeground(Color.WHITE);

		next_button.setContentAreaFilled(false);
		next_button.setFocusPainted(false);
		next_button.setForeground(Color.WHITE);

		apply_length.setContentAreaFilled(false);
		apply_length.setFocusPainted(false);
		apply_length.setForeground(Color.WHITE);

		mainContainer = new JPanel();
		mainContainer.setBackground(Color.DARK_GRAY);
		BoxLayout boxLayoutManager = new BoxLayout(mainContainer, BoxLayout.Y_AXIS);
		mainContainer.setLayout(boxLayoutManager);

		// Panel top
		topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		topPanel.setLayout(new FlowLayout());
		topPanel.add(tp);
		mainContainer.add(topPanel);// , BorderLayout.NORTH);

		cartePnl = new JPanel();

		// cartePnl.setSize(Option.getInstance().wfen, Option.getInstance().hfen);
		cartePnl.setLayout(new FlowLayout());
		cartePnl.setBackground(Color.DARK_GRAY);

		carte = new Carte(sur);
		// carte = new Carte(sur, cartePnl);
		// cartePnl.add(carte);
		// carte.setSize(Option.getInstance().wfen, Option.getInstance().hfen);
		// cartePnl.setSize(Option.getInstance().wfen, Option.getInstance().hfen);
		// cartePnl.setPreferredSize(cartePnl.getPreferredSize());
		// mainContainer.add(cartePnl);// ,BorderLayout.CENTER);
		carte.setPreferredSize(new Dimension(600,600));
		mainContainer.add(carte);

		// Panel buttom

		btmPanel = new JPanel();
		btmPanel.setBackground(Color.DARK_GRAY);
		btmPanel.setLayout(new FlowLayout());

		btmPanel.add(show);
		btmPanel.add(reload_button);
		btmPanel.add(play_button);
		btmPanel.add(stop_button);
		btmPanel.add(next_button);

		btmPanel.add(taille);
		btmPanel.add(x_grille);
		btmPanel.add(labelIn);
		btmPanel.add(y_grille);
		btmPanel.add(apply_length);
		mainContainer.add(btmPanel);// , BorderLayout.SOUTH);

		this.add(mainContainer);
		this.setPreferredSize(new Dimension(cartePnl.getWidth(), cartePnl.getHeight() + 100));
		this.setVisible(true);

		//
		// Events
		reload_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				// world = new Monde(sizeX, sizeY, 0);
				// sur = new Surcouche(world);
				// sur = s;
				// world = sur.getWorld();
				// carte.removeAll();
				// carte.validate();
				// carte = new Carte(sur);

				// cartePnl.removeAll();
				// cartePnl.validate();
				// cartePnl.add(carte);
				// cartePnl.revalidate();
				// cartePnl.repaint();

				// cartePnl.add(carte);
				// carte.revalidate();
//				carte.repaint();
				System.out.println("1");
			}
		});

		show.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cartePnl.setVisible(true);
				} else {
					cartePnl.setVisible(false);
				}

			}
		});

		apply_length.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				sizeX = Integer.parseInt(x_grille.getText());
				sizeY = Integer.parseInt(y_grille.getText());
				// world = new Monde(sizeX, sizeY, 0);
				// sur = new Surcouche(world);
				// world = sur.getWorld();
				// carte = new Carte(sur);
				sur.nouveau(sizeX, sizeY);
				// cartePnl.removeAll();
				// cartePnl.validate();
				// cartePnl.add(carte);
				// cartePnl.revalidate();
				// cartePnl.repaint();
				// System.out.println("reload");
				// ;
				// System.out.println(sur.getSecteur().length + "x" +
				// sur.getSecteur()[0].length);
			}
		});

		play_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		stop_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		next_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		carte.update(arg0, arg1);
		carte.setPreferredSize(new Dimension((int)(this.getWidth()*0.80),(int)(this.getHeight()*0.80)));
		this.revalidate();
		this.repaint();
	}

}

package model;

import java.util.Observable;

public class Surcouche extends Observable {

	Monde world = null;

	public Surcouche(Monde w) {
		world = w;
	}

	public Monde getWorld() {
		return world;
	}

	public void setWorld(Monde world) {
		this.world = world;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return world.getWidth();
		// return 0;
	}

	public int getHeigth() {
		return world.getHeigth();
		// TODO Auto-generated method stub
		// return 0;
	}

	public Secteur[][] getSecteur() {
		// TODO Auto-generated method stub
		return world.getSecteur();
	}

	public void nouveau(int x, int y) {
		// world = new Monde(x, y, 0);
		world.nouveau(x, y);
		this.setChanged();
		this.notifyObservers();
	}

	// public Secteur getSecteur() {
	// // TODO Auto-generated method stub
	// return world.getSecteur();
	// }

}

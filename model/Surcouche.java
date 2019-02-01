package model;

public class Surcouche {

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
	
//	public Secteur getSecteur() {
//		// TODO Auto-generated method stub
//		return world.getSecteur();
//	}

}

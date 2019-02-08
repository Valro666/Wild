package gui;

public final class Option {

	private static volatile Option instance = null;

	private String xxx;
	int wfen = 800;
	int hfen = 600;
	
	int wpan = 500;
	int hpan = 500;

	/**
	 * Constructeur de l'objet.
	 */
	private Option() {
		super();
	}

	/**
	 * Méthode permettant de renvoyer une instance de la classe Option
	 * 
	 * @return Retourne l'instance du Option.
	 */
	public final static Option getInstance() {
		if (Option.instance == null) {
			synchronized (Option.class) {
				if (Option.instance == null) {
					Option.instance = new Option();
				}
			}
		}
		return Option.instance;
	}

}

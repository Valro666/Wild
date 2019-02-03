package gui;

public final class Option {

	private static volatile Option instance = null;

	private String xxx;
	int wfen = 500;
	int hfen = 500;

	/**
	 * Constructeur de l'objet.
	 */
	private Option() {
		super();
	}

	/**
	 * M�thode permettant de renvoyer une instance de la classe Option
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

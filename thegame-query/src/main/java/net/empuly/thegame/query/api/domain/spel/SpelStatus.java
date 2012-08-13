package net.empuly.thegame.query.api.domain.spel;

public enum SpelStatus {

	GESTART("gestart"), BEEINDIGD("beëindigd");

	private String schermtekst;

	private SpelStatus(final String schermtekst) {
		this.schermtekst = schermtekst;
	}

	public String getSchermTekst() {
		return schermtekst;
	}

}

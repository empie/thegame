package net.empuly.thegame.query.api.domain.spel;

public enum SpelStatus {

	GESTART(1,"gestart"), BEEINDIGD(2,"beëindigd");

	private String schermtekst;
	private int code;

	private SpelStatus(final int code,final String schermtekst) {
		this.code = code;
		this.schermtekst = schermtekst;
	}

	public String getSchermTekst() {
		return schermtekst;
	}
	
	public int getCode() {
		return code;
	}

}

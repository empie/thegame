package net.empuly.thegame.query.api.domain.spel;

public enum SpelStatus {

	GESTART(1, "gestart"), BEEINDIGD(2, "beëindigd");

	public static SpelStatus fromCode(final int statusCode) {
		for (final SpelStatus spelStatus : SpelStatus.values()) {
			if (spelStatus.getCode() == statusCode) {
				return spelStatus;
			}
		}

		throw new IllegalArgumentException("Geen spelstatus gevonden met code " + statusCode);

	}

	private String schermtekst;

	private int code;

	private SpelStatus(final int code, final String schermtekst) {
		this.code = code;
		this.schermtekst = schermtekst;
	}

	public int getCode() {
		return code;
	}

	public String getSchermTekst() {
		return schermtekst;
	}

}

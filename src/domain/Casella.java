
public class Casella {

	private TipusCasella tipusCasella;
	private int value;
	
	public void setTipus(TipusCasella tipusCasella) {
		this.tipusCasella = tipusCasella;		
	}

	public void setTipus(TipusCasella tipusCasella, int value) {
		this.tipusCasella = tipusCasella;
		this.value = value;
	}
	
	public TipusCasella getTipusCasella() {
		return tipusCasella;
	}
	
	public int getValue() throws NotValueTypeException{
		if (!tipusCasella.equals(TipusCasella.VALOR)) throw new NotValueTypeException("S'intenta accedir al value d'una casella que no es de tipus 'VALOR'");
		return value;
	}
}

package main.domain.com.hidato;

public class PathStrategyQuadratCostats implements PathStrategy {

	@Override
	public boolean posicioValida(int i, int j, int r, int c) {
		return (Math.abs(i + j) == 1);
	}

}

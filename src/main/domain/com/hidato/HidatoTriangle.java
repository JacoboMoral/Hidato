package main.domain.com.hidato;

public class HidatoTriangle extends Hidato {

    public HidatoTriangle(int[][] matriu) {
        super(TipusAdjacencia.COSTATS, matriu);
        al = new Algorismes(this);
        dificultat = al.obtenirDificultat();
    }

    public HidatoTriangle() {
        super(TipusAdjacencia.COSTATS);
        al = new Algorismes(this);
    }

    @Override
    public TipusCella getTipusCella() {
        return TipusCella.TRIANGLE;
    }

    @Override
    public boolean posicioValida(int i, int j, int r, int c) {
        if (tipusAdjacencia == TipusAdjacencia.COSTATS) {
            return (((Math.abs(j) == 1) && i == 0) || ((i == -1) && (j == 0) && diferentParitat(r, c)) || ((i == 1) && (j == 0) && !diferentParitat(r, c)));
        }
        return false;
    }

    private boolean diferentParitat(int i, int j) {
        return (i % 2 != j % 2);
    }

}

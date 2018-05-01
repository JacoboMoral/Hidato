package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.domain.com.hidato.Algorismes;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;

class TestAlgorismes {
	
	Algorismes algorismes;
	Hidato hidato;
	int[][] matriuQuadratCostats = new int[][] {
		{7,0,0,0,0,24,0,26,0,0,29,0,0,0,0},
		{0,0,10,0,0,23,42,41,0,0,38,0,0,0,0},
		{15,0,0,0,1,22,0,0,0,0,0,0,49,0,51},
		{0,0,18,0,0,0,0,0,0,0,0,0,0,53,0},
		{0,66,0,0,0,0,0,0,0,0,0,0,0,0,83},
		{0,0,0,0,0,73,74,75,90,0,88,87,86,0,0},
		{0,0,97,96,0,0,0,0,0,0,0,112,113,0,0},
		{0,0,0,0,0,0,0,0,0,109,0,0,0,117,0},
		{0,130,129,0,127,0,125,124,123,122,121,0,145,0,0},
		{0,0,134,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,162,0,0,159,0,0,0,0,0,0,152,151,0,179},
		{0,0,0,0,0,0,0,0,0,173,0,0,0,0,0},
		{0,0,0,192,191,190,189,188,0,0,185,0,0,0,0},
		{196,0,198,0,0,0,0,0,204,205,206,0,0,0,0},
		{225,0,0,0,0,220,219,0,0,0,0,214,0,0,0}
	};
	int[][] matriuQuadratCostatsFalse = new int[][] {
	      {0,19,0,16,0,0,10,0,143,144,0,214,213,0,0 },
	      { 21,23,0,0,15,0,12,142,0,0,216,0,207,210,0},
	      { 0,0,0,0,8,0,6,0,0,219,148,205,0,0,202 },
	      { 0,0,111,0,0,0,1,3,0,0,0,0,204,0,0 },
	      { 0,0,112,0,0,99,4,0,0,138,221,0,0,151,0 },
	      { 30,105,0,0,0,117,119,0,132,0,154,0,225,196,0 },
	      { 0,31,0,103,102,120,0,131,134,133,0,0,0,195,0 },
	      { 34,32,92,0,0,87,0,129,0,0,188,0,160,0,0 },
	      { 0,91,0,0,0,0,0,124,128,0,186,189,191,192,0 },
	      { 0,0,0,58,0,83,0,123,125,127,0,184,0,0,163 },
	      { 0,0,59,62,0,84,0,81,0,71,0,0,0,0,164 },
	      { 38,41,0,63,0,0,52,0,0,0,73,171,0,182,165 },
	      { 45,46,0,0,49,0,51,0,69,0,174,175,0,180,179 },
	      { 0,0,47,0,0,50,0,0,0,0,75,0,176,177,0 },
	};
	int[][] matriuQuadratCostatsFalseNoUltim = new int[][] {
		{7,0,0,0,0,24,0,26,0,0,29,0,0,0,0},
		{0,0,10,0,0,23,42,41,0,0,38,0,0,0,0},
		{15,0,0,0,1,22,0,0,0,0,0,0,49,0,51},
		{0,0,18,0,0,0,0,0,0,0,0,0,0,53,0},
		{0,66,0,0,0,0,0,0,0,0,0,0,0,0,83},
		{0,0,0,0,0,73,74,75,90,0,88,87,86,0,0},
		{0,0,97,96,0,0,0,0,0,0,0,112,113,0,0},
		{0,0,0,0,0,0,0,0,0,109,0,0,0,117,0},
		{0,130,129,0,127,0,125,124,123,122,121,0,145,0,0},
		{0,0,134,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,162,0,0,159,0,0,0,0,0,0,152,151,0,179},
		{0,0,0,0,0,0,0,0,0,173,0,0,0,0,0},
		{0,0,0,192,191,190,189,188,0,0,185,0,0,0,0},
		{196,0,198,0,0,0,0,0,204,205,206,0,0,0,0},
		{0,0,0,0,0,220,219,0,0,0,0,214,0,0,0}
	};
	int[][] matriuQuadratCostatsFalseNoPrimer = new int[][] {
		{7,0,0,0,0,24,0,26,0,0,29,0,0,0,0},
		{0,0,10,0,0,23,42,41,0,0,38,0,0,0,0},
		{15,0,0,0,0,22,0,0,0,0,0,0,49,0,51},
		{0,0,18,0,0,0,0,0,0,0,0,0,0,53,0},
		{0,66,0,0,0,0,0,0,0,0,0,0,0,0,83},
		{0,0,0,0,0,73,74,75,90,0,88,87,86,0,0},
		{0,0,97,96,0,0,0,0,0,0,0,112,113,0,0},
		{0,0,0,0,0,0,0,0,0,109,0,0,0,117,0},
		{0,130,129,0,127,0,125,124,123,122,121,0,145,0,0},
		{0,0,134,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,162,0,0,159,0,0,0,0,0,0,152,151,0,179},
		{0,0,0,0,0,0,0,0,0,173,0,0,0,0,0},
		{0,0,0,192,191,190,189,188,0,0,185,0,0,0,0},
		{196,0,198,0,0,0,0,0,204,205,206,0,0,0,0},
		{225,0,0,0,0,220,219,0,0,0,0,214,0,0,0}
	};
	int[][] matriuQuadratCostatsSolucio = new int[][] {
		{7, 6, 5, 4, 3,24,25,26,27,28,29,30,31,32,33},
		{8, 9,10,11, 2,23,42,41,40,39,38,37,36,35,34},
		{15,14,13,12, 1,22,43,44,45,46,47,48,49,50,51},
		{16,17,18,19,20,21,60,59,58,57,56,55,54,53,52},
		{67,66,65,64,63,62,61,76,77,78,79,80,81,82,83},
		{68,69,70,71,72,73,74,75,90,89,88,87,86,85,84},
		{99,98,97,96,95,94,93,92,91,110,111,112,113,114,115},
		{100,101,102,103,104,105,106,107,108,109,120,119,118,117,116},
		{131,130,129,128,127,126,125,124,123,122,121,144,145,146,147},
		{132,133,134,135,136,137,138,139,140,141,142,143,150,149,148},
		{163,162,161,160,159,158,157,156,155,154,153,152,151,178,179},
		{164,165,166,167,168,169,170,171,172,173,174,175,176,177,180},
		{195,194,193,192,191,190,189,188,187,186,185,184,183,182,181},
		{196,197,198,199,200,201,202,203,204,205,206,207,208,209,210},
		{225,224,223,222,221,220,219,218,217,216,215,214,213,212,211}
	};

	int[][] matriuQuadratAmbdos = new int[][] {
	      { -2,-2,-2,-2,-2,-2,0,1,-2,-2 },
	      { 0,0,-2,-2,4,0,0,38,0,35},
	      { 73,0,75,0,0,41,0,0,34,0 },
	      { 0,78,0,0,6,0,8,0,31,0 },
	      { 0,0,68,0,0,0,44,0,0,32 },
	      { 80,50,64,0,0,0,11,21,0,0 },
	      { 0,51,49,0,47,0,0,20,23,0 },
	      { 53,0,0,48,14,16,18,0,27,0 },
	      { 55,0,0,58,0,0,-2,-2,25,0 },
	      { -2,-2,57,59,-2,-2,-2,-2,-2,-2 }
	    };
    int[][] matriuQuadratAmbdosFalse = new int[][] {
    	  { -2,-2,-2,-2,-2,-2,0,1,-2,-2 },
	      { 0,0,-2,-2,4,0,0,38,0,35},
	      { 73,0,75,0,0,41,0,0,34,0 },
	      { 0,78,0,0,6,0,8,0,31,0 },
	      { 0,0,68,0,0,0,44,0,0,32 },
	      { 80,50,64,0,0,0,11,21,0,0 },
	      { 0,51,49,0,47,0,0,20,23,0 },
	      { 53,0,0,48,14,16,18,0,28,0 },
	      { 55,0,0,58,0,0,-2,-2,25,0 },
	      { -2,-2,57,59,-2,-2,-2,-2,-2,-2 }
	    };
    int[][] matriuQuadratAmbdosFalseNoUltim = new int[][] {
    	  { -2,-2,-2,-2,-2,-2,0,1,-2,-2 },
	      { 0,0,-2,-2,4,0,0,38,0,35},
	      { 73,0,75,0,0,41,0,0,34,0 },
	      { 0,78,0,0,6,0,8,0,31,0 },
	      { 0,0,68,0,0,0,44,0,0,32 },
	      { 0,50,64,0,0,0,11,21,0,0 },
	      { 0,51,49,0,47,0,0,20,23,0 },
	      { 53,0,0,48,14,16,18,0,27,0 },
	      { 55,0,0,58,0,0,-2,-2,25,0 },
	      { -2,-2,57,59,-2,-2,-2,-2,-2,-2 }
	    };
    int[][] matriuQuadratAmbdosFalseNoPrimer = new int[][] {
	      { -2,-2,-2,-2,-2,-2,0,0,-2,-2 },
	      { 0,0,-2,-2,4,0,0,38,0,35},
	      { 73,0,75,0,0,41,0,0,34,0 },
	      { 0,78,0,0,6,0,8,0,31,0 },
	      { 0,0,68,0,0,0,44,0,0,32 },
	      { 80,50,64,0,0,0,11,21,0,0 },
	      { 0,51,49,0,47,0,0,20,23,0 },
	      { 53,0,0,48,14,16,18,0,27,0 },
	      { 55,0,0,58,0,0,-2,-2,25,0 },
	      { -2,-2,57,59,-2,-2,-2,-2,-2,-2 }
	    };
		    
	int[][] matriuTriangleCostats = new int[][] {
		{0,0,0,0,0,0,0,64},
		{56,0,54,0,0,0,0,49},
		{41,42,43,0,45,0,0,0},
		{0,0,38,0,0,0,34,0},
		{25,0,0,0,0,0,0,32},
		{24,0,0,0,0,0,18,17},
		{0,0,0,0,0,14,0,0},
		{0,7,0,0,0,0,2,1}
	};
	int[][] matriuTriangleCostatsFalse = new int[][] {
		{-2,-2,-2,-2,-2,-2,-2,-2},
		{0,0,0,0,0,0,0,64},
		{56,0,54,0,0,0,0,49},
		{41,42,43,0,45,0,0,0},
		{0,0,38,0,0,0,34,0},
		{25,0,0,0,0,0,0,32},
		{24,0,0,0,0,0,18,17},
		{0,0,0,0,0,14,0,0},
		{0,7,0,0,0,0,2,1}
	};
	int[][] matriuTriangleCostatsFalseNoUltim = new int[][] {
		{0,0,0,0,0,0,0,0},
		{56,0,54,0,0,0,0,49},
		{41,42,43,0,45,0,0,0},
		{0,0,38,0,0,0,34,0},
		{25,0,0,0,0,0,0,32},
		{24,0,0,0,0,0,18,17},
		{0,0,0,0,0,14,0,0},
		{0,7,0,0,0,0,2,1}
	};
	int[][] matriuTriangleCostatsFalseNoPrimer = new int[][] {
		{0,0,0,0,0,0,0,64},
		{56,0,54,0,0,0,0,49},
		{41,42,43,0,45,0,0,0},
		{0,0,38,0,0,0,34,0},
		{25,0,0,0,0,0,0,32},
		{24,0,0,0,0,0,18,17},
		{0,0,0,0,0,14,0,0},
		{0,7,0,0,0,0,2,0}
	};
	
	int[][] matriuHexagon = new int[][] {
		{7,6,0,0,3,0,1},
		{8,0,0,11,0,0,0},
		{0,0,19,18,0,0,15},
		{0,0,0,0,26,27,0},
		{0,0,0,32,0,0,29},
		{0,0,0,39,0,0,42},
		{49,0,47,0,0,0,0}
	};
	int[][] matriuHexagonFalse = new int[][] {
		{7,6,0,0,3,0,1},
		{8,0,0,11,0,2,0},
		{0,0,19,18,0,0,15},
		{0,0,0,0,26,27,0},
		{0,0,0,32,0,0,29},
		{0,0,0,39,0,0,42},
		{49,0,47,0,0,0,0}
	};
	int[][] matriuHexagonFalseNoUltim = new int[][] {
		{7,6,0,0,3,0,0},
		{8,0,0,11,0,0,0},
		{0,0,19,18,0,0,15},
		{0,0,0,0,26,27,0},
		{0,0,0,32,0,0,29},
		{0,0,0,39,0,0,42},
		{0,0,47,0,0,0,0}
	};
	int[][] matriuHexagonFalseNoPrimer = new int[][] {
		{7,6,0,0,3,0,0},
		{8,0,0,11,0,0,0},
		{0,0,19,18,0,0,15},
		{0,0,0,0,26,27,0},
		{0,0,0,32,0,0,29},
		{0,0,0,39,0,0,42},
		{49,0,47,0,0,0,0}
	};

	int[][] matriuFacil = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{0,0,0},
		{0,-1,8},
		{5,0,0}
	};

	Vector<Integer> givenTest = new Vector<Integer>();
	
	@Before
	public void setUp() {
	    hidato = null;
	    algorismes = null;
	}
	
	@Test
	void testConstructor() {
		setUpQuadratCostats(matriuQuadratCostats);
		Algorismes algorismes = new Algorismes(hidato);
		assertEquals(matriuQuadratCostats , algorismes.getMatriuSolucioForce() );
	}
	
	@Test
	void testModificarHidato() {
		setUpHidatoBuit();	
		algorismes = new Algorismes(hidato);
		hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS, matriuQuadratCostats);
		algorismes.modificarHidato(hidato);
		assertEquals(matriuQuadratCostats, algorismes.getMatriuSolucioForce() );
	}
	
	@Test
	void testSolucionarQuadratCostats() {
		setUpQuadratCostats(matriuQuadratCostats);
		algorismes = new Algorismes(hidato);
		assertEquals(true , algorismes.solucionar() );
	}
	@Test
	void testSolucionarQuadratCostatsFalse() {
		setUpQuadratCostats(matriuQuadratCostatsFalse);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	@Test
	void testSolucionarQuadratCostatsFalseNoUltim() {
		setUpQuadratCostats(matriuQuadratCostatsFalseNoUltim);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	@Test
	void testSolucionarQuadratCostatsFalseNoPrimer() {
		setUpQuadratCostats(matriuQuadratCostatsFalseNoPrimer);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}

	@Test
	void testSolucionarQuadratAmbdos() {
		setUpQuadratAmbdos(matriuQuadratAmbdos);
		algorismes = new Algorismes(hidato);
		assertEquals(true , algorismes.solucionar() );
	}
	@Test
	void testSolucionarQuadratAmbdosFalse() {
		setUpQuadratAmbdos(matriuQuadratAmbdosFalse);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	@Test
	void testSolucionarQuadratAmbdosFalseNoUltim() {
		setUpQuadratAmbdos(matriuQuadratAmbdosFalseNoUltim);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	@Test
	void testSolucionarQuadratAmbdosFalseNoPrimer() {
		setUpQuadratAmbdos(matriuQuadratAmbdosFalseNoPrimer);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}

	@Test
	void testSolucionarTriangleCostats() {
		setUpTriangleCostats(matriuTriangleCostats);
		algorismes = new Algorismes(hidato);
		assertEquals(true , algorismes.solucionar() );
	}
	@Test
	void testSolucionarTriangleCostatsFalse() {
		setUpTriangleCostats(matriuTriangleCostatsFalse);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	@Test
	void testSolucionarTriangleCostatsFalseNoUltim() {
		setUpTriangleCostats(matriuTriangleCostatsFalseNoUltim);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	@Test
	void testSolucionarTriangleCostatsFalseNoPrimer() {
		setUpTriangleCostats(matriuTriangleCostatsFalseNoPrimer);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	
	@Test
	void testSolucionarHexagon() {
		setUpHexagon(matriuHexagon);
		algorismes = new Algorismes(hidato);
		assertEquals(true , algorismes.solucionar() );
	}
	@Test
	void testSolucionarHexagonFalse() {
		setUpHexagon(matriuHexagonFalse);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	@Test
	void testSolucionarHexagonFalseNoUltim() {
		setUpHexagon(matriuHexagonFalseNoUltim);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}
	@Test
	void testSolucionarHexagonFalseNoPrimer() {
		setUpHexagon(matriuHexagonFalseNoPrimer);
		algorismes = new Algorismes(hidato);
		assertEquals(false , algorismes.solucionar() );
	}

	
	@Test
	void testGetMatriuSolucio() {
		setUpQuadratCostats(matriuQuadratCostats);
		algorismes = new Algorismes(hidato);
		algorismes.solucionar();
		assertArrayEquals(matriuQuadratCostatsSolucio , algorismes.getMatriuSolucio() );
	}
	@Test
	void testGetMatriuSolucioFalse() {
		setUpQuadratCostats(matriuQuadratCostats);
		algorismes = new Algorismes(hidato);
		algorismes.solucionar();
		assertFalse(Arrays.equals(matriuQuadratCostats, algorismes.getMatriuSolucio()));
	}
	
	
	@Test
	void testObtenirDificultatDificil() {
		setUpQuadratCostats(matriuQuadratCostats);
		algorismes = new Algorismes(hidato);
		algorismes.solucionar();
		assertEquals(Dificultat.DIFICIL , algorismes.obtenirDificultat() );
	}
	@Test
	void testObtenirDificultatMig() {
		setUpHexagon(matriuHexagon);
		algorismes = new Algorismes(hidato);
		algorismes.solucionar();
		assertEquals(Dificultat.MIG , algorismes.obtenirDificultat() );
	}
	@Test
	void testObtenirDificultatFacil() {
		setUpQuadratCostats(matriuFacil);
		algorismes = new Algorismes(hidato);
		algorismes.solucionar();
		assertEquals(Dificultat.FACIL , algorismes.obtenirDificultat() );
	}

	@Test
	void testGetGiven() {
		setUpQuadratCostats(matriuFacil);
		algorismes = new Algorismes(hidato);
		algorismes.solucionar();
		fillGivenTest();
		assertEquals(givenTest , algorismes.getGiven() );
	}
	
	@Test
	void testGenerarHidatoQuadratCostats() {
		hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		algorismes = new Algorismes(hidato);
		int forats = 0; //no podem provar amb forats, o amb determinades combinacions perque no ens podem assegurar 100% que es pugui generar un hidato
		int tamanyi = 5;
		int tamanyj = 5;
		
		//necessita que funcionin molts dels tests anteriors, pero aixi podem comprovar que certament genera un hidato solucionable
		int[][] hidatoGenerat = algorismes.generarHidato(forats, tamanyi, tamanyj);
		assertFalse(Arrays.equals(null, hidatoGenerat));
		
		hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS, hidatoGenerat);
		algorismes = new Algorismes(hidato);
		assertTrue(algorismes.solucionar());
	}

	@Test
	void testGenerarHidatoQuadratCostatsIAngles() {
		hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATSIANGLES);
		algorismes = new Algorismes(hidato);
		int forats = 0; //no podem provar amb forats, o amb determinades combinacions perque no ens podem assegurar 100% que es pugui generar un hidato
		int tamanyi = 5;
		int tamanyj = 5;
		
		//necessita que funcionin molts dels tests anteriors, pero aixi podem comprovar que certament genera un hidato solucionable
		int[][] hidatoGenerat = algorismes.generarHidato(forats, tamanyi, tamanyj);
		assertFalse(Arrays.equals(null, hidatoGenerat));
		
		hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATSIANGLES, hidatoGenerat);
		algorismes = new Algorismes(hidato);
		assertTrue(algorismes.solucionar());
	}
	
	@Test
	void testGenerarHidatoTriangle() {
		hidato = new HidatoTriangleStub();
		algorismes = new Algorismes(hidato);
		int forats = 0; //no podem provar amb forats, o amb determinades combinacions perque no ens podem assegurar 100% que es pugui generar un hidato
		int tamanyi = 6;
		int tamanyj = 6;
		
		//necessita que funcionin molts dels tests anteriors, pero aixi podem comprovar que certament genera un hidato solucionable
		int[][] hidatoGenerat = algorismes.generarHidato(forats, tamanyi, tamanyj);
		assertFalse(Arrays.equals(null, hidatoGenerat));
		hidato = new HidatoTriangleStub(hidatoGenerat);
		algorismes = new Algorismes(hidato);
		assertTrue(algorismes.solucionar());
	}
	
	@Test
	void testGenerarHidatoHexagon() {
		hidato = new HidatoHexagonStub();
		algorismes = new Algorismes(hidato);
		int forats = 0; //no podem provar amb forats, o amb determinades combinacions perque no ens podem assegurar 100% que es pugui generar un hidato
		int tamanyi = 5;
		int tamanyj = 5;
		
		//necessita que funcionin molts dels tests anteriors, pero aixi podem comprovar que certament genera un hidato solucionable
		int[][] hidatoGenerat = algorismes.generarHidato(forats, tamanyi, tamanyj);
		assertFalse(Arrays.equals(null, hidatoGenerat));
		
		hidato = new HidatoHexagonStub(hidatoGenerat);
		algorismes = new Algorismes(hidato);
		assertTrue(algorismes.solucionar());
	}
	//No es testeja el metode de generar un hidato donada una dificultat, ja que els forats que s'hi fiquen
	//son aleatoris i pot no donar un hidato, la cual cosa retornaria fals. Per aquest mètode, millor
	//utilitzar el driver
	
	
	private void setUpHidatoBuit() {
		hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
	}
	
	private void setUpQuadratCostats(int[][] matriuQuadrat) {
		hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS, matriuQuadrat);
	}
	
	private void setUpQuadratAmbdos(int[][] matriuQuadrat) {
		hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATSIANGLES, matriuQuadrat);
	}
	
	private void setUpTriangleCostats(int[][] matriuTriangle) {
		hidato = new HidatoTriangleStub(matriuTriangle);

	}
	
	private void setUpHexagon(int[][] matriuHexagon) {
		hidato = new HidatoHexagonStub(matriuHexagon);

	}
	
	private void fillGivenTest() {
		givenTest.add(1);
		givenTest.add(5);
		givenTest.add(8);
		givenTest.add(11);
	}
}

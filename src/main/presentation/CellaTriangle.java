package main.presentation;

import static java.lang.Math.sqrt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Vector;

import main.domain.com.hidato.TipusCella;

public class CellaTriangle extends Cella{
	private int borderLeft=0;
    private int borderTop=0;
    private double altura=0;	
    private double primerx=0;   //primer vèrtex des de l'esquerra
    private double amplada;    //segon vèrtex des de l'equerra 
    
    @Override
    public void setTamany(double altura) {
        this.altura = altura;
        this.amplada = altura*2/sqrt(3);
        this.primerx = amplada/2;  
    }

    private Polygon cella (int x0, int y0, int i, int j) {
        int y = y0 + borderTop;
        int x = x0 + borderLeft;  

        int[] cx,cy;

        if (mateixaParitat(i,j)) { 		//o sigui, cella dreta, no de l'inreves
            cy = new int[] {y+roundToInt(altura), y, y+roundToInt(altura)};
        }
        
        else {
        	cy = new int[] {y, y+roundToInt(altura), y};
        }     

    	cx = new int[] {x, x+roundToInt(primerx), x+roundToInt(amplada)};

        return new Polygon(cx,cy,3);
    }
    

	@Override
    public void dibuixaCella(int i, int j, Graphics2D g2) {
        int x = j * roundToInt(primerx);
        int y = i * roundToInt(altura);
        g2.setColor(new Color(255, 236, 150));
        g2.fillPolygon(cella(x,y,i,j));
        g2.setColor(Color.BLACK);
        g2.drawPolygon(cella(x,y,i,j));
    }

	@Override
    public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2) {
        String str;
        int x = j * roundToInt(primerx);
        int y = i * roundToInt(altura);
        if (n == -1) {
            g2.setColor(new Color(193, 192, 174));
            g2.fillPolygon(cella(x,y,i,j));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(cella(x,y,i,j));
        }
        if (n > 1) {
            g2.setColor(new Color(255, 219, 40));
            g2.fillPolygon(cella(x,y,i,j));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(cella(x,y,i,j));
            g2.setColor(Color.BLACK);
            str = Integer.toString(n);
            g2.drawString(str, x+(int)primerx/2+(int)Math.round(amplada)/10+borderLeft, y+(int)Math.round(altura)/2+borderTop+4);
        }
        
        if (n == ultim || n == 1) {
        	g2.setColor(new Color(255, 173, 105));
            g2.fillPolygon(cella(x,y,i,j));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(cella(x,y,i,j));
            g2.setColor(Color.BLACK);
            str = Integer.toString(n);
            g2.drawString(str, x+(int)primerx/2+(int)Math.round(amplada)/10+borderLeft, y+(int)Math.round(altura)/2+borderTop+4);
        }
    }
    
    @Override
    public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2, Color color) {
        String str;
        int x = j * roundToInt(primerx);
        int y = i * roundToInt(altura);

        g2.setColor(color);
        g2.fillPolygon(cella(x,y,i,j));
        g2.setColor(Color.BLACK);
        g2.drawPolygon(cella(x,y,i,j));
        g2.setColor(Color.BLACK);
        str = Integer.toString(n);
        g2.drawString(str, x+(int)primerx/2+(int)Math.round(amplada)/10+borderLeft, y+(int)Math.round(altura)/2+borderTop+4);
        
    }

    @Override
    public Point pixelsToPosicioMatriu(int posx, int posy) {
        Point p = new Point(-1,-1);
        posx -= borderLeft;
        posy -= borderTop;
        double pendiente = altura/primerx;        

        
        int y = (int)Math.floor(posy/altura);
        int x = (int)Math.floor(posx/primerx);
        
        double posicioXrelativa;
        if (mateixaParitat(y,x)) posicioXrelativa = posx - ((x) * primerx);
        else posicioXrelativa = ((x+1) * primerx) - posx;
        double posicioYrelativa = ((y+1) * altura) - posy;
        
        
        /*if ( mateixaParitat(y,x)) {
	        if ( (posicioYrelativa/posicioXrelativa > pendiente) ) { 	//si fas click a la meitat de dalt/esquerra
	        	--x;
	        }
        }
        else {
	        if ( !esParell(x) && (posicioYrelativa/posicioXrelativa < pendiente) ) { 	//si fas click a la meitat de dalt/dreta
	        	--x;
	        }
        }*/
        
        
        /* Deixar aquesta versio un temps fins assegurar-nos que la de dalt funciona*/
        if ( esParell(y)) {
	        if ( esParell(x) && (posicioYrelativa/posicioXrelativa > pendiente) ) { 	//si fas click a la meitat de dalt/esquerra
	        	--x;
	        }
	        
	        else if ( !esParell(x) && (posicioYrelativa/posicioXrelativa < pendiente) ) { 	//si fas click a la meitat de dalt/esquerra
	        	--x;
	        }
        }
        
        else {
        	if ( !esParell(x) && (posicioYrelativa/posicioXrelativa > pendiente) ) { 	//si fas click a la meitat de dalt/esquerra
	        	--x;
	        }
	        
        	else if ( esParell(x) && (posicioYrelativa/posicioXrelativa < pendiente) ) { 	//si fas click a la meitat de dalt/esquerra
	        	--x;
	        }
        }

        
        p.x=x;
        p.y=y;
        return p;
    }

	@Override
	public void setBorderTop(int border) {
		this.borderTop = border;
	}
	@Override
	public void setBorderLeft(int border) {
		this.borderLeft = border;
		
	}

	@Override
	public Vector<Double> screenProperties(int screenWidth, int screenHeight, int boardHeight, int boardWidth) {
			
		 //celles horitzontals reals respecte el tamany d'una abans d'acoplar-se. Per exemple 3 celles horitzontalment ocupen el mateix que 2 sense acoplar-se
        int paritat = 0;
		if (boardWidth%2 == 0) paritat = 1;
		double cellesHoritzontals = Math.ceil((double)boardWidth/2) + paritat*0.5 + 0.05;
		double cellesVerticals = boardHeight + 0.05; //per que no es talli per poc, degut a l'arrossegament de decimals
		double cellaHeight;
		double cellaWidth;
        
		double tamanyHoritzontal = cellesHoritzontals * 2/sqrt(3); //tamany horitzontal respecte al vertical
        
        if ((double)screenHeight/(double)screenWidth >= cellesVerticals/tamanyHoritzontal) { //relacio d'aspecte de la pantalla es mes alta que la del hidato
        	cellaWidth = (double)screenWidth/cellesHoritzontals;
        	cellaHeight = sqrt(3)*cellaWidth/2;
        }
        else { 
        	cellaHeight = (double)screenHeight/cellesVerticals;
        	cellaWidth = cellaHeight*2/sqrt(3);
        }
        
        int borderTop = 0;
        int borderLeft = 0;
        
    	borderLeft = (int) (screenWidth - cellesHoritzontals*cellaWidth)/2;     
    	borderTop = (int) (screenHeight - cellesVerticals*cellaHeight)/2;

    	Vector<Double> properties = new Vector<Double>();
    	properties.add(cellaHeight);
    	properties.add((double)borderTop);
    	properties.add((double)borderLeft);
    	
    	return properties;
	}
	
	private boolean mateixaParitat(int i, int j) {
		return (i%2 == j%2);
	}
	
	private boolean esParell(int value) {
		return (value%2 == 0);
	}
	
	@Override
	public TipusCella getTipusCella() {
		return TipusCella.TRIANGLE;
	}
}

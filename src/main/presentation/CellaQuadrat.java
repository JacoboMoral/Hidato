package main.presentation;

import static java.lang.Math.sqrt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Vector;

import main.domain.com.hidato.TipusCella;

public class CellaQuadrat extends Cella{
    private int borderLeft=0;
    private int borderTop=0;
    private double altura=0;	

    @Override
    public void setTamany(double altura) {
        this.altura = altura;
    }

    private Polygon cella (int x0, int y0) {
        int y = y0 + borderTop;
        int x = x0 + borderLeft;  

        int[] cx,cy;

        cx = new int[] {x, x+roundToInt(altura), x+roundToInt(altura), x};
        cy = new int[] {y, y, y+roundToInt(altura), y+roundToInt(altura)};

        return new Polygon(cx,cy,4);
    }
    
    @Override
    public void dibuixaCella(int i, int j, Graphics2D g2) {
        int x = j * roundToInt(altura);
        int y = i * roundToInt(altura);
        g2.setColor(new Color(255, 236, 150));
        g2.fillPolygon(cella(x,y));
        g2.setColor(Color.BLACK);
        g2.drawPolygon(cella(x,y));
    }

    @Override
    public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2) {
        String str;
        int x = j * roundToInt(altura);
        int y = i * roundToInt(altura);
        if (n == -1) {
            g2.setColor(new Color(193, 192, 174));
            g2.fillPolygon(cella(x,y));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(cella(x,y));
        }
        if (n > 0) {
            g2.setColor(new Color(255, 219, 40));
            g2.fillPolygon(cella(x,y));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(cella(x,y));
            g2.setColor(Color.BLACK);
            str = Integer.toString(n);
            g2.drawString(str, x+(int)Math.round(altura)/10+borderLeft, y+(int)Math.round(altura)/2+borderTop+4);
        }
        
        if (n == ultim || n == 1) {
        	g2.setColor(new Color(255, 173, 105));
            g2.fillPolygon(cella(x,y));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(cella(x,y));
            g2.setColor(Color.BLACK);
            str = Integer.toString(n);
            g2.drawString(str, x+(int)Math.round(altura)/10+borderLeft, y+(int)Math.round(altura)/2+borderTop+4);
        }
    }

    @Override
    public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2, Color color) {
        String str;
        int x = j * roundToInt(altura);
        int y = i * roundToInt(altura);

        g2.setColor(color);
        g2.fillPolygon(cella(x,y));
        g2.setColor(Color.BLACK);
        g2.drawPolygon(cella(x,y));
        g2.setColor(Color.BLACK);
        str = Integer.toString(n);
        g2.drawString(str, x+(int)Math.round(altura)/10+borderLeft, y+(int)Math.round(altura)/2+borderTop+4);  
        
    }

    @Override
    public Point pixelsToPosicioMatriu(int posx, int posy) {
        Point p = new Point(-1,-1);

        posx -= borderLeft;
        posy -= borderTop;
        
        int x = (int)(posx/(altura));  
        int y = (int)(posy/(altura));

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
		

		double cellesVerticals = boardHeight*1.05;
		double cellesHoritzontals = boardWidth*1.05;
		
		double cellaHeight;
		
        if ((double)screenHeight/(double)screenWidth >= cellesVerticals/cellesHoritzontals) { //relacio d'aspecte de la pantalla es mes alta que la del hidato
        	cellaHeight = (double)screenWidth/cellesHoritzontals;
        }
        else { 
        	cellaHeight = (double)screenHeight/cellesVerticals;
        }
        
        int borderTop = 0;
        int borderLeft = 0;
        
    	borderLeft = (int) (screenWidth - cellesHoritzontals*cellaHeight)/2;    
    	borderTop = (int) (screenHeight - cellesVerticals*cellaHeight)/2+1;

    	Vector<Double> properties = new Vector<Double>();
    	properties.add(cellaHeight);
    	properties.add((double)borderTop);
    	properties.add((double)borderLeft);
    	
    	return properties;
	}
	
	@Override
	public TipusCella getTipusCella() {
		return TipusCella.QUADRAT;
	}
}

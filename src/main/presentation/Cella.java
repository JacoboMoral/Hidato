package main.presentation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Vector;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

abstract class Cella {
	
    abstract public void setTamany(double givenAltura);

    abstract public void dibuixaCella(int i, int j, Graphics2D g2);

    abstract public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2);
    abstract public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2, Color color);
		
	
    abstract public Point pixelsToPosicioMatriu(int posx, int posy);
	abstract public void setBorderLeft(int border);
	abstract public void setBorderTop(int border);
	
	abstract public Vector<Double> screenProperties(int screenWidth, int screenHeight, int boardHeight, int boardWidth); 
	
	abstract public TipusCella getTipusCella();
	
	protected int roundToInt(double x) {
		int r = (int)Math.round(x);
		return r;
	}
}

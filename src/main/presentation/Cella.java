package main.presentation;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Vector;

abstract class Cella {
    abstract public void setTamany(double givenAltura);
    abstract public Polygon cella (int x0, int y0);

    abstract public void dibuixaCella(int i, int j, Graphics2D g2);

    abstract public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2);
    abstract public Point locationToMatriu(int posx, int posy);
}

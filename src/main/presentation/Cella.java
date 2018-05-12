package main.presentation;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

abstract class Cella {
    abstract public void setTamany(int givenAltura);
    abstract public Polygon cella (int x0, int y0);

    abstract public void dibuixaCella(int i, int j, Graphics2D g2);

    abstract public void emplenaCella(int i, int j, int n, Graphics2D g2);
    abstract public Point locationToMatriu(int posx, int posy);
}

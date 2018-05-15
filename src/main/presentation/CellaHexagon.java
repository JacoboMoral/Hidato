package main.presentation;

import java.awt.*;
import java.util.Vector;

public class CellaHexagon extends Cella{

    private static int BORDER=15;
    private static double altura=0;	
    private static double primery=0;   //primer vèrtex des de dalt
    private static double segony=0;    //segon vèrtex des de dalt
    private static double primerx=0;   //primer vèrtex des de l'esquerra
    private static double segonx=0;    //segon vèrtex des de l'equerra (i.e. width)

    public void setTamany(double altura) {
        this.altura = altura;
        double radi = altura/2;
        primery = altura/4;
        segony = altura/4 * 3;

        primerx = radi*Math.sqrt(3)/2;
        segonx = radi*Math.sqrt(3);
        System.out.println("Cella hexagon altura: " + altura);
        System.out.println("Cella hexagon amplada: " + segonx);

    }

    public Polygon cella (int x0, int y0) {
        int y = y0 + BORDER;
        int x = x0 + BORDER;  

        int[] cx,cy;

        cx = new int[] {x+(int)Math.round(primerx),x+(int)Math.round(segonx),x+(int)Math.round(segonx),x+(int)Math.round(primerx),x,x};
        cy = new int[] {y,y+(int)Math.round(primery),y+(int)Math.round(segony),y+(int)Math.round(altura),y+(int)Math.round(segony),y+(int)Math.round(primery)};

        return new Polygon(cx,cy,6);
    }

    public void dibuixaCella(int i, int j, Graphics2D g2) {
        int x = j * (int)Math.round(segonx) + (i%2)*(int)Math.round(segonx)/2;
        int y = i * (int)Math.round(segony);
        g2.setColor(new Color(255, 230, 107));
        g2.fillPolygon(cella(x,y));
        g2.setColor(Color.BLACK);
        g2.drawPolygon(cella(x,y));
    }

    public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2, Vector<Point> posicionsAdjacents) {
        String str;
        int x = j * (int)Math.round(segonx) + (i%2)*(int)Math.round(segonx/2);
        int y = i * (int)Math.round(segony);
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
            g2.drawString(str, x+(int)Math.round(altura)/10+BORDER, y+(int)Math.round(altura)/2+BORDER+4);
        }
        
        if (n == ultim || n == 1) {
        	g2.setColor(new Color(255, 173, 105));
            g2.fillPolygon(cella(x,y));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(cella(x,y));
            g2.setColor(Color.BLACK);
            str = Integer.toString(n);
            g2.drawString(str, x+(int)Math.round(altura)/10+BORDER, y+(int)Math.round(altura)/2+BORDER+4);
        }
        
        if (n == 0) { 										//per provar possibles colors
        	Point actual = new Point(j,i);
        	if (posicionsAdjacents.contains(actual)) {
        		g2.setColor(new Color(220, 255, 105)); //mes sutil: (235, 255, 105)
                g2.fillPolygon(cella(x,y));
                g2.setColor(Color.BLACK);
                g2.drawPolygon(cella(x,y));
                g2.setColor(Color.BLACK);
                str = Integer.toString(n);
                g2.drawString(str, x+(int)Math.round(altura)/10+BORDER, y+(int)Math.round(altura)/2+BORDER+4);
        	}
        	
        	
        }
    }

    public Point locationToMatriu(int posx, int posy) {
        Point p = new Point(-1,-1);
        System.out.println("Posicio x: " + posx + ", Posicio y: " + posy);

        posx -= BORDER;
        posy -= BORDER;
        
        int y = (int) (posy / segony);
        
        double xleft = ((posx - ((y%2)*primerx))/ (segonx));	//per controlar que si cliques a la esquerra de les filles parelles, no sigui x = 0;
        int x = -1;
        if (xleft >= 0) x = (int) xleft;
        
        System.out.println("CellaHexagon posicio (en decimal): " + xleft);
        
        double distxf = ((x+1)*segonx - posx + (y%2)*primerx);
        double distxi = (posx - x*segonx - (y%2)*primerx);
        double distxc = (distxf - distxi)/2;
        double distyf = ((y+1)*segony - posy);
        double distyi = (posy - y*segony);

        double posiciox = (double) posx;
        double posicioy = (double) posy;

        if (y%2 == 0) { //files parelles, on l'hexagon esta desplaçat cap a la dreta mig hexagon
        	int aux = (int) (posx - primerx);
        	
        }
        
        if (distyi <= primery){                 //quadrat de dalt de cada hexagon, incloent un triangle de cadascun dels hexagons adjacents per dalt
            if (Math.abs(distyi/distxc) < 0.5){
                --y;
                if (y%2 == 0){
                    if (distxc < 0) ++x;
                }
                else{
                    if (distxc > 0) --x;
                }
            }       
        }
        
        p.x=x;
        p.y=y;
        System.out.println("Posicio x: " + posx + ", Posicio y: " + posy);
        System.out.println("Distancia final x: " + distxc + ", Distancia final y: " + distyi);
        System.out.println(p);
        return p;
    }
}
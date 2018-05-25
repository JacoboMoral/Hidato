package main.presentation;

import static java.lang.Math.sqrt;

import java.awt.*;
import java.util.Vector;

import main.domain.com.hidato.TipusCella;

public class CellaHexagon extends Cella{

    private int borderLeft=0;
    private int borderTop=0;
    private double altura=0;	
    private double primery=0;   //primer vèrtex des de dalt
    private double segony=0;    //segon vèrtex des de dalt
    private double primerx=0;   //primer vèrtex des de l'esquerra
    private double segonx=0;    //segon vèrtex des de l'equerra (i.e. width)
    
    @Override
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

    private Polygon cella (int x0, int y0) {
        int y = y0 + borderTop;
        int x = x0 + borderLeft;  

        int[] cx,cy;

        cx = new int[] {x+(int)Math.round(primerx),x+(int)Math.round(segonx),x+(int)Math.round(segonx),x+(int)Math.round(primerx),x,x};
        cy = new int[] {y,y+(int)Math.round(primery),y+(int)Math.round(segony),y+(int)Math.round(altura),y+(int)Math.round(segony),y+(int)Math.round(primery)};

        return new Polygon(cx,cy,6);
    }

    @Override
    public void dibuixaCella(int i, int j, Graphics2D g2) {
        int x = j * (int)Math.round(segonx) + (i%2)*(int)Math.round(segonx)/2;
        int y = i * (int)Math.round(segony);
        g2.setColor(new Color(255, 236, 150));
        g2.fillPolygon(cella(x,y));
        g2.setColor(Color.BLACK);
        g2.drawPolygon(cella(x,y));
    }

    @Override
    public void emplenaCella(int i, int j, int n, int ultim, Graphics2D g2) {
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
        int x = j * (int)Math.round(segonx) + (i%2)*(int)Math.round(segonx/2);
        int y = i * (int)Math.round(segony);

        g2.setColor(color);
        g2.fillPolygon(cella(x,y));
        g2.setColor(Color.BLACK);
        g2.drawPolygon(cella(x,y));
        g2.setColor(Color.BLACK);
        str = Integer.toString(n);
        g2.drawString(str, x+(int)Math.round(altura)/10+borderLeft, y+(int)Math.round(altura)/2+borderTop+4);  
        
    }

    @Override
    public Point locationToMatriu(int posx, int posy) {
        Point p = new Point(-1,-1);
        //System.out.println("Posicio x: " + posx + ", Posicio y: " + posy);

        posx -= borderLeft;
        posy -= borderTop;
        
        int y = (int) (posy / segony);
        
        double xleft = ((posx - ((y%2)*primerx))/ (segonx));	//per controlar que si cliques a la esquerra de les filles parelles, no sigui x = 0;
        int x = -1;
        if (xleft >= 0) x = (int) xleft;
        
        //System.out.println("CellaHexagon posicio (en decimal): " + xleft);
        
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
        //System.out.println("Distancia final x: " + distxc + ", Distancia final y: " + distyi);
        System.out.println(p);
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
		double cellaHeight;
		double nombreRealCellesVerticals; 
        int verticalsSenceres = (int) Math.ceil((double)boardHeight/2);
        double verticalsMitges = boardHeight - verticalsSenceres;
        int paritat = 0;
        if (boardHeight%2 == 0) paritat = 1;
        nombreRealCellesVerticals = verticalsSenceres + verticalsMitges*0.5 + paritat*0.25;
        nombreRealCellesVerticals+=0.05; //perque no es talli a vegades
        
        double nombreRealCellesHoritzontals;
        nombreRealCellesHoritzontals = (double)(boardWidth+0.5) + 0.05;
        
        double tamanyHoritzontal = (sqrt(3)/2)*nombreRealCellesHoritzontals;
        
        double cellaWidth;
        if (screenHeight/screenWidth >= nombreRealCellesVerticals/tamanyHoritzontal) { //relacio d'aspecte de la pantalla es mes alta que la del hidato
        	System.out.println("relacio d'aspecte de la pantalla es mes alta o igual que la del hidato");
        	cellaWidth = screenWidth/nombreRealCellesHoritzontals;
        	cellaHeight = 2*cellaWidth/(sqrt(3));
        	System.out.println(cellaHeight);
        }
        else { 
        	System.out.println("relacio d'aspecte de la pantalla es mes baixa i gruixuda que la del hidato");
        	cellaHeight = screenHeight/nombreRealCellesVerticals;
        	cellaWidth = cellaHeight*sqrt(3)/2;
        	System.out.println(cellaHeight);
        }
        
        int borderTop = 0;
        int borderLeft = 0;
        
    	borderLeft = (int) (screenWidth - nombreRealCellesHoritzontals*cellaWidth)/2;     
    	borderTop = (int) (screenHeight - nombreRealCellesVerticals*cellaHeight)/2;

    	Vector<Double> properties = new Vector<Double>();
    	properties.add(cellaHeight);
    	properties.add((double)borderTop);
    	properties.add((double)borderLeft);
    	
    	return properties;
	}

	@Override
	public TipusCella getTipusCella() {
		return TipusCella.HEXAGON;
	}
}
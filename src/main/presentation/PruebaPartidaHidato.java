/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Yago
 */
public class PruebaPartidaHidato extends JPanel {

    public static void main(String[] args){
        PruebaPartidaHidato program = new PruebaPartidaHidato();
        
        JFrame frame = new JFrame();
        frame.setTitle("Prueba dibujar matriu hidato");
        frame.setSize(900, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(program);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        
        
        
        Polygon p = new Polygon();
        for (int i = 0; i < 6; ++i){
            for (int j = 0; j < 10; ++j){
                if (i%2 == 0){
                    if (j%2 == 0){
                        p.xpoints = new int[]{10+j*40,50+j*40,90+j*40};
                        p.ypoints = new int[]{90+i*80,10+i*80,90+i*80};
                        p.npoints = 3;
                        g.setColor(Color.ORANGE);
                        g.fillPolygon(p); 
                        g.setColor(Color.BLACK);
                        g.drawPolygon(p);
                    }
                    else{
                        p.xpoints = new int[]{10+j*40,50+j*40,90+j*40};
                        p.ypoints = new int[]{10+i*80,90+i*80,10+i*80};
                        p.npoints = 3;
                        g.setColor(Color.ORANGE);
                        g.fillPolygon(p); 
                        g.setColor(Color.BLACK);
                        g.drawPolygon(p);
                    }
                }
                else{
                    if (j%2 == 0){
                        p.xpoints = new int[]{10+j*40,50+j*40,90+j*40};
                        p.ypoints = new int[]{10+i*80,90+i*80,10+i*80};
                        p.npoints = 3;
                        g.setColor(Color.ORANGE);
                        g.fillPolygon(p); 
                        g.setColor(Color.BLACK);
                        g.drawPolygon(p);
                        
                    }
                    else{
                        p.xpoints = new int[]{10+j*40,50+j*40,90+j*40};
                        p.ypoints = new int[]{90+i*80,10+i*80,90+i*80};
                        p.npoints = 3;
                        g.setColor(Color.ORANGE);
                        g.fillPolygon(p); 
                        g.setColor(Color.BLACK);
                        g.drawPolygon(p);
                    }
                }
                
            }  
        }
        
    }
    
    
    public PruebaPartidaHidato() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

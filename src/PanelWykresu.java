
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelWykresu extends JPanel {

    private double predkosc;
    private double kat;
    private double sinKata;
    private double sin2xKata;
    private double zasiegMax;
    private double wysokoscMax;
    private final double g = 9.80665;
    private double czasLotu;
    private double hInTime;
    private boolean animacja = false;

    private double odcinek;
    private double czas;
    private Image punkt = new ImageIcon("punkt.png").getImage();

    private double hNow;
    private double xNow;

    public PanelWykresu()
    {
        super();


    }

    public void obliczenia(double predkosc, int kat)
    {
        System.out.println(predkosc);
        System.out.println(kat);
        this.predkosc = predkosc;
        this.kat = kat;
        this.sinKata = (Math.sin(Math.toRadians(kat)));
        this.sin2xKata = (Math.sin(Math.toRadians(2*kat)));
        this.wysokoscMax = (Math.pow(this.predkosc, 2)/(2 * this.g)) * Math.pow(this.sinKata,2);
        this.czasLotu = (2 * this.predkosc * this.sinKata) / this.g;
        this.zasiegMax = ((Math.pow(this.predkosc,2)/g) * this.sin2xKata);

        this.odcinek = this.zasiegMax/100;
        this.czas = this.czasLotu/100;

        for(int i = 1; i<=100; i++)
        {
            this.hNow = (this.predkosc * (czas*i) * this.sinKata) - (this.g*(Math.pow((czas*i),2))/2);
            this.xNow = odcinek * i;

            //hNow *=100;
            //xNow *=100;

            //hNow = Math.round(hNow);
            //xNow = Math.round(xNow);

            //hNow /=100;
            //xNow /=100;

            //System.out.println(hNow);
            //System.out.println(xNow);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            animacja();
        }

    }

    public void animacja()
    {
        this.animacja = true;
        this.paint(this.getGraphics());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        // Linia X
        g2d.drawLine(30, 30, 30, 320);
        //linia Y
        g2d.drawLine(30, 320, 320, 320);

        //x[m]
        g2d.drawString("x[m]", 310, 340);
        //y[m]
        g2d.drawString("y[m]", 10, 20);

        g2d.drawString("1", 20, 260);
        g2d.drawString("2", 20, 200);
        g2d.drawString("3", 20, 140);
        g2d.drawString("4", 20, 80);

        g2d.drawString("1", 60, 335);
        g2d.drawString("2", 90, 335);
        g2d.drawString("3", 120, 335);
        g2d.drawString("4", 150, 335);
        g2d.drawString("5", 180, 335);
        g2d.drawString("6", 210, 335);
        g2d.drawString("7", 240, 335);
        g2d.drawString("8", 270, 335);
        g2d.drawString("9", 300, 335);

        g2d.setColor(Color.GRAY);

        g2d.drawLine(30, 260, 320, 260);
        g2d.drawLine(30, 200, 320, 200);
        g2d.drawLine(30, 140, 320, 140);
        g2d.drawLine(30, 80, 320, 80);

        g2d.drawLine(60, 30, 60, 320);
        g2d.drawLine(90, 30, 90, 320);
        g2d.drawLine(120, 30, 120, 320);
        g2d.drawLine(150, 30, 150, 320);
        g2d.drawLine(180, 30, 180, 320);
        g2d.drawLine(210, 30, 210, 320);
        g2d.drawLine(240, 30, 240, 320);
        g2d.drawLine(270, 30, 270, 320);
        g2d.drawLine(300, 30, 300, 320);

        int xPunkt;
        int yPunkt;

        int x0 = 30;
        int y0 = 320;

        int xTemp;
        int yTemp;


        if(animacja == true)
        {

            xTemp = (int) ((xNow - (int)xNow)*30.3);
            xPunkt = (int) (x0 + 30 * (xNow - (xNow - (int)xNow)) + xTemp);

            yTemp = (int) ((hNow - (int)hNow)* 60.6);
            yPunkt = (int) (y0 - 60 * (hNow - (hNow - (int)hNow)) - yTemp);

            System.out.println(hNow + " "+  xNow);
            g2d.drawRect(xPunkt, yPunkt, 10, -10);
        }

    }

}



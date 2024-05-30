package id.ac.uns.vokasi.d3ti.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JFrame;

public class GameSwing extends JFrame implements KeyListener {
    Image img;
    Toolkit t;
    int x, y;
    GrenadeLeft grenadeLeft; 

    public GameSwing() {
        t = Toolkit.getDefaultToolkit();
        img = t.getImage("./src/id/ac/uns/vokasi/d3ti/gui/pesawat.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setVisible(true);
        addKeyListener(this);
        x = 10;
        y = 240;
        grenadeLeft = new GrenadeLeft(this);
        grenadeLeft.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(img, x, y, this);
        
        if (grenadeLeft.respawn) {
            grenadeLeft = new GrenadeLeft(this);
            grenadeLeft.start();
            grenadeLeft.respawn = false;
        }
        
        g.drawImage(grenadeLeft.getImage(), grenadeLeft.getX(), grenadeLeft.getY(), this);
    }


    public static void main(String[] args) {
        new GameSwing();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            x = x + 10;
        }
        if (key == KeyEvent.VK_LEFT) {
            x = x - 10;
        }
        if (key == KeyEvent.VK_UP) {
            y = y - 10;
        }
        if (key == KeyEvent.VK_DOWN) {
            y = y + 10;
        }
        System.out.println("Koordinat X: " + x + " Koordinat Y: " + y);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    public int[] getXCood() {
        int koor[] = new int[64];
        for (int i = 0; i < 64; i++) {
            koor[i] = x + i;
        }
        return koor;
    }

    public int[] getYCood() {
        int koor[] = new int[64];
        for (int i = 0; i < 64; i++) {
            koor[i] = y + i;
        }
        return koor;
    }
}

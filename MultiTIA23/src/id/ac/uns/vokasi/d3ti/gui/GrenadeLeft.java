package id.ac.uns.vokasi.d3ti.gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Arrays;

public class GrenadeLeft extends Thread {
    GameSwing gameSwing;
    int x;
    int y;
    Image img;
    Toolkit t;
    boolean respawn = false;

    public GrenadeLeft(GameSwing gameSwing) {
        this.gameSwing = gameSwing;
        t = Toolkit.getDefaultToolkit();
        img = t.getImage("./src/id/ac/uns/vokasi/d3ti/gui/bomb.png");
        x = gameSwing.getWidth();
        y = 300;
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

    public boolean collPesawat() {
        boolean cekX = false;
        boolean cekY = false;

        for (int i = 0; i < 64; i++) {
            for (int k = 0; k < 64; k++) {
                if (gameSwing.getXCood()[i] == getXCood()[k]) {
                    cekX = true;
                }
            }
        }

        for (int i = 0; i < 64; i++) {
            for (int k = 0; k < 64; k++) {
                if (gameSwing.getYCood()[i] == getYCood()[k]) {
                    cekY = true;
                }
            }
        }

        if (cekX && cekY) {
            return true;
        } else {
            return false;
        }
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return img;
    }

    public int getX() {
        return x;
    }

    public void run() {
        while (x > 0) {
            try {
                Thread.sleep(1000);
                x = x - 50;
                if (x <= 0) {
                    x = gameSwing.getWidth();
                    respawn = true;
                }
                System.out.println(collPesawat());
                gameSwing.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

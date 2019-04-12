import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.ArrayList;

class Enemy {

    private double w,h, speed;
    private Image eImage;
    private GraphicsContext gc;
    float x, y, xlimIni, xlimFin;

    Enemy(GraphicsContext gc, int x, int y) {
        this.x = x;
        this.y = y;
        int alienWidth = 50;
        int alienWeight = 50;
        this.gc = gc;
        eImage = new Image("sprite_0_e.png", alienWidth, alienWeight, true, true);
        w = eImage.getWidth();
        h = eImage.getHeight();
        speed =0.3;
        xlimIni = x - 1;
        xlimFin = x + 130;
    }

    void render() {
        gc.drawImage(eImage, x, y);
    }

    void clear() {
        gc.clearRect(x, y, w, h);
    }

    void move() {
        if (x <= xlimIni || x >= xlimFin){
            y += 20;
            speed *= -1;
        }
        x += speed;
    }

    boolean checkMorir(Bullet bullet, ArrayList<Enemy> enemies, ArrayList<Bullet> bullets ) {

        int bulletX = (int) bullet.getX();
        int bulletY = (int) bullet.getY();
        int bulletW = (int) bullet.getW();
        int bulletH = (int) bullet.getH();

        int alienW = (int) w;
        int alienH = (int) h;

        Rectangle alienRectangle = new Rectangle();

        Rectangle pBullet = new Rectangle();

        alienRectangle.setBounds((int) x, (int) y, alienW, alienH);
        pBullet.setBounds(bulletX, bulletY, bulletW, bulletH);

        if(pBullet.intersects(alienRectangle)){
            enemies.remove(this);
            bullets.remove(bullet);
            return true;
        }
        return false;
    }
}

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class Bullet {

    int x,y, pos;
    private Image bImage;
    private double w, h;
    private GraphicsContext gc;

    double getW() {
        return w;
    }

    double getH() {
        return h;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    Bullet(int playerX, GraphicsContext gc) {
        this.gc = gc;
        y = 750;
        x = playerX;

        bImage = new Image("sprite_0_b.png");

        w = bImage.getWidth();
        h = bImage.getHeight();

        int width = (int) w;


        // Posicion de la nave entre 2 para que dispare desde el centro de la nave.
        pos = width / 2;
    }

    void move() {
        y -= 0.8;
    }

    void render() {
        gc.drawImage(bImage, x, y);
    }

}


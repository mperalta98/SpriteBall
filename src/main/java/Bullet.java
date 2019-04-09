import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet {
    public int getX() {
        return x;
    }

    int posXnav;
    int pos;

    int y = 750;
    int x;
    GraphicsContext gc;
    Canvas canvas;
    Image bImage;

    double w, h;

    public Bullet() {
        create();
    }

    void posicionNave(int x) {
        posXnav = x;

    }

    public void create() {
        String pType = "playerbullet";

//        canvas = new Canvas(600, 800);
//        gc = canvas.getGraphicsContext2D();

//        root.getChildren().add(canvas);

       bImage = new Image("sprite_0_b.png");

        w = bImage.getWidth();
        h = bImage.getHeight();

        int width = (int) w;

        // Posicion de la nave entre 2 para que dispare desde el centro de la nave.
        pos = width / 2 + posXnav;

//        gc.drawImage(bImage, pos, 750);

//        Main main = new Main();
//        main.getbImage(bImage,pos, y);

    }

    void shoot(){
        y -= 5;
    }

    void render(GraphicsContext gc, int pos) {
        gc.drawImage(bImage, pos, y);
    }

    void clear(GraphicsContext gc){
        gc.clearRect(pos, y, w, h);
    }
}


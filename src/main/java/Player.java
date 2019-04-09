import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player {


    Bullet bullet = new Bullet();
    double w,h;
    int x;
    Canvas canvas;
    Image pImage;

    public Player() {
        pImage= new Image("sprite_0.png");
        x = 300;
        w = pImage.getWidth();
        h = pImage.getHeight();
    }

    public void create(GraphicsContext gc) {
        String pType = "player";

        gc.drawImage(pImage, x, 750);
    }

    public void moveLeft() {
        x -= 5;
    }

    public void moveRight() {
        x += 5;
    }

    public int getX() {
        return x;
    }
    public void shoot(Group root) {
        bullet.posicionNave(x);
//        bullet.create(root, w);

    }

    public void clear(GraphicsContext gc) {
        gc.clearRect(x, 750, w, h);
    }
}

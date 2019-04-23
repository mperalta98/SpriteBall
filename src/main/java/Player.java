import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class Player {

    private double w,h;
    int x;
    private Image pImage;
    private GraphicsContext gc;

    Player(GraphicsContext gc) {
        this.gc = gc;
        pImage= new Image("sprite_0.png");
        x = 300;
        w = pImage.getWidth();
        h = pImage.getHeight();
    }
//
    int getX() {
        return x;
    }

    void render() {
        gc.drawImage(pImage, x, 750);
    }

    void moveLeft() {
        x -= 5;
    }

    void moveRight() {
        x += 5;
    }

    void clear() {
        gc.clearRect(x, 750, w, h);
    }
}

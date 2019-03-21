import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player {

    public static void player(Group root) {
        String pType = "player";
        Canvas canvas = new Canvas(600, 800);
        root.getChildren().add( canvas);


        Image pImage = new Image("sprite_0.png");

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.drawImage(pImage, 300,  750);

    }
}

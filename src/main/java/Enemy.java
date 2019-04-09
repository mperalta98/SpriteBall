import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Enemy {
    public static void enemy(Group root) {
        String pType = "enemy";
        Canvas canvas = new Canvas(600, 800);
        root.getChildren().add( canvas);

        Image eImage = new Image("sprite_0_e.png", 50, 50, true, true);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int i = 1; i <=6 ; i++) {

            gc.drawImage(eImage, 75*i,  100);
            gc.drawImage(eImage, 75*i,  140);
            gc.drawImage(eImage, 75*i,  180);
        }






//            for (int i = 0; i < 5; i++) {
//
//                TODO: CAMBIAR CONSTRUCTOR SPRITE Y CREAR LOS SPRITES COMO EL DE AQUI.
//                Main.Sprite s2 = new Main.Sprite(eImage,90 + i*100, 300, 30, 30, "enemy");
//
//                root.getChildren().add(s2);
//        }

    }
}

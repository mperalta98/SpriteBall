
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {

    private Group root = new Group();

    private double t = 0;

    GraphicsContext gc;
    private Image image;
    private int posY;
    private int posX;


    private Parent createContent() {
        Canvas canvas = new Canvas( 600, 800 );

        gc = canvas.getGraphicsContext2D();

        root.getChildren().add( canvas );

        nextLevel();

        return root;
    }

    private void nextLevel() {
        for (int i = 0; i < 5; i++) {
            //TODO: CAMBIAR CONSTRUCTOR SPRITE Y CREAR LOS SPRITES COMO EL DE AQUI.
//            Image eImage = new Image("sprite_0_e.png");
//            Sprite s = new Sprite(eImage,90 + i*100, 150, 30, 30, "enemy");


//            root.getChildren().add(s);
        }
    }

//    private List<Sprite> sprites() {
//        return root.getChildren().stream().map(n -> (Sprite)n).collect(Collectors.toList());
//    }



//    private void shoot(Sprite who) {
//        Sprite s = new Sprite((int) who.getTranslateX() + 20, (int) who.getTranslateY(), 5, 20, who.type + "bullet", Color.BLACK);

//        root.getChildren().add(s);
//    }



    @Override
    public void start(Stage stage) throws Exception {

        Player player = new Player();
        Bullet bullet = new Bullet();


        //TODO: REVISAR POSICION BALA, VUELVE A ESTAR MAL. LA BALA NO HACE LA ANIMACION ENTERA, MIRAR EL CLEARRECT ?  04 ABRIL 2019

        final long startNanoTime = System.nanoTime();


        AnimationTimer ani = new AnimationTimer() {
            public void handle(long currentNanoTime) {
//                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                bullet.clear(gc);

//                double x = 232 + 128 * Math.cos(t);
//                gc.clearRect(x, y, w, h);
//                posY-=5;
                bullet.shoot();
//                gc.drawImage(image , posX, posY);
                bullet.render(gc,player.getX());
                System.out.println(player.getX());
            }
        };

        Scene scene = new Scene(createContent());

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A:
                    player.clear(gc);
                    player.moveLeft();
                    player.create(gc);
//
                    break;
                case D:
                    player.clear(gc);
                    player.moveRight();
                    player.create(gc);
                    break;
                case SPACE:
                    ani.start();

                    if (bullet.y == 10) {
                        ani.stop();
                    }
                    break;
            }
        });

        player.create(gc);
        Enemy.enemy(root);

        stage.setScene(scene);
        stage.show();
    }

    public static class Sprite extends Rectangle {
        boolean dead = false;
        final String type;

        Sprite(Image image, int x, int y, int w, int h, String type) {
            super(w, h);

            this.type = type;
            setTranslateX(x);
            setTranslateY(y);
        }

        void moveLeft() {
            setTranslateX(getTranslateX() - 5);
        }

        void moveRight() {
            setTranslateX(getTranslateX() + 5);
        }

        void moveUp() {
            setTranslateY(getTranslateY() - 5);
        }

        void moveDown() {
            setTranslateY(getTranslateY() + 5);
        }
    }

    void getbImage(Image bImage, int pos, int y){

        image = bImage;
        posX = pos;
        posY = y;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
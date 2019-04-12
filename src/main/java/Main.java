import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Iterator;

public class Main extends Application {

    private Group root = new Group();
    private GraphicsContext gc;
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private AnimationTimer ani;
    private Player player;
    private int puntuacion;
    private boolean end = false;

    @Override
    public void start(Stage stage) {

        Canvas canvas = new Canvas( 600, 800 );
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add( canvas );

        Scene scene = new Scene(root);

        player = new Player(gc);
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 4; j++) {

                int x = 20 + 75 * i;
                int y = 50 + 50 * j;

                enemies.add(new Enemy(gc, x, y));
            }
        }
        //Bug conocido: Creado un alien fuera del mapa para poder finalizar el juego.
        enemies.add(new Enemy(gc, 700, 0));

        ani = new AnimationTimer() {
            public void handle(long currentNanoTime) {

                if (end){stop();}

                gc.clearRect(0, 0, 600,800);

                player.clear();
                player.render();

                for (Bullet bullet:bullets) {
                    bullet.move();
                    bullet.render();
                }

                for (Enemy enemy:enemies) {
                    enemy.clear();
                    enemy.move();
                    enemy.render();

                    for (Bullet bullet: bullets) {
                        if (enemy.checkMorir(bullet, enemies, bullets)){
                            puntuacion += 100;
                        }
                    }

                    if (enemy.y >= 780 ) {
                        gameOver(false);
                    }
                    if (puntuacion == 2400) {
                        gameOver(true);
                    }
                }

                for (Iterator<Bullet> itr = bullets.iterator(); itr.hasNext();){
                    Bullet bullet = itr.next();
                    if (bullet.y < 10){
                        itr.remove();
                    }
                }
                player.render();

                String score = "Puntuación: "+ puntuacion;
                gc.fillText(score, 470, 30);
                gc.strokeText(score, 470, 30);
            }
        };
        ani.start();

            scene.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case A:
                    case LEFT:
                        player.moveLeft();

                        break;
                    case D:
                    case RIGHT:
                        player.moveRight();
                        break;
                    case SPACE:
                    case W:
                    case UP:
                        bullets.add(new Bullet(player.getX(), gc));

                        break;
                }
            });

        stage.setScene(scene);
        stage.show();
    }

    private void gameOver(boolean win) {

        end = true;

        for (Enemy enemy: enemies) {
            enemy.clear();
        }
        player.clear();

        if(win) {
            gc.drawImage(new Image("win.png"), 0, 0);
        } else {
            gc.drawImage(new Image("lose.png"), 0, 0);
        }
    }

    public static void main(String[] args) { launch(args); }
}
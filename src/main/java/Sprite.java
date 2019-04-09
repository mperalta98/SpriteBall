import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

//TODO: ARREGLAR CLASE SPRITE PARA QUE PODAMOS MOVER LAS IMAGENES CORRECTAMENTE.
//TODO: NECESITAMOS SPRITES EN LAS CLASES PLAYER, BULLET Y ENEMY. AÑADIR METODO CLEAR EN EL SPRITE PARA BORRAR Y CREAR LAS IMAGENES (SIMULAR MOVIMIENTO).


public class Sprite extends Rectangle {
        boolean dead = false;
        final String type;


        Sprite(Image image, int x, int y, int w, int h, String type) {
            super(w, h);

            this.type = type;
            setTranslateX(x);
            setTranslateY(y);
        }

        void clear(){

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

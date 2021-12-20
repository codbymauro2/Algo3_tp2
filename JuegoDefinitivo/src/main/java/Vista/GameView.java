package Vista;

import Modelo.MainObjects.Game;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.awt.*;

public class GameView {

    private Canvas canvas;
    private Game game;
    
    public GameView(Game game, Canvas canvasCentral) {


    }

    public void clean() {
//        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
//        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    public void paint() {
//        this.clean();
//        Label label = new Label(game.getPlayerName());
    }

    public void update() {
        this.paint();
    }
}

/*

    private Robot robot;
    Canvas canvas;

    public VistaRobot(Robot robot, Canvas canvas) {
        this.robot = robot;
        this.canvas = canvas;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.BLUE);
        canvas.getGraphicsContext2D().fillOval(robot.getPosicion().getX() + 230, robot.getPosicion().getY() + 110, robot.RADIO, robot.RADIO);
    }

    public void clean() {

        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    public void update() {
        this.dibujar();
    }

 */
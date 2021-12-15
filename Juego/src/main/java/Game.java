import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public  class Game extends Application{

    private GraphicsContext graphics;
    private Group root;
    private Scene scene;
    private Canvas canvas;
    private static final String IMG = "./imagenes/prueba.jpg";

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage principalWindow) throws Exception {
        initialize();
        principalWindow.setScene(scene);
        principalWindow.setTitle("Carmen San Diego");
        principalWindow.show();
        paint();
    }


    public void initialize() {
        root = new Group();
        scene = new Scene(root, 700, 500);
        canvas = new Canvas(700,500);
        root.getChildren().add(canvas);
        graphics = canvas.getGraphicsContext2D();
    }

    public void paint() {
        graphics.fillRect(0,0,100,100 );
        graphics.drawImage(new Image(getClass().getResourceAsStream("main.png")),0,0);
    }
}
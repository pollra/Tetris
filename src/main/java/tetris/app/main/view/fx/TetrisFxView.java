package tetris.app.main.view.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tetris.app.main.basis.entity.Color;
import tetris.app.main.basis.service.GameBoard;
import tetris.app.main.basis.service.GameBoardImpl;
import tetris.app.main.command.handler.CommandHandler;

/**
 * @author pollra
 * @description TetrisFxView
 * @since 2020.04.04
 **********************************************************************************************************************/
public class TetrisFxView extends Application {

    private static boolean gameRunning = true;
    private static int[][] saveBoard = new int[24][12];
    private static GameBoard gameBoard = new GameBoardImpl();
    private static CommandHandler commandHandler = new CommandHandler(gameBoard);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/tetris.fxml"));
        BorderPane pane = new BorderPane();
        pane.setCenter(parent);

        primaryStage.setWidth(550);
        primaryStage.setHeight(720);

        Scene scene = new Scene(pane);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (gameRunning) {
                Platform.runLater(()->{
                    scene.setRoot(updateMap(commandHandler.command(e).clone()));
                });
            }
        });

        Thread thread = new Thread(() -> {
            while (gameRunning) {
                Platform.runLater(()->{
                    int[][] downResult = gameBoard.downMove();
                    scene.setRoot(updateMap(downResult));
                });
                try {
                    Thread.sleep(1000);
                } catch (Exception e) { }
            }
        });
        thread.setDaemon(true);
        thread.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane updateMap(int[][] arr){
        GridPane gridPane = new GridPane();

        Button button;
        StringBuffer colorString = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                button = new Button();
                button.setPrefSize(30, 30);
                button.setDisable(true);
                colorString.append(getColor(arr[i][j]));
                button.setStyle(colorString.toString());
                gridPane.add(button, j, i, 1, 1);
                colorString.delete(0, colorString.length());
            }
        }

        return gridPane;
    }

    public String getColor(int colorNumber){
        StringBuilder fxCssSyntax = new StringBuilder();
        fxCssSyntax.append("-fx-background-color: #");
        switch (colorNumber){
            case -1:
                return fxCssSyntax.append(Color.BLOCK.getCode()+";").toString();
            case 11:
            case 1:
                return fxCssSyntax.append(Color.RED.getCode()+";").toString();
            case 12:
            case 2:
                return fxCssSyntax.append(Color.ORANGE.getCode()+";").toString();
            case 13:
            case 3:
                return fxCssSyntax.append(Color.YELLOW.getCode()+";").toString();
            case 14:
            case 4:
                return fxCssSyntax.append(Color.GREEN.getCode()+";").toString();
            case 15:
            case 5:
                return fxCssSyntax.append(Color.BLUE.getCode()+";").toString();
            case 16:
            case 6:
                return fxCssSyntax.append(Color.PURPLE.getCode()+";").toString();
            case 17:
            case 7:
                return fxCssSyntax.append(Color.SKY.getCode()+";").toString();
            default:
                return fxCssSyntax.append(Color.WHITE.getCode()+";").toString();
        }
    }
}

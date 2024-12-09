/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projekpbov2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author ACER
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Pane gamePane;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label livesLabel;
    @FXML
    private ImageView basket;

    private final Basket playerBasket = new Basket();
    private static int score = 0;
    private AnimationTimer gameTimer;
    private double velocityX = 0;
    private List<ImageView> fallingItems = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
                velocityX = -playerBasket.getSpeed();
                break;
            case RIGHT:
                velocityX = playerBasket.getSpeed();
                break;
        }
    }

    @FXML
    private void handleKeyReleased(KeyEvent event) {
        if (event.getCode() == LEFT || event.getCode() == RIGHT) {
            velocityX = 0;
        }
    }
    
    private void updateBasketPosition() {
        double newX = basket.getLayoutX() + velocityX;
        if (newX >= 0 && newX <= (gamePane.getWidth() - basket.getFitWidth())) {
            basket.setLayoutX(newX);
        }
    }
    
        private void spawnItems() {
        if (Math.random() < 0.1) {
            Item item = generateRandomItem();
            String imagePath = "file:/C:/Users/ACER/OneDrive/Documents/NetBeansProjects/ProjekPBOV2/src/projekpbov2/" + item.getName() + ".png";
            
            try {
                ImageView itemView = new ImageView(imagePath);
                itemView.setFitWidth(130);
                itemView.setFitHeight(130);
                itemView.setLayoutX(Math.random() * (gamePane.getWidth() - 50));
                itemView.setLayoutY(0);
                itemView.setUserData(item);
                gamePane.getChildren().add(itemView);

                fallingItems.add(itemView);

                AnimationTimer dropAnimation = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        itemView.setLayoutY(itemView.getLayoutY() + 5);
                        if (itemView.getLayoutY() > gamePane.getHeight()) {
                            gamePane.getChildren().remove(itemView);
                            fallingItems.remove(itemView);
                            stop();
                        }
                    }
                };
                dropAnimation.start();
            } catch (NullPointerException e) {
                System.out.println("Image not found: " + imagePath);
            }
        }
    }
    
        private Item generateRandomItem() {
        int random = (int) (Math.random() * 4);
        switch (random) {
            case 0: return new Star();
            case 1: return new Orange();
            case 2: return new Banana();
            default: return new Bomb();
        }
    }


    private void updateScoreAndLives() {
        scoreLabel.setText("Score: " + score);
        livesLabel.setText("Lives: " + playerBasket.getLives());
    }
    
}

CER
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

    private void updateScoreAndLives() {
        scoreLabel.setText("Score: " + score);
        livesLabel.setText("Lives: " + playerBasket.getLives());
    }
    
}

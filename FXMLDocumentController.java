/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projekpbov2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

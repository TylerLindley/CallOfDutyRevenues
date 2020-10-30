import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class RevenueBarGraphController {

    @FXML
    private HBox hBox;

    @FXML
    private Label msgLabel;

    @FXML
    private Button tableViewButton;
    @FXML
    private void viewAllGames(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "gameTableView.fxml", "Video Game Sales");
    }
}

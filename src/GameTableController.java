import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GameTableController implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private Label titleLabel;

    @FXML
    private TableView<Game> tableView;

    @FXML
    private TableColumn<Game, Integer> iDColumn;

    @FXML
    private TableColumn<Game, String> titleColumn;

    @FXML
    private TableColumn<Game, String> publisherColumn;

    @FXML
    private TableColumn<Game, LocalDate> releaseDateColumn;

    @FXML
    private TableColumn<Game, Double> grossRevenueColumn;

    @FXML
    private TableColumn<Game, Integer> ratingColumn;

    @FXML
    private Button graphViewButton;

    @FXML
    private void viewBarGraph(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "revenueBarGraphView.fxml", "Video Game Sales");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
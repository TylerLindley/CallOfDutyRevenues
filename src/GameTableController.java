import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private TableColumn<Game, Long> grossRevenueColumn;

    @FXML
    private TableColumn<Game, Integer> ratingColumn;

    @FXML
    private Button graphViewButton;

    @FXML
    private Button pieChartButton;

    @FXML
    private void viewBarGraph(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "revenueBarGraphView.fxml", "Video Game Sales");
    }

    @FXML
    private void viewPieChart(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "revenuePieChartView.fxml", "Video Game Sales");
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        iDColumn.setCellValueFactory(new PropertyValueFactory<Game, Integer>("gameID"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("title"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("publisher"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<Game, LocalDate>("releaseDate"));
        grossRevenueColumn.setCellValueFactory(new PropertyValueFactory<Game, Long>("grossRevenue"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<Game, Integer>("rating"));
        try {
            tableView.getItems().addAll(DBUtility.getAllGamesFromDB());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
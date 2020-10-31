import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RevenuePieChartController implements Initializable {

    @FXML
    private Pane paneView;

    @FXML
    private Button barChartButton;

    @FXML
    private Button tableViewButton;

    @FXML
    private void viewAllGames(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "gameTableView.fxml", "Video Game Sales");
    }
    @FXML
    private void viewBarGraph(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "revenueBarGraphView.fxml", "Video Game Sales");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    private void loadData() {
        paneView.getChildren().clear();
        ObservableList<PieChart.Data> list= FXCollections.observableArrayList();
        list.add(new PieChart.Data("Infinity Ward", 151268840));
        list.add(new PieChart.Data("Treyarch", 113200000));
        list.add(new PieChart.Data("Sledgehammer Games", 32880000));
        PieChart callOfDutyRevenuesByPublisher = new PieChart(list);
        callOfDutyRevenuesByPublisher.setLabelsVisible(false);
        paneView.getChildren().add(callOfDutyRevenuesByPublisher);
    }
}

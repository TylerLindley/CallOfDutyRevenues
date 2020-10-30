import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RevenueBarGraphController implements Initializable {

    @FXML
    private BarChart<Game, Integer> barChart;

    @FXML
    private CategoryAxis gameAxis;

    @FXML
    private NumberAxis grossRevenueAxis;

    private XYChart.Series grossRevenueSeries;

    @FXML
    private Button tableViewButton;
    @FXML
    private void viewAllGames(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "gameTableView.fxml", "Video Game Sales");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grossRevenueSeries = new XYChart.Series();

        grossRevenueSeries.getData().add(new XYChart.Data("Call of Duty", 100000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Finest Hour", 200000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Call of Duty 2", 300000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Call of Duty 3", 400000000));
        grossRevenueSeries.getData().add(new XYChart.Data("COD 4", 500000000));
        grossRevenueSeries.getData().add(new XYChart.Data("World at War", 600000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Modern Warfare 2", 700000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Black Ops", 800000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Modern Warfare 3", 900000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Black Ops 2", 1000000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Ghosts", 1100000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Advanced Warfare", 1200000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Black Ops 3", 1300000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Infinte Warfare", 1400000000));
        grossRevenueSeries.getData().add(new XYChart.Data("WW2", 1500000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Black Ops 4", 1600000000));
        grossRevenueSeries.getData().add(new XYChart.Data("Modern Warfare", 1700000000));

        gameAxis.setLabel("Games");
        grossRevenueAxis.setLabel("Total Revenue");
        barChart.getData().addAll(grossRevenueSeries);
    }
}

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
    private Button pieChartButton;

    @FXML
    private void viewAllGames(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "gameTableView.fxml", "Video Game Sales");
    }

    @FXML
    private void viewPieChart(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "revenuePieChartView.fxml", "Video Game Sales");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grossRevenueSeries = new XYChart.Series();

        grossRevenueSeries.getData().add(new XYChart.Data("Call of Duty", 168606594.94));
        grossRevenueSeries.getData().add(new XYChart.Data("Finest Hour", 180000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Call of Duty 2", 224810125.58));
        grossRevenueSeries.getData().add(new XYChart.Data("Call of Duty 3", 266025315.46));
        grossRevenueSeries.getData().add(new XYChart.Data("COD 4", 716000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("World at War", 628000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Modern Warfare 2", 1080000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Black Ops", 1220000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Modern Warfare 3", 1228000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Black Ops 2", 1176000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Ghosts", 1080000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Advanced Warfare", 840000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Black Ops 3", 1336000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Infinite Warfare", 1000000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("WW2", 804000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Black Ops 4", 1300000000.00));
        grossRevenueSeries.getData().add(new XYChart.Data("Modern Warfare", 1620000000.00));

        gameAxis.setLabel("Games");
        grossRevenueAxis.setLabel("Total Revenue: In Dollar Amounts");
        grossRevenueSeries.setName("Revenue: In Dollars");
        barChart.getData().addAll(grossRevenueSeries);
    }
}

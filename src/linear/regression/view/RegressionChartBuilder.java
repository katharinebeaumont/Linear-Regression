package linear.regression.view;

import java.util.ArrayList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import linear.regression.calculations.DataPoint;

/**
 *
 * @author katharine
 */
public class RegressionChartBuilder {
 
    public LineChart build(ArrayList<DataPoint> housePriceData, ArrayList<DataPoint> linearRegressionLine) {
        NumberAxis x_axis = new NumberAxis();
        x_axis.setLabel("Size (square feet)");
        NumberAxis y_axis = new NumberAxis();
        y_axis.setLabel("Price (1000s)");
        
        final LineChart<Number,Number> sc = new LineChart<>(x_axis,y_axis);

        sc.setTitle("Data");
        XYChart.Series series1 = new XYChart.Series();
        
        series1.setName("House Prices");
        for (DataPoint dp: housePriceData) {
            series1.getData().add(new XYChart.Data(dp.getX(), dp.getY()));
        }
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Line of Regression");
        for (DataPoint dp: linearRegressionLine) {
            series2.getData().add(new XYChart.Data(dp.getX(), dp.getY()));
        }
        
        sc.setAnimated(false);
        sc.setCreateSymbols(true);

        sc.getData().addAll(series1, series2);
        return sc;
    }
    
}

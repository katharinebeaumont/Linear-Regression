package linear.regression.view;

import java.util.ArrayList;
import javafx.geometry.Orientation;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import linear.regression.calculations.DataPoint;

/**
 *
 * @author katharine
 */
public class ThetaChartBuilder {
       
    ArrayList<DataPoint> theta_1_values = new ArrayList();
    
    public void addTheta1(double theta, double cost) {
        theta_1_values.add(new DataPoint(theta, cost));
    }
    
    public FlowPane build() {
        
        FlowPane flowTopPortion = new FlowPane(Orientation.HORIZONTAL);
        flowTopPortion.setMaxHeight(600);
        flowTopPortion.setMaxWidth(500);
        flowTopPortion.setMinWidth(500);

        LineChart theta1 = buildChart(theta_1_values,  "\u03B8" + "1");
        flowTopPortion.getChildren().add(theta1);
        return flowTopPortion;
        
    }

    private LineChart buildChart(ArrayList<DataPoint> theta_values, String xlabel) {
        NumberAxis x_axis = new NumberAxis();
        x_axis.setLabel(xlabel);
        NumberAxis y_axis = new NumberAxis();
        y_axis.setLabel("Cost");
        final LineChart<Number,Number> sc = new LineChart<>(x_axis,y_axis);
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(xlabel);
        for (DataPoint dp: theta_values) {
            series1.getData().add(new XYChart.Data(dp.getX(), dp.getY()));
        }
        
        sc.setAnimated(false);

        sc.getData().addAll(series1);
        
        sc.setTitle("How \u03B81 changes the Cost");
        
        sc.setMaxHeight(600);
        sc.setPrefHeight(600);
        sc.setMaxWidth(500);
        return sc;
    }
}


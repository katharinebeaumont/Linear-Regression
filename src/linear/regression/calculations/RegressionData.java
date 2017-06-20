package linear.regression.calculations;

import java.util.ArrayList;

/**
 *
 * @author katharine
 */
public class RegressionData {
   
    public ArrayList<DataPoint> generateRegressionDataPoints(ArrayList<Double> theta) {
        ArrayList<DataPoint> dataPoints = new ArrayList();
        ArrayList<Double> inputData = HousePriceData.getX();

        for (Double x : inputData) {
            double y = 0;
            for (int i=0; i<theta.size(); i++) {
                if (i == 0) {
                    y = y + theta.get(i);
                } else {
                    y = y + (x*theta.get(i));
                }
            }
            
            dataPoints.add(new DataPoint(x,y));
        }
        return dataPoints;
    }
    
    public ArrayList<DataPoint> generateRegressionDataPointsForGraph(ArrayList<Double> theta) {
        ArrayList<DataPoint> dataPoints = generateRegressionDataPoints(theta);
        
        //Add a dummy data point for drawing the graph
        dataPoints.add(0, new DataPoint(0, theta.get(0)));
        
        return dataPoints;
    }
}

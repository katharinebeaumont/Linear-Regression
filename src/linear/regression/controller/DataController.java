package linear.regression.controller;

import java.util.ArrayList;
import linear.regression.calculations.CostFunction;
import linear.regression.calculations.DataPoint;
import linear.regression.calculations.GradientDescentStep;
import linear.regression.calculations.HousePriceData;
import linear.regression.calculations.RegressionData;

/**
 *
 * @author katharine
 */
public class DataController {
    
    private ArrayList<Double> theta;
    
    public DataController(Double theta1) {
        theta = new ArrayList();
        theta.add(-10.0);
        theta.add(theta1);
    }
    
    public ArrayList<DataPoint> getHousePriceData() {
        return HousePriceData.getData();
    }
    
    public ArrayList<DataPoint> getLinearRegressionLine() {
        RegressionData rd = new RegressionData();
        return rd.generateRegressionDataPoints(theta);
    }
    
    public ArrayList<DataPoint> getLinearRegressionLineForGraph() {
        RegressionData rd = new RegressionData();
        return rd.generateRegressionDataPointsForGraph(theta);
    }
    
    public double getCost() {
        CostFunction cf = new CostFunction();
        return cf.getCost(getHousePriceData(), getLinearRegressionLine());
    }
    
    public ArrayList<Double> takeGradientDescentStep(double alpha) {
        return GradientDescentStep.getNewTheta(getHousePriceData(), getLinearRegressionLine(), theta, alpha);
    }
}

package linear.regression.calculations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author katharine
 */
public class GradientDescentStep {

    public static ArrayList<Double> getNewTheta(ArrayList<DataPoint> housePrices, ArrayList<DataPoint> predictions, ArrayList<Double> theta, double alpha) {
        System.out.println("Taking step with alpha: " + alpha);
        List<Double> deltas = getDeltas(housePrices, predictions);
        ArrayList<Double> newThetas = new ArrayList();
        for (int i=0; i<theta.size(); i++) {
            double new_theta = theta.get(i) - (alpha * deltas.get(i));
            newThetas.add(new_theta);
        }
        System.out.println("New theta values are: " + newThetas);
        return newThetas;
    }
    
    public static List<Double> getDeltas(ArrayList<DataPoint> housePrices, ArrayList<DataPoint> predictions) {
        
        int m = housePrices.size();
        double sum_theta_0 = 0;
        double sum_theta_1 = 0;
        
        for (int i=0; i<m; i++) {
            double difference = predictions.get(i).getY() - housePrices.get(i).getY();
            sum_theta_0 = sum_theta_0 + difference;
            sum_theta_1 = sum_theta_1 + (difference * housePrices.get(i).getX());
        }
        
        double delta_theta_0 = sum_theta_0/(double)m;
        double delta_theta_1 = sum_theta_1/(double)m;
        System.out.println("Delta for theta 0 is " + delta_theta_0);
        System.out.println("Delta for theta 1 is " + delta_theta_1);
        return Arrays.asList(delta_theta_0, delta_theta_1);
    }
        
}

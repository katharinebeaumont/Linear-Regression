package linear.regression.calculations;

import java.util.ArrayList;

/**
 *
 * @author katharine
 */
public class CostFunction {
    
    public double getCost(ArrayList<DataPoint> housePrices, ArrayList<DataPoint> predictions) {
        
        double m = (double)housePrices.size();
        double sum_over_examples = 0;
        for (int i=0; i<m; i++) {
            double difference = predictions.get(i).getY() - housePrices.get(i).getY();
            double sqaure_difference = Math.pow(difference, 2);
            sum_over_examples = sum_over_examples + sqaure_difference;
        }
        double averaging_factor = 1 / (2*m);
        return sum_over_examples * averaging_factor;
    }
}

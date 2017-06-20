/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linear.regression.calculations;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author katharine
 */
public class HousePriceData {
 
    private static final ArrayList<DataPoint> data = readInData();
    
    public static ArrayList<DataPoint> getData() {
        return data;
    }
      
    public static ArrayList<Double> getX() {
        ArrayList<Double> x = new ArrayList();
        for (DataPoint pair: data) {
            x.add(pair.getX());
        }
        return x;
    }
    
    public static ArrayList<Double> getY() {
        ArrayList<Double> y = new ArrayList();
        for (DataPoint pair: data) {
            y.add(pair.getY());
        }
        return y;
    }

    private static ArrayList<DataPoint> readInData() {
        
        ArrayList houseData = new ArrayList<>();
        List<String> lines = new ArrayList();
        try {
            lines = Files.readAllLines(Paths.get("src/resources/housePriceData.csv"), Charset.defaultCharset());
        } catch (IOException io) {
            System.out.println("problem loading file: " + io);
        }
        System.out.println("Reading in housePriceData.csv.");
        for (String line : lines) {
            System.out.println("Data is: " + line);
            int comma = line.indexOf(",");
            String x = line.substring(0, comma);
            String y = line.substring(comma+1);
            double x_db = new Double(x)/10;
            DataPoint pair = new DataPoint(x_db,new Double(y));
            houseData.add(pair);
        }
        return houseData;
    }
    
}

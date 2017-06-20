package linear.regression;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import linear.regression.controller.DataController;
import linear.regression.view.RegressionChartBuilder;
import linear.regression.view.ThetaChartBuilder;

/**
 *
 * @author katharine
 * Written in a hurry. Needs refactoring. 
 * Don't read this code. It's not pretty.
 */
public class LinearRegression extends Application {
    
    DataController controller;
    ThetaChartBuilder builder;
    
    private final double initial_theta_1 = 1;
    private final double initial_alpha = 2;
    private final int SCREEN_HEIGHT = 800;
    private final int SCREEN_WIDTH = 1000;
    
    private BorderPane bp;
    private FlowPane flowSliders;
    private Label costFunction;
    private final String green_background = "-fx-background-color: #a5ea8a;";
    
    private final SpinnerValueFactory.DoubleSpinnerValueFactory theta_1_spinner = new SpinnerValueFactory.DoubleSpinnerValueFactory(-1.0, 3, initial_theta_1, 0.05);
    private final Slider alpha_slider = new Slider(0, (initial_alpha*2), initial_alpha);  

    private Spinner theta_1 = new Spinner(theta_1_spinner);
        
        
    @Override
    public void start(Stage primaryStage) {
        controller = new DataController(initial_theta_1);
        builder = new ThetaChartBuilder();
        bp = new BorderPane();
        builder.addTheta1(initial_theta_1, controller.getCost());
        
        Button btn = new Button();
        btn.setText("Reset");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                reset();
            }
        });
        
        Button btnGD = new Button();
       
        btnGD.setText("Take gradient descent step");
        btnGD.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                    System.out.println("Taking step");
                    takeStep();
                }
        });
        
        FlowPane flowTopPortion = new FlowPane(Orientation.VERTICAL);
        flowTopPortion.setMaxHeight(100);
        flowTopPortion.setMaxWidth(SCREEN_WIDTH*0.6);
        flowTopPortion.setMinWidth(SCREEN_WIDTH*0.6);
        flowTopPortion.setStyle(green_background);
        FlowPane flowButtons = new FlowPane(Orientation.HORIZONTAL);
        flowButtons.setMaxWidth(SCREEN_WIDTH*0.6);
        flowButtons.setMinWidth(SCREEN_WIDTH*0.6);
        HBox hboxButton = new HBox();
        hboxButton.setPadding(new Insets(5, 2, 5, 2));
        HBox hboxTheta1Button = new HBox();
        hboxTheta1Button.setPadding(new Insets(5, 2, 5, 2));
        hboxButton.getChildren().add(btn);
        
        HBox hboxGradDescentButton = new HBox();
        hboxGradDescentButton.setPadding(new Insets(5, 2, 5, 2));
        
        hboxGradDescentButton.getChildren().add(btnGD);
        flowButtons.getChildren().addAll(hboxButton, hboxTheta1Button, hboxGradDescentButton);
        
        flowSliders = new FlowPane(Orientation.HORIZONTAL);
        flowSliders.setPrefWidth(SCREEN_WIDTH);
        buildSpinners();
        
        flowTopPortion.getChildren().addAll(flowButtons, flowSliders);
        
        FlowPane costImage = new FlowPane(Orientation.VERTICAL);
        costImage.setMaxHeight(100);
        costImage.setMaxWidth(SCREEN_WIDTH*0.4);
        costImage.setMinWidth(SCREEN_WIDTH*0.4);
        costImage.setStyle(green_background);
        HBox boxCostImg = new HBox();
        boxCostImg.setPadding(new Insets(5, 5, 5, 5));
        
        String path = "/resources/cost.png";
        ImagePattern costImg = new ImagePattern(new Image(path));
        Rectangle r = new Rectangle(300,70);
        r.setFill(costImg);
        boxCostImg.getChildren().addAll(r);
        costFunction = new Label();
        costFunction.setMinSize(50, btn.getHeight());
        double cost = controller.getCost();
        costFunction.setText( "Cost is " + String.format("%.2f", cost));
        
        costImage.getChildren().addAll(boxCostImg, costFunction);
        
        BorderPane topSection = new BorderPane();
        topSection.setLeft(flowTopPortion);
        topSection.setRight(costImage);
        bp.setTop(topSection);
        
        buildRegressionChart();
        buildThetaChart();
         
        StackPane root = new StackPane();
        root.getChildren().add(bp);
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        
        scene.getStylesheets().add("/resources/regression.css");
                
        primaryStage.setTitle("Linear Regresion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void buildSpinners() {
        
        HBox hboxTheta1 = new HBox();
        hboxTheta1.setPadding(new Insets(2, 5, 2, 5));

        theta_1_spinner.valueProperty().addListener((
            ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) -> {
                resetRegressionLine();
                resetThetaChart();
        });
        
        final Label theta_1_desc = new Label("\u03B81 (gradient)");
        theta_1.setMaxWidth(100);
        
        hboxTheta1.getChildren().addAll(theta_1);
        
        HBox hboxAlpha = new HBox();
        hboxAlpha.setPadding(new Insets(5, 5, 5, 5));
        
        alpha_slider.setShowTickLabels(true);
        alpha_slider.setShowTickMarks(true);
        alpha_slider.setMajorTickUnit(0.0001);
        alpha_slider.setPrefWidth(200);
        final Label alpha_value_label = new Label();
        alpha_value_label.setText(String.format(" %.4f ", initial_alpha));
        
        alpha_slider.valueProperty().addListener((
            ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) -> {
                alpha_value_label.setText(String.format("%.4f", new_val));
        });
        hboxAlpha.getChildren().addAll(alpha_slider);
        final Label alpha_desc = new Label(" Learning Rate ");
        
        flowSliders.getChildren().addAll(hboxTheta1, theta_1_desc, hboxAlpha, alpha_value_label, alpha_desc);
    }

    private void resetRegressionLine() {
        double new_theta_1 = theta_1_spinner.getValue();
        controller = new DataController(new_theta_1);
        
        Node centre = bp.getCenter();
        bp.getChildren().remove(centre);
        
        buildRegressionChart();
    }   
    
    private void resetThetaChart() {
        
        Node right = bp.getRight();
        bp.getChildren().remove(right);
        double new_theta_1 = theta_1_spinner.getValue();
        builder.addTheta1(new_theta_1, controller.getCost());
        
        buildThetaChart();
    }
    
    private void reset() {
        controller = new DataController(initial_theta_1);
        builder = new ThetaChartBuilder();
        Node centre = bp.getCenter();
        bp.getChildren().remove(centre);
        theta_1_spinner.setValue(initial_theta_1);
        buildRegressionChart();
        buildThetaChart();
    }
    
    private void buildRegressionChart() {
        RegressionChartBuilder lg = new RegressionChartBuilder();
        LineChart lc = lg.build(controller.getHousePriceData(), controller.getLinearRegressionLineForGraph());
        lc.setMaxSize(SCREEN_WIDTH/2, 600);
        lc.setPrefSize(SCREEN_WIDTH/2, 600);
        bp.setCenter(lc);
        
        double cost = controller.getCost();
        costFunction.setText( "Cost is " + String.format("%.2f", cost));
    }

    private void buildThetaChart() {
        FlowPane lc = builder.build();
        lc.setMaxSize(SCREEN_WIDTH/2, 600);
        lc.setPrefSize(SCREEN_WIDTH/2, 600);
        bp.setRight(lc);
    }
    
    private void takeStep() {
        double alpha = alpha_slider.getValue() / 10000;
        ArrayList<Double> thetas = controller.takeGradientDescentStep(alpha);
        theta_1_spinner.setValue(thetas.get(1));
        resetRegressionLine();
        resetThetaChart();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

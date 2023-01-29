import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

class ScatterChartSample extends Application {
    @Override public void start(Stage stage) {
        stage.setTitle("Scatter Chart Sample");
        final NumberAxis xAxis = new NumberAxis(0, 100, 1);
        final NumberAxis yAxis = new NumberAxis(0, 100, 1);        
        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);       
        sc.setTitle("Ulam Spiral");
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Prime Numbers");
        series1.getData().add(new XYChart.Data(4.2, 193.2));
 
        sc.getData().addAll(series1);
        Scene scene  = new Scene(sc, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
}

class UlamSpiral{

    public static void main(String args){
        int step_size = 1;
        int num_step = 1;
        int number = 1;
        int state = 0;
        int x = 0;
        int y = 0;
        int turn_counter = 0;
        int x0;
        int y0;
        boolean pnp;
        int[][] arr = new int[10][20];
        int count = 0;
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        while(number<=num){
            x0 = x;
            y0 = y;
            switch(state){
                case 0: x += step_size;
                case 1: y -= step_size;
                case 2: x -= step_size;
                default: y += step_size;
            }
            if(number % num_step == 0){
                state = (state + 1) % 4;
                turn_counter = turn_counter + 1;
                if(turn_counter % 2 == 0){
                    num_step = num_step + 1;
                }
            }
            number = number + 1;
            pnp = isprime(number);
            if(pnp){
                arr[count][0] = x;
                arr[count][1] = y;
                count++;
            }
        }

	}

    static boolean isprime(int num){
        boolean out = true;
        for(int i=2; i<=num; i++){
            if(num%i==0){
                out = false;
                break;
            }
        }
        return out;
    }
}
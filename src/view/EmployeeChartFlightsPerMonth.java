/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FlightController;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Chems
 */
public class EmployeeChartFlightsPerMonth extends JPanel{
    
    public EmployeeChartFlightsPerMonth() {
        
        super();
        DefaultCategoryDataset datasett = new DefaultCategoryDataset();  
        
        datasett.addValue(FlightController.getCountMonth(1), "Full flights", "January");  
        datasett.addValue(FlightController.getCountMonth(2), "Full flights", "February");  
        datasett.addValue(FlightController.getCountMonth(3), "Full flights", "Mars");  
        datasett.addValue(FlightController.getCountMonth(4), "Full flights", "April");  
        datasett.addValue(FlightController.getCountMonth(5), "Full flights", "May");  
        datasett.addValue(FlightController.getCountMonth(6), "Full flights", "June"); 
        datasett.addValue(FlightController.getCountMonth(7), "Full flights", "July");  
        datasett.addValue(FlightController.getCountMonth(8), "Full flights", "August");  
        datasett.addValue(FlightController.getCountMonth(9), "Full flights", "September"); 
        datasett.addValue(FlightController.getCountMonth(10), "Full flights", "October");  
        datasett.addValue(FlightController.getCountMonth(11), "Full flights", "November");  
        datasett.addValue(FlightController.getCountMonth(12), "Full flights", "December");
        
        CategoryDataset dataset = datasett;
        JFreeChart chart = ChartFactory.createBarChart("Number of flights according to month of the year", "Month", "Number of flights", dataset);

        ChartPanel panel = new ChartPanel(chart);
        
        //setSize(1920, 1080);
        add(panel);
        
    }
    
    
    
}

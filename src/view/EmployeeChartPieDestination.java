/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DataAcessObjectImpl.FlightDAOImpl;
import controller.AirportController;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Chems
 */
public class EmployeeChartPieDestination extends JPanel {
    
    public EmployeeChartPieDestination() {
        
        super();
        DefaultPieDataset datasett = new DefaultPieDataset();
        for(int i=0 ; i < AirportController.findPercentageAllAirports().size() ; ++i) {
            datasett.setValue(AirportController.findAllAirportNames().get(i), AirportController.findPercentageAllAirports().get(i).intValue());
        }
        /*
        datasett.setValue("Croatia", 22);
        datasett.setValue("Bohemia", 34);
        datasett.setValue("Bulgaria", 18);
        datasett.setValue("Spain", 5);
        datasett.setValue("Others", 21);*/

        JFreeChart chart = ChartFactory.createPieChart("Popular destinations",
                datasett, true, true, true);
  
        
        //CategoryDataset dataset = datasett;
        /*JFreeChart areaChart = ChartFactory.createAreaChart(
                "JFreeChart Area Chart", // Chart title
                "Time", // X-Axis Label
                "Popularity", // Y-Axis Label
                datasett // Dataset for the Chart
                );*/

        ChartPanel panel = new ChartPanel(chart);
        
        //setSize(1920, 1080);
        this.add(panel);
        
    }
    
}

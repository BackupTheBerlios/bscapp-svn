////////////////////////////////////////////////////////////////
// AppletsInApplet.java
////////////////////////////////////////////////////////////////

package com.objectplanet.chart.examples;

import com.objectplanet.chart.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/**
 * This demonstrates how to use the chart applets within another applet.
 * @author Bjorn J. Kvande.
 */
public class AppletsInApplet extends Applet implements Runnable, ActionListener {
	
	
	private ChartApplet barChart;
	private ChartApplet lineChart;
	private ChartApplet pieChart;
	private Button startButton;
	private Button stopButton;
	private TextField delayField;
	private int delay;
	private Thread scrollThread;
	private boolean started;
	
	
	/**
	 * Creates the applets.
	 */
	public AppletsInApplet() {
		// create the chart applets
		Panel charts = new Panel();
		charts.setLayout(new GridLayout(0,3));
		barChart = new ChartApplet("bar");
		barChart.setParentApplet(this);
		barChart.setParameterPrefix("bar_");
		charts.add(barChart);
		
		lineChart = new ChartApplet("line");
		lineChart.setParentApplet(this);
		lineChart.setParameterPrefix("line_");
		charts.add(lineChart);

		pieChart = new ChartApplet("pie");
		pieChart.setParentApplet(this);
		pieChart.setParameterPrefix("pie_");
		charts.add(pieChart);
		
		// add the charts and the start and stop buttons
		setLayout(new BorderLayout());
		add("Center", charts);
		Panel control = new Panel();
		control.setBackground(Color.lightGray);
		delayField = new TextField(5);
		control.add(new Label("update delay"));
		control.add(delayField);
		startButton = new Button("start");
		startButton.addActionListener(this);
		control.add(startButton);
		stopButton = new Button("stop");
		stopButton.addActionListener(this);
		control.add(stopButton);
		add("South", control);
	}
	
	
	/**
	 * Reads the data.
	 */
	public void init() {
		// read the chart applet parameters
		barChart.init();
		lineChart.init();
		pieChart.init();
		
		// set the update delay
		delayField.setText("500");
		String value = getParameter("delay");
		if (value != null) {
			delayField.setText(value);
		}
	}
	
	
	/**
	 * Starts or stops the data scrolling.
	 */
	public void actionPerformed(ActionEvent e) {
		// start thread
		if (e.getSource() == startButton && !started) {
			delay = 500;
			try {
				delay = Integer.parseInt(delayField.getText().trim());
			} catch (NumberFormatException ex) {
				delay = 500;
				delayField.setText("500");
			}
			scrollThread = new Thread(this);
			started = true;
			scrollThread.start();
		}
		
		// stop thread
		else if (e.getSource() == stopButton && started) {
			started = false;
			scrollThread = null;
		}
	}
	
	
	/**
	 * Scrolls data.
	 */
	public void run() {
		while (started) {
			try {
				Thread.sleep(delay);
				barChart.chart.appendSampleValue(0, barChart.chart.getSampleValue(0,0), false);
				lineChart.chart.appendSampleValue(0, lineChart.chart.getSampleValue(0,0), false);
				pieChart.chart.appendSampleValue(0, pieChart.chart.getSampleValue(0,0), false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;
import java.awt.event.*;


/**
 * This example catches sample selection events.
 * @author Bjorn J. Kvande.
 */
public class SelectionEventChart implements ItemListener {

	/**
	 * Prints the selected or deselected sample.
	 */
	public void itemStateChanged(ItemEvent e) {
		switch (e.getStateChange()) {
			case ItemEvent.SELECTED:
				ChartSample sample = (ChartSample) e.getItem();
				System.out.println("SELECTED: " + sample);
				break;
			case ItemEvent.DESELECTED:
				sample = (ChartSample) e.getItem();
				System.out.println("DESELECTED: " + sample);
				break;
		}
	}
	
	public static void main(String[] argv) {
		// create the chart
		double[] values = new double[10];
		for (int i = 0; i < values.length; i++) {
			values[i] = Math.round(Math.random()*100);
		}
		BarChart chart = new BarChart();
		chart.setSampleCount(values.length);
		chart.setSampleValues(0, values);
		chart.setValueLinesOn(true);
		chart.addItemListener(new SelectionEventChart());
		
		// display the chart
		Frame f = new Frame();
		f.add("Center", chart);
		f.setSize(400,300);
		f.show();
	}
}
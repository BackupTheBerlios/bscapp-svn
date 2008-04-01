package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;
import javax.swing.*;


/**
 * This example shows how to use a chart in a swing scroll pane.
 * @author Bjorn J. Kvande.
 */
public class SwingChart {

	public static void main(String[] argv) {
		// create the chart
		LineChart chart = new LineChart();
		double[] values = new double[] {86,5,46,9,87,6,46,9,77,6};
		chart.setSampleCount(values.length);
		chart.setSampleValues(0, values);
		chart.setRangeAdjusterOn(0, true);
		chart.setSampleScrollerOn(true);
		chart.setSampleHighlightOn(true);
		chart.setSampleHighlightStyle(LineChart.SAMPLE_HIGHLIGHT_CIRCLE_FILLED, 10);
		chart.setValueLabelsOn(true);
		
		JPanel panel = new JPanel(true);
		panel.setLayout(new BorderLayout());
		panel.add("Center", chart);
		panel.setPreferredSize(new Dimension(300,300));
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setDoubleBuffered(true);
		
		// display the chart
		JFrame f = new JFrame();
		f.getContentPane().add("Center", scroll);
		f.setSize(300,300);
		f.show();
	}
}

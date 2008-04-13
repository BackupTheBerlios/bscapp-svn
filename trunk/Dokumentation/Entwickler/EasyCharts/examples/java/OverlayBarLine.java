package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;


/**
 * This tests the bar chart component.
 *
 * @author Bjorn J. Kvande.
 */
public class OverlayBarLine {

	public static void main(String[] argv) {
		// create primary chart
		BarChart chart = new BarChart();
		chart.setSampleCount(7);
		chart.setSampleValues(0, new double[] {87,68,72,73,59,74,36});
		chart.setRelativeRange(1, 100);
		chart.setRangeAdjusterOn(0, true);
		chart.setValueLinesOn(true);
		chart.setTitle("BarChart with LineChart overlay");
		chart.setTitleOn(true);

		// create overlay chart
		LineChart overlay = new LineChart();
		overlay.setSampleCount(chart.getSampleCount());
		overlay.setSampleValues(0, chart.getSampleValues(0));
		overlay.setRelativeRange(2, 10);
		overlay.setSampleColor(0, Color.red);
		overlay.setSampleHighlightOn(true);
		overlay.setSampleHighlightStyle(LineChart.SAMPLE_HIGHLIGHT_CIRCLE_OPAQUE, 20);
		overlay.setValueLabelsOn(true);
		overlay.setValueLabelStyle(LineChart.INSIDE);
		
		// add overlay chart
		chart.addOverlayChart(overlay);

		com.objectplanet.chart.NonFlickerPanel p = new com.objectplanet.chart.NonFlickerPanel(new BorderLayout());
		p.add("Center", chart);
		Frame f = new Frame();
		f.add("Center", p);
		f.setSize(400,300);
		f.show();
	}
}
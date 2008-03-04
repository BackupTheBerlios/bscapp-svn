package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;
import java.awt.*;

public class OverlayLineBar {
	public static void main(String[] argv) {
		// create primary chart
		LineChart chart = new LineChart();
		chart.setSampleCount(7);
		chart.setSampleValues(0, new double[] {87,68,72,73,59,74,36});
		chart.setRelativeRange(1, 200);
		chart.setRangeAdjusterOn(0, true);
		chart.setValueLinesOn(true);
		chart.setTitle("LineChart with\nBarChart/LineChart overlay");
		chart.setTitleOn(true);
		chart.setStackedOn(true);

		// create overlay chart
		BarChart overlay = new BarChart();
		overlay.setSampleCount(chart.getSampleCount());
		overlay.setSampleValues(0, chart.getSampleValues(0));
		overlay.setRelativeRange(1,100);
		overlay.setSampleColor(0, Color.red);
		overlay.setValueLabelsOn(true);
		
		// create overlay chart
		LineChart overlay2 = new LineChart();
		overlay2.setSampleCount(chart.getSampleCount());
		overlay2.setSampleValues(0, chart.getSampleValues(0));
		overlay2.setRelativeRange(2,100);
		overlay2.setSampleColor(0, Color.orange);
		
		// add overlay chart
		chart.addOverlayChart(overlay);
		chart.addOverlayChart(overlay2);

		com.objectplanet.chart.NonFlickerPanel p = new com.objectplanet.chart.NonFlickerPanel(new BorderLayout());
		p.add("Center", chart);
		Frame f = new Frame();
		f.add("Center", p);
		f.setSize(400,300);
		f.show();
	}
}
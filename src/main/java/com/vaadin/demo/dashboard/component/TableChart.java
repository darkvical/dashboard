package com.vaadin.demo.dashboard.component;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.addon.charts.Chart;
import com.vaadin.demo.dashboard.graphic.ExampleChart;
import com.vaadin.ui.Table;

public class TableChart extends Table{
	private static final long serialVersionUID = -8583496346673185404L;

	public TableChart() {
		setSizeFull();
		definirTabla();
		cargarTabla();
	}

	private void cargarTabla() {
		addItem(new Object[]{"Victor", new ExampleChart(), new ExampleChart()}, 1);
		addItem(new Object[]{"Victor", new ExampleChart(), new ExampleChart()}, 2);
	}

	private void definirTabla() {
		addContainerProperty("Nombre", String.class, StringUtils.EMPTY);
		addContainerProperty("Cuadro 1", Chart.class, null);
		addContainerProperty("Cuadro 2", Chart.class, null);
	}
}

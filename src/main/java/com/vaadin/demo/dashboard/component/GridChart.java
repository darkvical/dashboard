package com.vaadin.demo.dashboard.component;

import com.vaadin.demo.dashboard.graphic.ExampleChart;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;

public class GridChart extends Grid {
	private static final long serialVersionUID = -3637371368333269527L;
	
	public GridChart() {
		setCaption("Tabla con graficos");
		setSizeFull();
	    setEditorEnabled(true);
	    setSelectionMode(SelectionMode.NONE);
	    agregarColumnas();
	    cargarTabla();
	    
	}

	private void cargarTabla() {
		HorizontalLayout layout = new HorizontalLayout();
		layout.addComponent(new ExampleChart());
//		addRow("Vical", layout);
	}

	private void agregarColumnas() {
		addColumn("Nombre", String.class);
//		addColumn("Grafico", HorizontalLayout.class).setRenderer(com.vaadin.ui.renderers.);
	}
}

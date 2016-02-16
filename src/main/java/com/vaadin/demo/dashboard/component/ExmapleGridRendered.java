package com.vaadin.demo.dashboard.component;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.demo.dashboard.domain.Movie;
import com.vaadin.demo.dashboard.graphic.LineChart;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.DetailsGenerator;
import com.vaadin.ui.Grid.RowReference;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import de.datenhahn.vaadin.componentrenderer.grid.ComponentGenerator;
import de.datenhahn.vaadin.componentrenderer.grid.ComponentGrid;



public class ExmapleGridRendered extends VerticalLayout {
	private static final long serialVersionUID = -2904989337712745031L;
	
	private static final String DESCRIPTION = "description";
	private static final String OCULTAR_DETALLE = "Ocultar detalle";
	private static final String MOSTRAR_DETALLE = "Mostrar detalle";
	
    public ExmapleGridRendered() {
    	setCaption("Ejemplo de grid");
    	setWidth("100%");
    	setHeight("100%");
    	
    	final ComponentGrid<Movie> gridMovie = new ComponentGrid<Movie>(Movie.class);
    	gridMovie.setWidth("100%");
    	gridMovie.setHeight(70, Unit.PERCENTAGE);
    	gridMovie.setSelectionMode(SelectionMode.MULTI);
    	
    	BeanItemContainer<Movie> container = new BeanItemContainer<Movie>(Movie.class, createDummyDataMovie());
    	gridMovie.setContainerDataSource(container);
    	gridMovie.setRows(createDummyDataMovie());
    	gridMovie.removeColumn("id");
    	gridMovie.removeColumn("thumbUrl");
    	gridMovie.removeColumn("duration");
    	gridMovie.removeColumn("releaseDate");
    	gridMovie.removeColumn("score");
    	
    	gridMovie.setDetailsGenerator(new DetailsGenerator() {
			private static final long serialVersionUID = -6333893946204211970L;

			@Override
			public Component getDetails(RowReference rowReference) {
				VerticalLayout layout = new VerticalLayout();
	            layout.setHeight(220, Unit.PIXELS);
//	            layout.addComponent(new Label("HOLA MUNDO"));
				layout.addComponent(new LineChart());
	            return layout;
			}
		});
    	
    	Grid grid = new Grid(container);
    	grid.setSelectionMode(SelectionMode.NONE);
    	grid.setColumnOrder("title");
    	grid.setWidth("100%");
    	grid.setHeight("100%");
    	grid.removeColumn("id");
    	grid.removeColumn("thumbUrl");
    	grid.removeColumn("duration");
    	grid.removeColumn("releaseDate");
    	grid.removeColumn("score");
        
    	gridMovie.addComponentColumn(DESCRIPTION, new ComponentGenerator<Movie>() {
			private static final long serialVersionUID = -925831315469729051L;
			@Override
			public Component getComponent(final Movie movie) {
				final Button btnDetail = new Button();
				btnDetail.setDescription(MOSTRAR_DETALLE);
				btnDetail.setIcon(FontAwesome.ANDROID);
				btnDetail.addClickListener(new ClickListener() {
					private static final long serialVersionUID = 822467445810254145L;
					@Override
					public void buttonClick(ClickEvent event) {
						if(btnDetail.getDescription().equals(MOSTRAR_DETALLE)){
							btnDetail.setDescription(OCULTAR_DETALLE);
							gridMovie.setDetailsVisible(movie, true);
						} else {
							btnDetail.setDescription(MOSTRAR_DETALLE);
							gridMovie.setDetailsVisible(movie, false);
						}
					}
				});
				return btnDetail;
			}
		});
//    	addComponent(grid);
    	addComponent(gridMovie);
    }

	private List<Movie> createDummyDataMovie() {
		List<Movie> movies = new ArrayList<Movie>();
		for(int i = 1; i < 50; i++){
			Movie movie = new Movie();
			movie.setId(Long.valueOf("" + i));
			movie.setTitle("Pelicula");
			movie.setSynopsis("Muy buena");
			movie.setPosterUrl("vical.com");
			movies.add(movie);
		}
		return movies;
	}
}
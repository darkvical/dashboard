package com.vaadin.demo.dashboard.component;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.vaadin.polymer.paper.widget.PaperInput;
import com.vaadin.polymer.paper.widget.PaperMaterial;
import com.vaadin.polymer.vaadin.widget.VaadinGrid;

public class ExmaplePolymer extends Composite {

    interface MyUiBinder extends UiBinder<HTMLPanel, ExmaplePolymer> {
    }

    private static MyUiBinder myUiBinder = GWT.create(MyUiBinder.class);

    @UiField VaadinGrid grid;
    @UiField PaperMaterial info;
    @UiField ImageElement img;
    @UiField SpanElement txt;
    @UiField PaperInput filter;

    public ExmaplePolymer() {
        initWidget(myUiBinder.createAndBindUi(this));

        // info and filter will be used later.
        info.removeFromParent();
        filter.removeFromParent();
//        Polymer.
    }
}
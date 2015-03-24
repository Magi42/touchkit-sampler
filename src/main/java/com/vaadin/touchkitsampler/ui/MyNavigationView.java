package com.vaadin.touchkitsampler.ui;

import com.vaadin.addon.touchkit.ui.NavigationBar;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Toolbar;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MyNavigationView extends NavigationView {

    public MyNavigationView(MainView mainview) {
        setCaption("Navigation View");
        
        VerticalLayout content = new VerticalLayout();
        content.setMargin(true);
        content.addComponent(new Label("This view features a customized "
                + "navigation bar and a toolbar"));
        
        // Customize the navigation bar at top of the view
        NavigationBar navbar = getNavigationBar();
        
        // Navigate to another view instead of back to main view,
        // which would be the default button behavior
        navbar.setLeftComponent(new NavigationButton(new FormView()));
        
        // This navigates back to the main view - usually the default
        // for the back button
        navbar.setRightComponent(new NavigationButton(mainview));
        
        // Have a tool bar at the bottom
        Toolbar toolbar = new Toolbar();
        toolbar.addComponent(new Button("Mercury",
                new ThemeResource("img/planets/Mercury_symbol.png")));
        toolbar.addComponent(new Button("Venus",
                new ThemeResource("img/planets/Venus_symbol.png")));
        toolbar.addComponent(new Button("Earth",
                new ThemeResource("img/planets/Earth_symbol.png")));
        setToolbar(toolbar);
        
        setContent(content);
    }

}

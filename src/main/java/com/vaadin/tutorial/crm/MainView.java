package com.vaadin.tutorial.crm;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;


@Route
@StyleSheet("css/styles.css")
public class MainView extends VerticalLayout {

    public MainView() {

        // header
        Icon drawer = VaadinIcon.MENU.create();
        Span appTitle = new Span("My Application");
        Icon help = VaadinIcon.QUESTION_CIRCLE.create();
        HorizontalLayout header = new HorizontalLayout(drawer, appTitle, help);
        header.expand(appTitle);
        header.setPadding(true);
        header.setWidth("100%");

        // workspace
        VerticalLayout workSpace = new VerticalLayout();
        workSpace.addClassName("workspace");
        workSpace.setSizeFull();

        // footer
        Tab actionButton1 = new Tab(VaadinIcon.HOME.create(), new Span("Home"));
        Tab actionButton2 = new Tab(VaadinIcon.USERS.create(), new Span("Customers"));
        Tab actionButton3 = new Tab(VaadinIcon.PACKAGE.create(), new Span("Products"));
        actionButton1.setClassName("tab");
        actionButton2.setClassName("tab");
        actionButton3.setClassName("tab");
        Tabs buttonBar = new Tabs(actionButton1, actionButton2, actionButton3);
        HorizontalLayout footer = new HorizontalLayout(buttonBar);
        footer.setJustifyContentMode(JustifyContentMode.CENTER);
        footer.setWidth("100%");

        // menu
        VerticalLayout sideMenu = new VerticalLayout();
        sideMenu.addClassName("sideMenu");
        sideMenu.setHeight("100%");
        sideMenu.setWidth("auto");
        sideMenu.setSpacing(false);
        drawer.getElement().addEventListener("click", ev -> sideMenu.getStyle().set("left", "0px"));
        Icon avatar = VaadinIcon.USER.create();
        avatar.setSize("4em");
        sideMenu.add(avatar, new Span("Meqdad"), createMenuOption("User Profile"), createMenuOption("Configuration"), createMenuOption("About"));
        sideMenu.setAlignItems(Alignment.CENTER);

        // main container
        setSizeFull();
        setMargin(false);
        setSpacing(false);
        setPadding(false);
        add(sideMenu, header, workSpace, footer);
    }

    private Button createMenuOption(String title) {
        Button button = new Button(title);
        button.setWidth("100%");
        button.addClickListener(event -> button.getElement().getParent().getStyle().set("left", "-1000px"));
        button.addClickListener(event -> Notification.show("Button " + title + " Clicked!"));
        return button;
    }

    private Component createCard(){
        Span cardLabel = new Span("Card");
        FlexLayout card = new FlexLayout(cardLabel);
        card.addClassName("card");
        card.setAlignItems(Alignment.CENTER);
        card.setJustifyContentMode(JustifyContentMode.CENTER);
        card.setWidth("100%");
        card.setHeight("200px");
        return card;
    }

}

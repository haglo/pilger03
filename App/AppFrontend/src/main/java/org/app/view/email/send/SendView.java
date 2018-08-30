package org.app.view.email.send;

import java.awt.TextField;

import org.app.helper.I18n;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class SendView extends Window {

	private I18n i18n;
	private VerticalLayout subContent;
	private CssLayout topBar;
	private VerticalLayout mainContent;

	public SendView() {
		i18n = new I18n();
		subContent = new VerticalLayout();
		this.setWidth("50%");
		this.setCaption(i18n.EMAIL_WRITE);
		this.setContent(subContent);
		this.center();
		
		topBar = new CssLayout();
		topBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		mainContent = new VerticalLayout();
		mainContent.setSizeFull();

		Button sendButton = new Button(i18n.EMAIL_SEND, ev -> {

		});
		
		sendButton.setIcon(VaadinIcons.LOCATION_ARROW_CIRCLE_O);
		topBar.addComponent(sendButton);
		
		TextField txfSubject = new TextField();
		RichTextArea rta = new RichTextArea();
		rta.setSizeFull();

//		mainContent.addComponent(txfSubject);
		mainContent.addComponent(rta);
		
		subContent.addComponent(topBar);
		subContent.addComponent(mainContent);

	}

}
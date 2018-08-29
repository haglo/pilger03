package org.app.view.help;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.app.helper.I18n;
import org.app.view.MainUI;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.UIScoped;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.navigator.View;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@CDIView(I18n.HELP_VIEW)
@UIScoped
public class HelpView extends HorizontalLayout implements View {

	@Inject
	JaasAccessControl accessControl;
	
	@Inject
	
	

	public HelpView() {
		setMargin(new MarginInfo(false, true, true, true));
	}

	@PostConstruct
	void init() {
		setSizeFull();
		setWidth(I18n.WINDOW_WIDTH);
 
		VerticalLayout content = new VerticalLayout();

		Label username = new Label("Elytronuser: " +accessControl.getPrincipalName());
		Label loc = new Label("Lokale: " +((MainUI) UI.getCurrent()).getLocale());
		Label theme = new Label("Theme: " +((MainUI) UI.getCurrent()).getTheme());
		Label windowWidth = new Label("WindowWidth: " +I18n.WINDOW_WIDTH);
		
		content.addComponent(headingLabel());
		content.addComponent(someText());
		content.addComponent(username);
		content.addComponent(loc);
		content.addComponent(theme);
		content.addComponent(windowWidth);
		addComponent(content);
		setDefaultComponentAlignment(Alignment.TOP_CENTER);
	}

	private Label headingLabel() {
		return new Label("Help without HTML");
	}

	private Label someText() {
		Label label = new Label("Help <b>with HTML</b>");
		label.setContentMode(ContentMode.HTML);
		return label;
	}

}

package org.app.view.email;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.app.helper.I18n;
import org.app.view.email.inbox.InboxView;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@CDIView(I18n.EMAIL_VIEW)
public class EmailView extends VerticalLayout implements View {
	
	@Inject
	InboxView inboxView;

	private I18n i18n;
	private VerticalLayout mainView;
	private EmailTopMenu emailTopMenu;
	private HorizontalLayout emailContentView;
	private VerticalLayout emailContentLeftBar ;
	private VerticalLayout emailContentRightBar;
	private Button inboxButton;

	public EmailView() {
		i18n = new I18n();
		setSizeFull();
		setMargin(new MarginInfo(true, true, true, true));
	}

	@PostConstruct
	void init() {
		mainView = new VerticalLayout();
		emailTopMenu = new EmailTopMenu();
		emailContentView = new HorizontalLayout();
		
		emailContentLeftBar = new VerticalLayout();
		emailContentLeftBar.setMargin(false);
		emailContentRightBar = new VerticalLayout();
		emailContentRightBar.setSizeFull();

		emailContentLeftBar.addComponent(showInboxView());
		emailContentRightBar.addComponent(inboxView);

		emailContentView.addComponent(emailContentLeftBar );
		emailContentView.addComponent(emailContentRightBar);
		emailContentView.setSizeFull();

		emailContentView.setExpandRatio(emailContentLeftBar , 0.2f);
		emailContentView.setExpandRatio(emailContentRightBar, 0.8f);
		
		

		mainView.addComponent(emailTopMenu);
		mainView.addComponent(emailContentView);
		addComponent(mainView);
	}

	private Button showInboxView() {
		inboxButton = new Button(i18n.EMAIL_INBOX, new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				emailContentRightBar.removeAllComponents();
				emailContentRightBar.addComponent(inboxView);
			}
		});
		return inboxButton;
	}

}

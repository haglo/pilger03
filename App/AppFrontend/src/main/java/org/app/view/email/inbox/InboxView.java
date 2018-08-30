package org.app.view.email.inbox;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.app.controler.EmailService;
import org.app.helper.I18n;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@CDIView(I18n.INBOX_VIEW)
public class InboxView extends VerticalLayout implements View {
	
	@Inject
	EmailService service;

	private I18n i18n;
	private HorizontalSplitPanel mainContent;
	private InboxOverView inboxOverView;
	private InboxDetailView inboxDetailView;


	public InboxView() {
		i18n = new I18n();
		setMargin(false);
		setSizeFull();

	}

	@PostConstruct
	void init() {
		mainContent = new HorizontalSplitPanel();
		mainContent.setSplitPosition(50, Unit.PERCENTAGE);
		mainContent.setSizeFull();
		
		inboxOverView = new InboxOverView(service);
		inboxDetailView = new InboxDetailView();
		
		mainContent.setFirstComponent(inboxOverView);
		mainContent.setSecondComponent(inboxDetailView);
		addComponent(mainContent);
	}
	
	

}
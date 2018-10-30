package org.app.view.email.inbox;

import com.vaadin.server.Page;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class InboxDetailView extends VerticalLayout {

	private VerticalLayout mainContent;
	private TextArea area;

	public InboxDetailView(String messageText) {
		mainContent = new VerticalLayout();
		setMargin(new MarginInfo(false, true, false, false));
		setSizeFull();
		area = new TextArea();
		area.setSizeFull();
		area.setValue(messageText);
		area.setVisible(true);
		
		mainContent.addComponent(area);
		addComponent(mainContent);
	}
	
	public void setMessageText(String messageText) {
		area.setValue(messageText);
		area.setVisible(true);
		Page.getCurrent().reload();
	}

}
package org.app.view.email.inbox;

import org.app.helper.I18n;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class InboxDetailView extends VerticalLayout {

	private I18n i18n;
	private VerticalLayout mainContent;

	public InboxDetailView() {
		i18n = new I18n();
		mainContent = new VerticalLayout();
		setMargin(new MarginInfo(false, true, false, false));
		setSizeFull();
		TextArea area = new TextArea();

		mainContent.addComponent(area);
		addComponent(mainContent);
	}


}
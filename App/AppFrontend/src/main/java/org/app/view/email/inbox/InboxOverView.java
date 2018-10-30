package org.app.view.email.inbox;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.app.controler.EmailService;
import org.app.controler.email.CheckingEmails;
import org.app.helper.I18n;
import org.app.model.entity.ElytronUser;
import org.app.model.entity.Pmail;

import com.vaadin.client.renderers.DateRenderer;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.renderers.Renderer;
import com.vaadin.ui.renderers.TextRenderer;

@SuppressWarnings("serial")
public class InboxOverView extends VerticalLayout {

	private InboxDetailView inboxDetailView;

	private I18n i18n;
	private Grid<Pmail> grid;
	private ListDataProvider<Pmail> dataProvider;
	private CheckingEmails checkingEmails;
	private Set<Pmail> selectedMails;
	private Pmail selectedMail;

	public InboxOverView(EmailService service) {
		i18n = new I18n();
		setMargin(new MarginInfo(false, true, false, false));
		setSizeFull();
		checkingEmails = new CheckingEmails();
		checkingEmails.readEmails(service);

		List<Pmail> list = service.getPmailDAO().findAll();
		DataProvider<Pmail, ?> dataProvider = DataProvider.ofCollection(list);

		grid = new Grid<Pmail>();
		grid.setSizeFull();
		grid.setWidth("100%");
		grid.setSelectionMode(SelectionMode.MULTI);
		grid.setDataProvider(dataProvider);
		grid.addColumn(Pmail::getPfrom).setRenderer(from -> from != null ? I18n.decodeFromBase64(from) : null, new TextRenderer()).setCaption("From");
		grid.addColumn(Pmail::getPsubject).setRenderer(subject -> subject != null ? I18n.decodeFromBase64(subject) : null, new TextRenderer()).setCaption("Subject");
		grid.addColumn(Pmail::getPcontent).setRenderer(content -> content != null ? I18n.decodeFromBase64(content) : null, new TextRenderer()).setCaption("Inhalt");
		
		grid.addSelectionListener(event -> {
			selectedMail = new Pmail();
			selectedMails = new HashSet<Pmail>();
			selectedMails = event.getAllSelectedItems();
			if (selectedMails.size() != 1) {
				inboxDetailView.setVisible(false);
			} else {
				selectedMail = getTheSelectedMail(selectedMails);
				if (selectedMail != null) {
					inboxDetailView.setVisible(true);
//					inboxDetailView = new InboxDetailView(I18n.decodeFromBase64(selectedMail.getPcontent()));
//					Notification.show(I18n.decodeFromBase64(selectedMail.getPcontent()));
				}
			}
		});
		addComponent(grid);
	}

	private Pmail getTheSelectedMail(Set<Pmail> selectedMails) {
		selectedMail = new Pmail();
		if (selectedMails.size() > 1) {
			Notification.show(i18n.NOTIFICATION_ONLY_ONE_ITEM);
			return null;
		}
		if (selectedMails.size() < 1) {
			Notification.show(i18n.NOTIFICATION_EXACT_ONE_ITEM);
			return null;
		}
		if (selectedMails.size() == 1) {
			for (Pmail pmail : selectedMails) {
				selectedMail = pmail;
			}
		}
		return selectedMail;

	}

}
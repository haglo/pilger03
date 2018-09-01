package org.app.view.email.inbox;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.mail.MessagingException;

import org.app.controler.EmailService;
import org.app.controler.email.CheckingEmails;
import org.app.helper.I18n;
import org.app.model.entity.Pmail;
import org.app.model.entity.Person;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class InboxOverView extends VerticalLayout {

	private I18n i18n;
	private Grid<Pmail> grid;
	private ListDataProvider<Pmail> dataProvider;
	private CheckingEmails checkingEmails;

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
		grid.setDataProvider(dataProvider);
		grid.addColumn(Pmail::getPfrom).setCaption("From");
		grid.addColumn(Pmail::getPsubject).setCaption("Subject");
		addComponent(grid);
	}


}
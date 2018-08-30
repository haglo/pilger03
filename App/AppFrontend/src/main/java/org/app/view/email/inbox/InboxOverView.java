package org.app.view.email.inbox;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.app.controler.EmailService;
import org.app.helper.I18n;
import org.app.model.entity.Email;

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
	private Grid<Email> grid;
	private ListDataProvider<Email> dataProvider;
	private Set<Email> selectedEntries;

	public InboxOverView(EmailService service) {
		i18n = new I18n();
		setMargin(new MarginInfo(false, true, false, false));
		setSizeFull();
		
		final List<Email> list = service.getEmailDAO().findAll();
		selectedEntries = new HashSet<>();
		dataProvider = DataProvider.ofCollection(list);
		dataProvider.setSortOrder(Email::getId, SortDirection.ASCENDING);
		
		grid = new Grid<Email>();
		grid.setSizeFull();
		grid.setWidth("100%");
		
		grid.setSelectionMode(SelectionMode.MULTI);
		grid.addSelectionListener(event -> {
			selectedEntries = event.getAllSelectedItems();
		});

		grid.setDataProvider(dataProvider);
		grid.addColumn(Email::getHeader).setCaption(i18n.EMAIL_HEADER).setId(i18n.EMAIL_HEADER);
		
		addComponent(grid);
	}


}
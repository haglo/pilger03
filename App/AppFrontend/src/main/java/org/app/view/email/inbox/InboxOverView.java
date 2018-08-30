package org.app.view.email.inbox;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.app.controler.PersonService;
import org.app.helper.I18n;
import org.app.model.dao.PersonDAO;
import org.app.model.entity.Address;
import org.app.model.entity.Person;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class InboxOverView extends VerticalLayout {

	private I18n i18n;
	private Grid<Address> grid;

	public InboxOverView() {
		i18n = new I18n();
		setMargin(new MarginInfo(false, true, false, false));
		setSizeFull();
		grid = new Grid<Address>();
		grid.setSizeFull();
		grid.setSelectionMode(SelectionMode.MULTI);
		addComponent(grid);
	}


}
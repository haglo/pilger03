package org.app.view.person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.app.helper.I18n;
import org.app.model.dao.PersonDAO;
import org.app.model.entity.Address;
import org.app.model.entity.Person;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class AddressView extends VerticalLayout {

	private I18n i18n;
	private Person selectedPerson;
	private PersonDAO personDAO;
	private Grid<Address> grid;
	private ListDataProvider<Address> addressDataProvider;
	private Address selectedAddress;
	private Set<Address> selectedAddresses;
	private List<Address> addressList;

	public AddressView(PersonDAO personDAO, Person selectedPerson) {
		setMargin(new MarginInfo(false, true, false, false));
		setSizeFull();

		this.selectedPerson = selectedPerson;
		this.personDAO = personDAO;
		i18n = new I18n();
		addressList = new ArrayList<Address>();
		addressList = personDAO.findAddresses(selectedPerson);

		addressDataProvider = DataProvider.ofCollection(addressList);
		grid = new Grid<Address>();
		grid.setSizeFull();
		grid.setSelectionMode(SelectionMode.MULTI);
		grid.setDataProvider(addressDataProvider);

		grid.addSelectionListener(event -> {
			selectedAddresses = new HashSet<Address>();
			selectedAddresses = event.getAllSelectedItems();
		});

		grid.addColumn(address -> address.getStreet()).setCaption(i18n.PERSON_STREET);
		grid.addColumn(address -> address.getPostbox()).setCaption(i18n.PERSON_POSTBOX);
		grid.addColumn(address -> address.getZip()).setCaption(i18n.PERSON_ZIPCODE);
		grid.addColumn(address -> address.getCity()).setCaption(i18n.PERSON_CITY);

		Button add = new Button("+");
		Button delete = new Button("-");
		delete.addClickListener(event -> deleteRow(selectedAddresses, personDAO, selectedPerson));

		CssLayout addressNavBar = new CssLayout(add, delete);
		addressNavBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

		addComponent(grid);
		addComponent(addressNavBar);
	}

	private void deleteRow(Set<Address> selectedAddresses, PersonDAO personDAO, Person selectedPerson) {
		if (selectedAddresses.size() == 0) {
			Notification.show(i18n.NOTIFICATION_NO_ITEM);
			return;
		}
		for (Address address : selectedAddresses) {
			personDAO.findByID(selectedPerson.getId()).removeAddress(address);
		}
		refreshGrid();
	}

	public void refreshGrid() {
		List<Address> addressList = this.personDAO.findAddresses(this.selectedPerson);
		grid.setItems(addressList);
	}

}
package org.app.view.person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.app.controler.AddressService;
import org.app.controler.PersonService;
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
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class AddressView extends VerticalLayout {

	private I18n i18n;
	private Person selectedPerson;
	private PersonDAO personDAO;
	private AddressService addressService;
	private Grid<Address> grid;
	private ListDataProvider<Address> addressDataProvider;
	private Address selectedAddress;
	private Set<Address> selectedAddresses;
	private List<Address> addressList;

	private SaveModus saveModus;
	private TextField txfStreet = new TextField();
	private TextField txfPostbox = new TextField();
	private TextField txfZip = new TextField();
	private TextField txfCity = new TextField();
	private TextField txfComment = new TextField();

	public AddressView(Person selectedPerson, PersonService personService, AddressService addressService) {
		setMargin(new MarginInfo(false, true, false, false));
		setSizeFull();
		saveModus = SaveModus.UPDATE;
		this.selectedPerson = selectedPerson;
		this.addressService = addressService;
		this.personDAO = personService.getPersonDAO();

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
			selectedAddresses.clear();
			selectedAddresses = event.getAllSelectedItems();
		});

		grid.getEditor().setEnabled(true);
		grid.getEditor().addSaveListener(event -> {
			selectedAddress = new Address();
			selectedAddress = event.getBean();
			if (saveModus == SaveModus.UPDATE) {
				updateRow(selectedAddress);
			} else {
				selectedPerson.getAddresses().add(selectedAddress);
				personDAO.update(selectedPerson);
				resetGrid();
			}
		});

		grid.getEditor().addCancelListener(event -> {
			if (saveModus == SaveModus.NEW) {
				resetGrid();
			}
		});

		grid.addColumn(address -> address.getPostbox()).setCaption(i18n.PERSON_POSTBOX).setEditorComponent(txfPostbox,
				Address::setPostbox);
		grid.addColumn(address -> address.getStreet()).setCaption(i18n.PERSON_STREET).setEditorComponent(txfStreet,
				Address::setStreet);
		grid.addColumn(address -> address.getZip()).setCaption(i18n.PERSON_ZIPCODE).setEditorComponent(txfZip,
				Address::setZip);
		grid.addColumn(address -> address.getCity()).setCaption(i18n.PERSON_CITY).setEditorComponent(txfCity,
				Address::setCity);
		grid.addColumn(address -> address.getComment()).setCaption(i18n.BASIC_COMMENT).setEditorComponent(txfComment,
				Address::setComment);

		Button add = new Button("+");
		add.addClickListener(event -> {
			saveModus = SaveModus.NEW;
			Address newAddress = new Address();
			newAddress.setPerson(selectedPerson);
			addressList.add(newAddress);
			grid.setItems(addressList);
			grid.getEditor().editRow(addressList.size() - 1);
			txfPostbox.focus();
		});

		Button delete = new Button("-");
		delete.addClickListener(event -> deleteRow());

		CssLayout addressNavBar = new CssLayout(add, delete);
		addressNavBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

		addComponent(grid);
		addComponent(addressNavBar);
	}

	private void deleteRow() {
		if (selectedAddresses.size() == 0) {
			Notification.show(i18n.NOTIFICATION_NO_ITEM);
			return;
		}
		for (Address entityItem : selectedAddresses) {
			selectedPerson.removeAddress(entityItem);
		}
		personDAO.update(selectedPerson);
		resetGrid();
	}

	public void updateRow(Address address) {
		addressService.getAddressDAO().update(address);
		resetGrid();
	}

	private enum SaveModus {
		NEW, UPDATE
	}

	public void resetGrid() {
		addressList.clear(); 
		addressList = personDAO.findAddresses(selectedPerson);
		grid.setItems(addressList);
		saveModus = SaveModus.UPDATE;
	}

}
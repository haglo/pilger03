package org.app.view.person;

import org.app.controler.PersonService;
import org.app.helper.I18n;
import org.app.model.entity.Person;

import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PersonDetailView extends Window {

	private static final long serialVersionUID = 1L;

	private I18n i18n;

	private TextField txfFirstname;
	private TextField txfLastname;
	private TextArea txaComment;
	private CheckBox ckbEdit;
	private Button saveButton;

	private PersonService personService;

	@SuppressWarnings("static-access")
	public PersonDetailView(PersonView personView, Person selectedPerson) {
		i18n = new I18n();
		this.personService = personView.getPersonService();
		saveButton = new Button(i18n.BASIC_SAVE);

		this.setCaption(i18n.TITLE_WINDOW_DETAIL_CAPTION);
		VerticalLayout subContent = new VerticalLayout();
		this.setContent(subContent);
		this.center();

		this.setStyleName("point1");
		subContent.setStyleName("point2");

		try {
			personService.setEditing(false);

			TextField txfID = new TextField("ID", "" + selectedPerson.getId());
			subContent.addComponent(txfID);

			txfFirstname = new TextField(i18n.PERSON_SURNAME, "" + selectedPerson.getFirstName());
			subContent.addComponent(txfFirstname);

			txfLastname = new TextField(i18n.PERSON_LASTNAME, "" + selectedPerson.getLastName());
			subContent.addComponent(txfLastname);

			txaComment = new TextArea(i18n.BASIC_COMMENT, "" + selectedPerson.getComment());
			subContent.addComponent(txaComment);

			ckbEdit = new CheckBox(i18n.BASIC_EDIT);
			ckbEdit.addValueChangeListener(event -> {
				personService.toggleEditing();
				if (event.getValue()) {
					saveButton.setEnabled(true);
				} else {
					saveButton.setEnabled(false);
				}
			});

			subContent.addComponent(ckbEdit);

			saveButton.setEnabled(personService.getEditing());
			subContent.addComponent(saveButton);

			saveButton.addClickListener(event -> {
				selectedPerson.setFirstName(txfFirstname.getValue());
				selectedPerson.setLastName(txfLastname.getValue());
				selectedPerson.setComment(txaComment.getValue());
				personView.updateRow(selectedPerson);
				personView.refreshGrid();
				getUI().getCurrent().removeWindow(this);
			});

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

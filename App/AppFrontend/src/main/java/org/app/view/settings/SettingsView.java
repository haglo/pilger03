package org.app.view.settings;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.app.controler.SettingsService;
import org.app.helper.I18n;
import org.app.model.entity.Settings;
import org.app.model.entity.enums.DefaultLanguage;
import org.app.model.entity.enums.DefaultTheme;
import org.app.view.TopMainMenu;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings({ "serial", "unused" })
@CDIView(I18n.SETTINGS_VIEW)
public class SettingsView extends HorizontalLayout implements View {

	@Inject
	SettingsService settingsService;

	private I18n i18n;
	private Settings mySettings;
	private Set<Settings> settings;
	private Button saveButton;
	private ComboBox<DefaultLanguage> cbxLanguage;
	private ComboBox<DefaultTheme> cbxTheme;
	private TextField txfWindowWidth;
	private CheckBox ckbEdit;

	public SettingsView() {
		i18n = new I18n();
	}

	@PostConstruct
	void init() {
		setWidth(I18n.WINDOW_WIDTH);
		VerticalLayout content = new VerticalLayout();
		saveButton = new Button(i18n.BASIC_SAVE);
		mySettings = new Settings();
		settings = new HashSet<>();
		List<Settings> settings = settingsService.getSettingsDAO().findAll();

		for (Settings entry : settings) {
			mySettings = entry;
		}

		ckbEdit = new CheckBox(i18n.BASIC_EDIT);
		ckbEdit.addValueChangeListener(event -> {
			settingsService.toggleEditing();
			if (event.getValue()) {
				saveButton.setEnabled(true);
			} else {
				saveButton.setEnabled(false);
			}
		});

		txfWindowWidth = new TextField(i18n.SETTINGS_WINDOW_WIDTH);
		txfWindowWidth.setValue(mySettings.getDefaultWindowWidth());

		saveButton.setEnabled(settingsService.getEditing());

		saveButton.addClickListener(event -> {
			mySettings.setDefaultWindowWidth(txfWindowWidth.getValue());
			mySettings = settingsService.getSettingsDAO().update(mySettings);

		});

		content.addComponent(txfWindowWidth);
		content.addComponent(ckbEdit);
		content.addComponent(saveButton);
		addComponent(content);
		setDefaultComponentAlignment(Alignment.TOP_CENTER);
	}

}

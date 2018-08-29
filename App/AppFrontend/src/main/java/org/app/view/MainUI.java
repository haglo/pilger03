package org.app.view;

import java.util.Locale;
import java.util.Optional;

import javax.inject.Inject;

import org.app.controler.ElytronUserService;
import org.app.controler.SessionService;
import org.app.controler.SettingsService;
import org.app.helper.I18n;
import org.app.view.login.LoginView;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("default")
@CDIUI("")
public class MainUI extends UI {
	@Inject
	CDIViewProvider viewProvider;

	@Inject
	LoginView loginView;

	@Inject
	JaasAccessControl accessControl;

	@Inject
	ElytronUserService elytronUserService;
	
	@Inject
	SettingsService settingsService;

//	@Inject
//	SessionService sessionService;

	private Navigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		if (accessControl.isUserSignedIn()) {
			setupMainLayout();
		} else {
			setContent(loginView);
		}
	}

	public void loginSuccessful() {
		setupMainLayout();
	}

	private void setupMainLayout() {
		final VerticalLayout mainLayout = new VerticalLayout();
		final HorizontalLayout menuView = new HorizontalLayout();
		final HorizontalLayout contentView = new HorizontalLayout();
		contentView.setSizeFull();
		contentView.setDefaultComponentAlignment(Alignment.TOP_CENTER);

		TopMainMenu topNavBar = new TopMainMenu(accessControl);
		menuView.addComponent(topNavBar);

		mainLayout.addComponent(menuView);
		mainLayout.addComponent(contentView);

		mainLayout.setComponentAlignment(menuView, Alignment.TOP_CENTER);
		mainLayout.setComponentAlignment(contentView, Alignment.TOP_CENTER);

		mainLayout.setExpandRatio(menuView, 0.10f);
		mainLayout.setExpandRatio(contentView, 0.90f);

		mainLayout.setSizeFull();
		setTheme(I18n.getElytronTheme(elytronUserService.getLoggedInUser().getDefaultTheme()));
		setLocale(I18n.getElytronLocale(elytronUserService.getLoggedInUser().getDefaultLanguage()));
		I18n.WINDOW_WIDTH = settingsService.getAppWindowWidth(); 

		setContent(mainLayout);
		topNavBar.updateMessageStrings();

		navigator = new Navigator(this, contentView);
		navigator.addProvider(viewProvider);
		navigator.setErrorView(loginView);

		String initialState = Optional.ofNullable(navigator.getState()).filter(state -> !state.trim().isEmpty())
				.orElse(I18n.PERSON_VIEW);
		navigator.navigateTo(initialState);
	}

}
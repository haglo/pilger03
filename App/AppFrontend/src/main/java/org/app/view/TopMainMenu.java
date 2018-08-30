package org.app.view;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import org.app.helper.I18n;
import org.app.helper.I18nManager;

import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@DeclareRoles({ I18n.ROLE_SYSTEM, I18n.ROLE_POWERUSER, I18n.ROLE_ADMINISTRATOR, I18n.ROLE_USER, I18n.ROLE_GUEST })
public class TopMainMenu extends CustomComponent {

	private Button logOutButton;
	private JaasAccessControl accessControl;
	private I18n i18n;
	
	public TopMainMenu() {

	}

	public TopMainMenu(JaasAccessControl ac) {
		accessControl = new JaasAccessControl();
		accessControl = ac;
		setupLayout();
	}

	Button personViewButton = new Button("Address", e -> UI.getCurrent().getNavigator().navigateTo(I18n.PERSON_VIEW));

	Button masterDetailViewButton = new Button("Master Detail",
			e -> UI.getCurrent().getNavigator().navigateTo(I18n.MASTER_DETAIL_VIEW));

	Button accountViewButton = new Button("Accounts",
			e -> UI.getCurrent().getNavigator().navigateTo(I18n.ACCOUNT_VIEW));

	Button userViewButton = new Button("Users", e -> UI.getCurrent().getNavigator().navigateTo(I18n.ELYTRON_USER_VIEW));

	Button helpViewButton = new Button("Help", e -> UI.getCurrent().getNavigator().navigateTo(I18n.HELP_VIEW));
	
	Button emailViewButton = new Button("Email", e -> UI.getCurrent().getNavigator().navigateTo(I18n.EMAIL_VIEW));

	Button settingsViewButton = new Button("Settings",
			e -> UI.getCurrent().getNavigator().navigateTo(I18n.SETTINGS_VIEW));

	private Button logoutButton() {
		logOutButton = new Button("Logout", new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					accessControl.logout();
					getUI().getSession().close();
					getUI().getPage().reload();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		logOutButton.setIcon(VaadinIcons.SIGN_OUT);
		logOutButton.addStyleName("icon-align-top");
		return logOutButton;
	}

	private void setupLayout() {
		HorizontalLayout layout = new HorizontalLayout();
		personViewButton.setIcon(VaadinIcons.FAMILY);
		personViewButton.addStyleName("icon-align-top");
		masterDetailViewButton.setIcon(VaadinIcons.NEWSPAPER);
		masterDetailViewButton.addStyleName("icon-align-top");
		accountViewButton.setIcon(VaadinIcons.USER);
		accountViewButton.addStyleName("icon-align-top");
		userViewButton.setIcon(VaadinIcons.USER);
		userViewButton.addStyleName("icon-align-top");
		helpViewButton.setIcon(VaadinIcons.QUESTION);
		helpViewButton.addStyleName("icon-align-top");
		emailViewButton.setIcon(VaadinIcons.ENVELOPE);
		emailViewButton.addStyleName("icon-align-top");
		settingsViewButton.setIcon(VaadinIcons.COGS);
		settingsViewButton.addStyleName("icon-align-top");

		layout.addComponent(personViewButton);
		layout.addComponent(masterDetailViewButton);
		layout.addComponent(accountViewButton);
		layout.addComponent(userViewButton);

		/**
		 * Authorization-Example
		 */
//		if (accessControl.isUserInRole(I18n.ROLE_SYSTEM) || accessControl.isUserInRole(I18n.ROLE_POWERUSER)) {
//			layout.addComponent(helpViewButton);
//		}

		layout.addComponent(helpViewButton);
		layout.addComponent(emailViewButton);
		layout.addComponent(settingsViewButton);
		layout.addComponent(logoutButton());
		setCompositionRoot(layout);
	}
	
	public void updateMessageStrings() {
		i18n = new I18n();
		personViewButton.setCaption(i18n.NAVI_PERSONS);
		masterDetailViewButton.setCaption(i18n.NAVI_MASTER_DETAIL);
		accountViewButton.setCaption(i18n.NAVI_ACCOUNTS);
		userViewButton.setCaption(i18n.NAVI_ELYTRON_USER);
		helpViewButton.setCaption(i18n.NAVI_HELP);
		emailViewButton.setCaption(i18n.NAVI_EMAIL);
		settingsViewButton.setCaption(i18n.NAVI_SETTINGS);
		logOutButton.setCaption(i18n.NAVI_LOGOUT);
	}

}

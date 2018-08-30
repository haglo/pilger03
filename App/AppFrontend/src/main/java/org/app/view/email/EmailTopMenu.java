package org.app.view.email;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import org.app.helper.I18n;
import org.app.helper.I18nManager;

import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@DeclareRoles({ I18n.ROLE_SYSTEM, I18n.ROLE_POWERUSER, I18n.ROLE_ADMINISTRATOR, I18n.ROLE_USER, I18n.ROLE_GUEST })
public class EmailTopMenu extends CustomComponent {

	private I18n i18n;
	
	public EmailTopMenu() {
		i18n = new I18n();
		Button callButton = new Button("Call", e -> UI.getCurrent().getNavigator().navigateTo(I18n.EMAIL_VIEW));
		callButton.setIcon(VaadinIcons.CLOUD_DOWNLOAD);
		Button writeButton = new Button("Write", e -> UI.getCurrent().getNavigator().navigateTo(I18n.EMAIL_VIEW));
		callButton.setIcon(VaadinIcons.EDIT);
		
		CssLayout emailNavBar = new CssLayout(callButton, writeButton);
		emailNavBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		
		setCompositionRoot(emailNavBar);

	}

}

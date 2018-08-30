package org.app.view.account;

import java.util.EnumSet;

import org.app.controler.AccountService;
import org.app.helper.I18n;
import org.app.helper.I18nManager;
import org.app.model.entity.Account;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class AccountDetailView extends Window {

	private static final long serialVersionUID = 1L;

	private I18n i18n;
	private TextField txfUsername;
	private TextField txfMailaddress;
	private TextField txfPassword;
	private TextArea txaComment;
	private CheckBox ckbEdit;
	private Button saveButton;
	private BCryptPasswordEncoder encoder;

	private AccountService accountService;
	
	@SuppressWarnings("static-access")
	public AccountDetailView(AccountView accountView, Account selectedAccount) {
		encoder = new BCryptPasswordEncoder();
		i18n = new I18n();
		this.accountService = accountView.getAccountService();
		saveButton = new Button(i18n.BASIC_SAVE);

		this.setCaption(i18n.ACCOUNT_WINDOW_DETAIL_CAPTION);
		VerticalLayout subContent = new VerticalLayout();
		this.setContent(subContent);
		this.center();

		try {
			accountService.setEditing(false);

			TextField txfID = new TextField(i18n.BASIC_ID, "" + selectedAccount.getId());
			txfID.setReadOnly(true);
			subContent.addComponent(txfID);

			txfUsername = new TextField(i18n.ACCOUNT_USERNAME, "" + selectedAccount.getUsername());
			subContent.addComponent(txfUsername);

			txfPassword = new TextField(i18n.ACCOUNT_PASSWORD, "" + selectedAccount.getPassword());
			subContent.addComponent(txfPassword);

			txfMailaddress = new TextField(i18n.BASIC_EMAIL, "" + selectedAccount.getMailaddress());
			subContent.addComponent(txfMailaddress);

			txaComment = new TextArea(i18n.BASIC_COMMENT, "" + selectedAccount.getComment());
			subContent.addComponent(txaComment);

			ckbEdit = new CheckBox(i18n.BASIC_EDIT);
			ckbEdit.addValueChangeListener(event -> {
				accountService.toggleEditing();
				if (event.getValue()) {
					saveButton.setEnabled(true);
				} else {
					saveButton.setEnabled(false);
				}
			});

			subContent.addComponent(ckbEdit);

			saveButton.setEnabled(accountService.getEditing());
			subContent.addComponent(saveButton);

			saveButton.addClickListener(event -> {
				selectedAccount.setUsername(txfUsername.getValue());
				selectedAccount.setMailaddress(txfMailaddress.getValue());
				selectedAccount.setPassword(encode(txfPassword.getValue()));
				selectedAccount.setComment(txaComment.getValue());
				accountView.updateRow(selectedAccount);
				accountView.refreshGrid();
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
	
	private String encode(String password) {
		return encoder.encode(password);
	}

}
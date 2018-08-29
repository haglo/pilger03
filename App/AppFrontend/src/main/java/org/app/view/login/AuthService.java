package org.app.view.login;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.app.controler.AccountService;
import org.app.controler.ElytronUserService;
import org.app.controler.SessionService;
import org.app.helper.I18n;
import org.app.model.dao.ElytronRoleDAO;
import org.app.model.entity.Account;
import org.app.model.entity.ElytronUser;

@RequestScoped
public class AuthService {

	@EJB
	private ElytronRoleDAO elytronRoleDAO;

	@Inject
	private AccountService accountService;

	@Inject
	private ElytronUserService elytronUserService;

	@Inject
	private SessionService sessionService;

	@Inject
	private EncryptService encryptService;

	private Account account;
	private ElytronUser elytronUser;
	private String MessageForAuthentication = "Login Succesfull";

	public boolean validateAuthenticationValues(String username, String password) {
		boolean validUser = false;
		boolean validPassword = false;
		boolean validElytronUser = false;
		boolean authentic = false;

		validUser = validateLoginUser(username);

		if (validUser == true) {
			validPassword = validateLoginPassword(password);
		}

		if (validUser == true && validPassword == true) {
			validElytronUser = validateElytronUser(username);
		}

		if (validUser == true && validPassword == true && validElytronUser == true) {
			authentic = true;
		}

		return authentic;
	}

	
	private boolean validateLoginUser(String username) {
		account = new Account();

		try {
			account = accountService.findByUserName(username);
		} catch (Exception e) {
			MessageForAuthentication = "Username " + username + " not exist";
			return false;
		}
		return true;
	}

	private boolean validateLoginPassword(String password) {

//		if (password.equals(account.getPassword())) {
		if (encryptService.getEncoder().matches(password, account.getPassword())) {
			return true;
		} else {
			MessageForAuthentication = "Password not correct";
			return false;
		}

	}

	private boolean validateElytronUser(String username) {

		boolean result = false;
		boolean elytronUserExists = false;
		elytronUser = new ElytronUser();

		List<ElytronUser> elytronUserList = elytronUserService.getElytronUserDAO().findAll();
		for (ElytronUser entry : elytronUserList) {
			if (entry.getUsername().equals(username)) {
				elytronUserExists = true;
			}
		}

		if (elytronUserExists) {
			sessionService.setCurrentUser(elytronUser);
			result = true;
		}

		if (!elytronUserExists) {
			try {
				ElytronUser nutElytronUser = new ElytronUser();
				nutElytronUser = elytronUserService.getElytronUserDAO().findByID(1);

				elytronUser.setUsername(username);
				elytronUser.setPassword(I18n.ELYTRON_PASSWORD);
				elytronUser.setElytronRole(nutElytronUser.getElytronRole());
				elytronUser.setDefaultLanguage(nutElytronUser.getDefaultLanguage());
				elytronUser.setDefaultTheme(nutElytronUser.getDefaultTheme());

				elytronUserService.getElytronUserDAO().create(elytronUser);
				sessionService.setCurrentUser(elytronUser);
				result = true;
			} catch (Exception ex) {
				ex.printStackTrace();
				result = false;
			}
		}
		return result;
	}


	public String getMessageForAuthentication() {
		return MessageForAuthentication;
	}


}

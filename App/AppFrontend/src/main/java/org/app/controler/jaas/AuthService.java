package org.app.controler.jaas;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

import org.app.controler.AccountService;
import org.app.controler.ElytronUserService;
import org.app.controler.SessionService;
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

	private Account account;
	private ElytronUser elytronUser;
	private String MessageForAuthentication = "Login Succesfull";

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

		if (password.equals(account.getPassword())) {
			return true;
		} else {
			MessageForAuthentication = "Password not correct";
			return false;
		}

	}

	private boolean validateElytronUser(String username) {
//		boolean result = false;
//		elytronUser = new ElytronUser();
//
//		if (elytronUserService.getElytronUserDAO().findByName(username) != null) {
//			elytronUser = elytronUserService.getElytronUserDAO().findByName(username);
//			sessionService.setCurrentUser(elytronUser);
//			result = true;
//		}
//
//		if (elytronUserService.getElytronUserDAO().findByName(username) == null) {
//			try {
//				elytronUser.setUsername(username);
//				elytronUser.setRolename(elytronRoleDAO.findByID(1));
//				elytronUserService.getElytronUserDAO().create(elytronUser);
//				sessionService.setCurrentUser(elytronUser);
//				result = true;
//			} catch (Exception ex) {
//				ex.printStackTrace();
//				result = false;
//			}
//		}
//		return result;
//	}

		boolean result = false;
		elytronUser = new ElytronUser();

		try {
			elytronUser = elytronUserService.getElytronUserDAO().findByName(username);
			sessionService.setCurrentUser(elytronUser);
			result = true;

		} catch (NoResultException nre) {
			try {
				elytronUser.setUsername(username);
				elytronUser.setRolename(elytronRoleDAO.findByID(1));
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

	public boolean validateAccount(String username, String password) {
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

	public String getMessageForAuthentication() {
		return MessageForAuthentication;
	}

//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}

}

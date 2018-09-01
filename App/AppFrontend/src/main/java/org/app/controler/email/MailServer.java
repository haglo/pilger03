package org.app.controler.email;

import java.util.Properties;

public class MailServer {

	private static String sender;
	private static String username;
	private static String password;
	private static String smtpHost;
	private static String imapHost;

	private static Properties properties;
	
	public static void init() {
		sender = "h.g.gloeckler@gmail.com";
		username = "h.g.gloeckler@gmail.com";
		password = "1234:Atgfd";
		smtpHost = "smtp.gmail.com";
		imapHost = "imap.gmail.com";

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.port", "587");
		
		properties.put("mail.imap.user", username);
		properties.put("mail.imap.host", imapHost);
		properties.put("mail.imap.port", 993);
		properties.put("mail.imap.ssl.enable", true);
		properties.put("mail.store.protocol", "imaps");
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getImapHost() {
		return imapHost;
	}

	public void setImapHost(String imapHost) {
		this.imapHost = imapHost;
	}

	public static Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		MailServer.properties = properties;
	}

}

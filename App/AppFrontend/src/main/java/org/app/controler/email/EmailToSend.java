package org.app.controler.email;

import javax.activation.FileDataSource;

public class EmailToSend {

	private String sendTo;
	private String sendToCC;
	private String sendToBC;
	private String subject;
	private String text;
	private String textHTML;
	private FileDataSource dataSource;
	private boolean withAttachment;

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo.trim();
	}

	public String getSendToCC() {
		return sendToCC;
	}

	public void setSendToCC(String sendToCC) {
		this.sendToCC = sendToCC.trim();
	}

	public String getSendToBC() {
		return sendToBC;
	}

	public void setSendToBC(String sendToBC) {
		this.sendToBC = sendToBC.trim();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTextHTML() {
		return textHTML;
	}

	public void setTextHTML(String textHTML) {
		this.textHTML = textHTML;
	}

	public FileDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(String filename) {
		FileDataSource tmp = new FileDataSource(filename);
		this.dataSource = tmp;
	}

	public boolean isWithAttachment() {
		return withAttachment;
	}

	public void setWithAttachment(boolean withAttachment) {
		this.withAttachment = withAttachment;
	}

//	private Set<String> parseEntries(String entry) {
//		Set<String> tmp = new HashSet<>();
//		String delims = "[,]";
//		String[] tokens = entry.split(delims);
//		Arrays.stream(tokens).map(String::trim).toArray(unused -> tokens);
//		Collections.addAll(tmp, tokens);
//		return tmp;
//	}
}

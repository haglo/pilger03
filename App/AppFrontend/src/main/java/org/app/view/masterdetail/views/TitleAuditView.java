package org.app.view.masterdetail.views;

import java.util.List;

import org.app.controler.TitleService;
import org.app.helper.I18n;
import org.app.model.entity.Title;
import org.app.model.entity.Title_AUD;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class TitleAuditView extends Window {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	public TitleAuditView(Title selectedTitle, TitleService service) {
		I18n i18n = new I18n();

		this.setCaption(i18n.TITLE_AUDIT);
		VerticalLayout subContent = new VerticalLayout();
		this.setContent(subContent);
		this.center();

		Grid<Title_AUD> grid = new Grid<Title_AUD>();
		List<Title_AUD> list = service.getTitleDAO().findAudById(selectedTitle.getId());
		DataProvider<Title_AUD, ?> dataProvider = DataProvider.ofCollection(list);
		grid.setDataProvider(dataProvider);
		grid.setSizeFull();
		grid.setSelectionMode(SelectionMode.MULTI);

		grid.addColumn(aud -> {
			String result = "" + aud.getReventity().getListPrio();
			return result;
		}).setCaption(i18n.BASIC_LIST_PRIO);

		grid.addColumn(aud -> {
			String result = "" + aud.getReventity().getTitle();
			return result;
		}).setCaption(i18n.TITLE_VALUE);

		grid.addColumn(aud -> {
			String result = "" + aud.getRevision().getRevisionDate();
			return result;
		}).setCaption(i18n.BASIC_DATE);

		grid.addColumn(aud -> {
			String result = "" + aud.getRevision().getElytronUser().getUsername();
			return result;
		}).setCaption(i18n.ACCOUNT_USERNAME);

		grid.addColumn(aud -> {
			String result = "" + aud.getRevType();
			return result;
		}).setCaption(i18n.BASIC_TYPE);

		subContent.addComponent(grid);
		this.setWidth("80%");

	}

}

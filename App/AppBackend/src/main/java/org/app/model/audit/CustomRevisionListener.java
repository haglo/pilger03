package org.app.model.audit;

import java.io.Serializable;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener, Serializable {

	private static final long serialVersionUID = 1L;
	private ElytronUserSessionScoped userBean;

	public void newRevision(Object revisionEntity) {
		userBean = getUserBean();
		RevInfo rev = (RevInfo) revisionEntity;
		rev.setElytronUser(userBean.getElytronUser());
	}

	
	@SuppressWarnings("unchecked")
	private ElytronUserSessionScoped getUserBean() {
		BeanManager beanManager = CDI.current().getBeanManager();
		Bean<ElytronUserSessionScoped> bean = ((Bean<ElytronUserSessionScoped>) beanManager.getBeans(ElytronUserSessionScoped.class).iterator().next());
		CreationalContext<ElytronUserSessionScoped> context = beanManager.createCreationalContext(bean);
		userBean = (ElytronUserSessionScoped) beanManager.getReference(bean, ElytronUserSessionScoped.class, context);
		return userBean;
	}

}

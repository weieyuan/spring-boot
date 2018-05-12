package ws.app.utils.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHelper implements ApplicationContextAware {

	private ApplicationContext context;

	private static ApplicationHelper applicationHelper;

	@PostConstruct
	public void init() {
		ApplicationHelper.applicationHelper = this;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	public static ApplicationHelper getInstance() {
		return applicationHelper;
	}

	public ApplicationContext getContext() {
		return context;
	}
}

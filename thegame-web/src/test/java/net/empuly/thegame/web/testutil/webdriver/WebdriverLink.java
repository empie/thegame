package net.empuly.thegame.web.testutil.webdriver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class WebdriverLink {

	public static final String ROOT_URL = "";
	public static final WebdriverLink APPLICATION_ROOT = new WebdriverLink(ROOT_URL) {
	};

	protected String urlPartAfterContextPath;

	private final Map<String, String> parameters = new HashMap<String, String>();

	public WebdriverLink(final String urlPartAfterContextPath) {
		this.urlPartAfterContextPath = urlPartAfterContextPath;
	}

	public String getUrlPartAfterContextPath() {
		return urlPartAfterContextPath + constructUrlParameterString();
	}

	public void open() {
		WebdriverFactory.getWebdriver().get(constructFullUrl());
	}

	private String constructUrlParameterString() {
		final StringBuilder parameterString = new StringBuilder();
		if (!parameters.isEmpty()) {
			parameterString.append("?");
			final Iterator<String> parameterNames = parameters.keySet().iterator();
			while (parameterNames.hasNext()) {
				final String parameterName = parameterNames.next();
				parameterString.append(parameterName);
				parameterString.append("=");
				parameterString.append(parameters.get(parameterName));
				if (parameterNames.hasNext()) {
					parameterString.append("&");
				}
			}
		}
		return parameterString.toString();
	}

	protected void addParameter(final String id, final String value) {
		parameters.put(id, value);
	}

	protected final String constructFullUrl() {
		final String fullUrl = WebdriverProperties.getBaseUrl() + getUrlPartAfterContextPath();
		System.out.println(fullUrl);
		return fullUrl;
	}

}

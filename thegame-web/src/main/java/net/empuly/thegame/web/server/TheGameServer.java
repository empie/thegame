package net.empuly.thegame.web.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class TheGameServer {

	public static void main(final String[] args) throws Exception
	{

		final Server server = new Server(8080);
		final WebAppContext context = new WebAppContext();
		context.setResourceBase("./src/main/webapp");
		context.setContextPath("/thegame");
		context.setParentLoaderPriority(true);

		server.setHandler(context);
		
		server.start();
		server.join();
	}

}

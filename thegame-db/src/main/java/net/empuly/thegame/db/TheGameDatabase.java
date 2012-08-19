package net.empuly.thegame.db;

import java.io.File;
import java.sql.SQLException;

import org.hsqldb.Server;

public class TheGameDatabase {
	private static final String DEFAULT_DATABASE_PATH = "C:/development/resources/hsqldb/";

	public static void main(final String[] args) throws ClassNotFoundException, SQLException {
		final File databaseFolder = determineDatabasePath(args);
		if (databaseFolder.exists()) {
			startDatabaseServerFromPathAndRunScripts(databaseFolder);
		}
	}

	private static File determineDatabasePath(final String[] args) {
		File databaseFolder = null;
		if (args.length == 1) {
			System.out.println(args[0]);
			databaseFolder = new File(args[0]);
		}
		if ((databaseFolder == null) || !databaseFolder.exists()) {
			databaseFolder = new File(DEFAULT_DATABASE_PATH);
		}
		return databaseFolder;
	}

	private static Server startDatabaseServerFromPath(final File databaseFolder) {
		Server hsqlServer;
		hsqlServer = new Server();
		hsqlServer.setDaemon(true);
		hsqlServer.setDatabaseName(0, "thegame");
		hsqlServer.setDatabasePath(0, "file:" + databaseFolder.getAbsolutePath() + File.separator + "thegame");
		hsqlServer.start();
		return hsqlServer;
	}

	private static void startDatabaseServerFromPathAndRunScripts(final File databaseFolder) throws ClassNotFoundException, SQLException {
		Server hsqlServer = null;
		try {
			hsqlServer = startDatabaseServerFromPath(databaseFolder);
		} catch (final Exception e) {
			if (hsqlServer != null) {
				hsqlServer.stop();
				hsqlServer = null;
			}
		}

	}
}

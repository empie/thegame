package net.empuly.thegame.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.hsqldb.Server;

public class TheGameDatabase {
	private static final String DEFAULT_DATABASE_PATH = "C:/development/resources/hsqldb/";

	public static void main(final String[] args) throws	ClassNotFoundException, SQLException {
		File databaseFolder = determineDatabasePath(args);
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
		if (databaseFolder == null || !databaseFolder.exists()) {
			databaseFolder = new File(DEFAULT_DATABASE_PATH);
		}
		return databaseFolder;
	}

	private static void startDatabaseServerFromPathAndRunScripts(File databaseFolder) throws ClassNotFoundException, SQLException {
		Server hsqlServer = null;
		try {
			hsqlServer = startDatabaseServerFromPath(databaseFolder);
		}
		catch (Exception e) {
			// Closing the server
			if (hsqlServer != null) {
				hsqlServer.stop();
				hsqlServer = null;
			}
		}
		if(hsqlServer != null) {
			//executeScripts(databaseFolder);			
		}
		
	}

	private static void executeScripts(File databaseFolder) throws ClassNotFoundException, SQLException {
		Connection connection = null;

		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:file:"+ databaseFolder.getAbsolutePath()+ File.separator +"thegame", "sa", "");
			connection.prepareStatement("create table spelSnapshot (spelId VARCHAR(36), tijdstipAangemaakt TIMESTAMP, status TINYINT);").execute();
			connection.prepareStatement("insert into spelSnapshot(spelId, tijdstipAangemaakt, status) values (" +
					"'" +UUID.randomUUID().toString() +"'," +
					"'2008-08-08 20:08:08'," +
					"1);").execute();
			final ResultSet rs = connection.prepareStatement("select * from spelSnapshot;").executeQuery();
			rs.next();
			System.out.println("Id: " + rs.getString(1) + " tijdstip: "+ rs.getTimestamp(2));
		} finally {
			// Closing the connection
			if (connection != null) {
				connection.close();
			}

		}
	}

	private static Server startDatabaseServerFromPath(File databaseFolder) {
		Server hsqlServer;
		hsqlServer = new Server();
		hsqlServer.setDaemon(true);
		hsqlServer.setDatabaseName(0, "thegame");
		hsqlServer.setDatabasePath(0, "file:" + databaseFolder.getAbsolutePath()+ File.separator +"thegame");

		// Start the database!
		hsqlServer.start();
		return hsqlServer;
	}
}

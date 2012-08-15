package net.empuly.thegame.db;

import java.io.IOException;
import java.util.Properties;

import org.dbmaintain.DbMaintainer;
import org.dbmaintain.MainFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class TheGameDatabaseUpdater {
	
	public static void main(String[] args) throws IOException {
		Resource resource = new ClassPathResource("dbmaintainer.properties");
		Properties dbMaintainerProperties = PropertiesLoaderUtils.loadProperties(resource);
		System.out.println(dbMaintainerProperties);
		MainFactory mainFactory = new MainFactory(dbMaintainerProperties);
		DbMaintainer dbMaintainer = mainFactory.createDbMaintainer();
		dbMaintainer.updateDatabase(false);
	}
	
}

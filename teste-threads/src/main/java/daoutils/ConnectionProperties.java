package daoutils;

import java.io.InputStream;
import java.util.Properties;

public class ConnectionProperties {

	public Properties getConnectionProperties() {
		try {
			Properties p = new Properties();
			InputStream in = getClass().getClassLoader().getResourceAsStream("connection.properties");
			p.load(in);
			return p;
		} catch (Exception e) {
			return null;
		}
	}

}

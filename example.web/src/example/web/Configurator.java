package example.web;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.*;

@Component
public class Configurator {

	ConfigurationAdmin configAdmin;

	@Reference
	protected void setConfigurationAdmin(ConfigurationAdmin configurationAdmin) {
		this.configAdmin = configurationAdmin;
	}

	protected void unsetConfigurationAdmin(ConfigurationAdmin configurationAdmin) {
		this.configAdmin = null;
	}

	@Activate
	public void start() throws IOException {
		configureJAXRS();
	}

	private void configureJAXRS() throws IOException {
		Configuration configuration = configAdmin.getConfiguration("com.eclipsesource.jaxrs.connector", null);
		Dictionary<String, Object> props = new Hashtable<>();

		props.put("root", "/api");
		configuration.update(props);
	}
	
}

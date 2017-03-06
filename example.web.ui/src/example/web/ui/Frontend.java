package example.web.ui;

import org.osgi.service.component.annotations.*;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Frontend {
	
	private static Logger logger = LoggerFactory.getLogger(Frontend.class);
	
	//HttpService httpService;

	@Reference
	protected void setHttpService(HttpService httpService) {
		//this.httpService = httpService;
		try {
			httpService.registerResources("/", "/", new FrontendContext(httpService));
		} catch (NamespaceException e) {
			logger.error("Frontend endpoint registration failed.", e);
		}
	}

	protected void unsetHttpService(HttpService httpService) {
		httpService.unregister("/");
		//this.httpService = null;
	}
	
	@Activate
	public void start(){
		logger.info("ui actived");
	}
	
	@Deactivate
	public void stop(){
		logger.info("ui deactivated");
	}
	
}

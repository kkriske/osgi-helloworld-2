package example.web.ui;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrontendContext implements HttpContext {
	
	Logger logger = LoggerFactory.getLogger(FrontendContext.class);

	private final HttpContext base;

	public FrontendContext(HttpService httpService) {
		this.base = httpService.createDefaultHttpContext();
	}

	@Override
	public URL getResource(String name) {
		
		logger.info("Name is: " + name);
		//if("/".equals(name))
		//	name+="index.html";
		//return base.getResource("/app" + name);
		if (name.isEmpty() || "/".equals(name)) name += "index.html";
        return base.getResource("/app" + name);
	}

	@Override
	public boolean handleSecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return base.handleSecurity(request, response);
	}

	@Override
	public String getMimeType(String name) {
		return base.getMimeType(name);
	}

}

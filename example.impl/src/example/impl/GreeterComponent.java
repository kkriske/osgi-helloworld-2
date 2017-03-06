package example.impl;

import example.api.Greeter;
import org.osgi.service.component.annotations.*;

@Component
public class GreeterComponent implements Greeter {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}

package example.rest.impl;

import example.rest.api.GreeterResource;
import example.api.Greeter;

import org.osgi.service.component.annotations.*;

@Component
public class GreeterResourceImpl implements GreeterResource {
	
	Greeter greeter;
	
	@Reference
	public void setGreeter(Greeter greeter) {
		this.greeter = greeter;
	}
	
	@Override
	public String hello(String name) {
		return greeter.sayHello(name);
	}

}

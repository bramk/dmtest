package servicefactory.api;

public class HelloWorldService implements HelloWorld {

	@Override
	public String sayIt(String arg) {
		return "Hello " + arg;
	}
}

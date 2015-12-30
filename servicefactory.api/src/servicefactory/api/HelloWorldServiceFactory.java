package servicefactory.api;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class HelloWorldServiceFactory implements ServiceFactory<HelloWorld> {

	private final Map<ServiceRegistration<HelloWorld>, HelloWorldService> m_services = new HashMap<>();

	public void stop() {
		synchronized (m_services) {
			if (!m_services.isEmpty()) {
				throw new IllegalStateException("All services should be closed");
			}
		}
	}

	@Override
	public HelloWorld getService(Bundle bundle, ServiceRegistration<HelloWorld> registration) {
		HelloWorldService service = new HelloWorldService();
		synchronized (m_services) {
			HelloWorldService old = m_services.put(registration, service);
			assert old == null;
		}
		return service;
	}

	@Override
	public void ungetService(Bundle bundle, ServiceRegistration<HelloWorld> registration, HelloWorld service) {
		synchronized (m_services) {
			HelloWorldService old = m_services.remove(registration);
			assert service == old;
		}
	}
}

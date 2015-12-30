package servicefactory.dm4;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import servicefactory.api.HelloWorld;
import servicefactory.api.HelloWorldServiceFactory;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager) throws Exception {
		Dictionary<String, Object> props = new Hashtable<>();
		props.put("dm", "dm4");
		manager.add(createComponent().setInterface(HelloWorld.class.getName(), props)
				.setImplementation(new HelloWorldServiceFactory()));
	}

	@Override
	public void destroy(BundleContext context, DependencyManager manager) throws Exception {
	}

}

package servicefactory.itest;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import servicefactory.api.HelloWorld;

@RunWith(MockitoJUnitRunner.class)
public class ServiceFactoryTest {

	private final BundleContext context = FrameworkUtil.getBundle(ServiceFactoryTest.class).getBundleContext();

	@Test
	public void before() throws Exception {
		System.out.println("---------- Listing bundles ----------------------");
		for (Bundle b : context.getBundles()) {
			System.out.println("* " + b.getSymbolicName() + "/" + b.getVersion());
		}
	}

	@Test
	public void testDm3() throws Exception {
		System.out.println("---------- Running DM3 test ----------------------");
		Collection<ServiceReference<HelloWorld>> refs = context.getServiceReferences(HelloWorld.class, "(dm=dm3)");
		HelloWorld service = context.getService(refs.iterator().next());
		System.out.println(service.sayIt("dm3"));
		for (Bundle b : context.getBundles()) {
			if (b.getSymbolicName().equals("servicefactory.dm3")) {
				b.stop();
			}
		}
	}

	@Test
	public void testDm4() throws Exception {
		System.out.println("---------- Running DM4 test ----------------------");
		Collection<ServiceReference<HelloWorld>> refs = context.getServiceReferences(HelloWorld.class, "(dm=dm4)");
		HelloWorld service = context.getService(refs.iterator().next());
		System.out.println(service.sayIt("DM4"));
		for (Bundle b : context.getBundles()) {
			if (b.getSymbolicName().equals("servicefactory.dm4")) {
				b.stop();
			}
		}
	}
}
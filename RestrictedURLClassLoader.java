import java.net.URL;
import java.net.URLClassLoader;

public class RestrictedURLClassLoader extends URLClassLoader {
    public RestrictedURLClassLoader(URL[] urls) {
	super(urls, null);
    }

    public Class loadClass(String name) throws ClassNotFoundException {
	Class cls = super.loadClass(name);

	if (cls == null) {
	    throw new ClassNotFoundException(
	    "Restricted ClassLoader" +
	    " is unable to find class; " + name);
	}
	return(cls);
    }
}

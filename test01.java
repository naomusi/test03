import java.io.*;
import java.net.URL;

class test01 {
    public static void main(String args[]) throws Exception {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String line = null;
	while((line=br.readLine()) != null) {
	    ClassLoader ctxcls = Thread.currentThread().getContextClassLoader();
	    URL url = ctxcls.getResource(line);
	    if (url == null) {
		return;
	    }

	    URL[] urls = null;
	    urls = new URL[1];
	    urls[0] = url;

	    RestrictedURLClassLoader urlClassLoader =
		new RestrictedURLClassLoader(urls);

	    Class<?>cls = urlClassLoader.loadClass("sample");
	    if (cls == null) {
		return;
	    }
	    
	    Object argument[] = new Object[]{args};
	    java.lang.reflect.Method method = cls.getMethod("main",String[].class);
	    method.invoke(null,argument);
	}
    }
}

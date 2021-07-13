package sun.net.www.protocol.x;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class XURLConnection extends URLConnection {

    private final ClassPathResource resource;

    @Override
    public void connect() throws IOException {

    }

    // x:///META-INF/default.properties
    public XURLConnection(URL u) {
        super(u);
        this.resource = new ClassPathResource(u.getPath());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return resource.getInputStream();
    }
}

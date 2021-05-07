package com.artim.disclaimer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class MyController {

    @Autowired
    Environment environment;

    @GetMapping("/")
    public String sayHello() throws UnknownHostException {

        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">" + "\n";
        html += "<html>" + "\n";
        html += "<head>" + "\n";
        html += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />" + "\n";
        html += "<title>Qlik Proxy Node</title>" + "\n";
        html += "</head>" + "\n";
        html += "<body>" + "\n";
        html += "<h1>Qlik Proxy Node</h1>" + "\n";
        html += "<hr>" + "\n";
        String host = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("server.port");
        html += "<h2>" + host + ":" + port + "</h3>" + "\n";
        html += "</body>" + "\n";
        html += "</html>";

        return html;
    }
}

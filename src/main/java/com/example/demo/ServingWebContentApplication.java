package com.example.demo;

import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ServingWebContentApplication extends SpringBootServletInitializer {

  static {
		System.setProperty("java.security.krb5.conf",	Paths.get("/etc/krb5.conf").normalize().toAbsolutePath().toString());
    System.setProperty("java.security.krb5.realm","POTTMEIER.DE");
		System.setProperty("sun.security.krb5.debug", "true");
		// disable usage of local kerberos ticket cache
		System.setProperty("http.use.global.creds", "false");
	}
  
  
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
    return builder.sources(ServingWebContentApplication.class);
  }





    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

}
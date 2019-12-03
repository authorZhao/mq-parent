package com.git;

import com.git.config.RootConfig;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletException;
import java.io.File;

public class RumServer {

    public static void main(String[] args) throws ServletException, LifecycleException {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(9090);
      /*  StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(
                webappDirLocation).getAbsolutePath());
        ctx.setReloadable(false);
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources,
                "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(),
                "/"));*/
        //initializer.onStartup(ctx);
        tomcat.start();
        tomcat.getServer().await();


    }



}

package com.epam.newsPortal.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class SpringWebAppServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
//        XmlWebApplicationContext context = new XmlWebApplicationContext();
//        context.setConfigLocation("/WEB-INF/spring/appconfig-root.xml");
//        ServletRegistration.Dynamic dispatcher = aServletContext.addServlet("dispatcher", new DispatcherServlet(context));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
    }
}


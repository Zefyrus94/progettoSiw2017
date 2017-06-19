//package it.uniroma3.spring.security;
//
//import java.util.Properties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//
//@Configuration
//public class ExpConfig {
//
//    @Bean(name = "simpleMappingExceptionResolver")
//    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
//        SimpleMappingExceptionResolver resolver= new SimpleMappingExceptionResolver();
//
//        Properties mappings = new Properties();
//        resolver.setExceptionMappings(mappings); // None by default
//        resolver.setExceptionAttribute("ErrorOccurred"); // Default is "exception"
//        resolver.setDefaultErrorView("500"); // 500.jsp
//        return resolver;
//    }
//
//}
package kg.gov.tunduk.demoproducer.configuration;

import kg.gov.tunduk.xroad.XRoadConfiguration;
import kg.gov.tunduk.xroad.XRoadWsdlDefinition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class ProducerConfig extends XRoadConfiguration {

    @SuppressWarnings("unchecked")
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet);
    }

    @Bean(name = "getPersonByPin")
    public XRoadWsdlDefinition personWsdl(@Qualifier("personSchema") XsdSchema personSchema) {
        XRoadWsdlDefinition wsdl = new XRoadWsdlDefinition();
        wsdl.setPortTypeName("PersonPort");
        wsdl.setLocationUri("getPersonByPin");
        wsdl.setTargetNamespace("http://tunduk.gov.kg");
        wsdl.setSchema(personSchema);
        return wsdl;
    }

    @Bean("personSchema")
    public XsdSchema personSchema() {
        return new SimpleXsdSchema(new ClassPathResource("person.xsd"));
    }
}

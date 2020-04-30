package test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWordTest1 {

    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext(
            "C:\\workspace\\search-spring-mvc\\src\\main\\resources\\test\\SpringTest1.xml");

        SpringBean1 bean = (SpringBean1) context.getBean("helloWorld");
        bean.show();
    }
}

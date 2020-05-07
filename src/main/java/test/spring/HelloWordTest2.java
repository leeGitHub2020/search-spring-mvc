package test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWordTest2 {

    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext(
            "C:\\workspace\\search-spring-mvc\\src\\main\\resources\\test\\SpringTest2.xml");

        SpringBean2 bean = (SpringBean2) context.getBean("helloWorld");
        bean.show();
    }
}

package test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWordTest3 {

    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext(
            "C:\\workspace\\search-spring-mvc\\src\\main\\resources\\test\\SpringTest3.xml");

        SpringBean3 bean = (SpringBean3) context.getBean("helloWorld");
        try {
            bean.insertUpdate();
        } catch (Exception e) {
            System.out.println("例外発生:" + e.toString());
        }
        bean.show();
    }
}

package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jDemo {
    public static void main(String[] args) {

        Logger log = null;



        try {

            // 初始化日志生成器，加载日志配置文件

            PropertyConfigurator.configure("C:\\\\workspace\\\\search-spring-mvc\\\\src\\\\main\\\\resources\\log4j.properties");

            log = Logger.getLogger(Log4jDemo.class.getName());



            log.debug("main");

            int i = 1 / 0;

        } catch (Exception e) {

            // 记录日志

            log.info(e.getMessage());

            // e.printStackTrace();

        }

    }
}

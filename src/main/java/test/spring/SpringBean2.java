package test.spring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringBean2 {

    @Autowired
    private UserDaoImpl dao;

    public void show() {

        List<User> list = dao.getUserList();
        for (User user : list) {
            System.out.println(user.getId() + "-" + user.getName());
        }
    }

}

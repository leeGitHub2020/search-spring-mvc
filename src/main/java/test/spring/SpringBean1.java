package test.spring;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringBean1 {

    @Autowired
    UserMapper userMapper;

    public void show() {

        List<Map<String, String>> mapList = userMapper.getUserMap();
        for (Map<String, String> map : mapList) {
            System.out.println(map.get("id") + "+" + map.get("name"));
        }

    }
}

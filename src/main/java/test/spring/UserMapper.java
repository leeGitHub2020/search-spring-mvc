package test.spring;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT id, name FROM m_user")
    List<Map<String, String>> getUserMap();
}

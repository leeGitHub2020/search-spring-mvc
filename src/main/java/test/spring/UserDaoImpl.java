package test.spring;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl {

    private SqlSession session;

    public void setSession(SqlSession ss) {
        this.session = ss;
    }

    public List<User> getUserList() {
        return session.selectList("test.sql.selectUser");
    }
}

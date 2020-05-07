package test.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import com.search.dlayer.entity.MUser;

public class SpringBean3 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void insertUpdate() {
        MUser user = new MUser();

        System.out.println("追加します");
        user.setId("0005");
        user.setName("新規追加");
        jdbcTemplate.update("insert into m_user(id, name) values(? , ?)", user.getId(), user.getName());

        System.out.println("更新します");
        user.setName("更新");
        jdbcTemplate.update("update m_userXX set name = ? where id = ?", user.getName(), user.getId());
    }

    public void show() {

        List<MUser> list = jdbcTemplate.query("select * from m_user", new RowMapper<MUser>() {
            public MUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                MUser user = new MUser();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        for (MUser user : list) {
            System.out.println(user.getId() + "-" + user.getName());
        }
    }

}

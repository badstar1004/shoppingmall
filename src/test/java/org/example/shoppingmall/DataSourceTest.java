package org.example.shoppingmall;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() {
        // given
        // when
        try (Connection connection = dataSource.getConnection()) {
            // then
            assertNotNull("connection not null", connection);
        } catch (Exception e) {
            fail("connection failed: " + e.getMessage());
        }
    }
}

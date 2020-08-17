package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author Harlan
 * @date 2020/8/17 15:11
 */
public class JdbcConfiguration {

    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource ds){
        return new QueryRunner(ds);
    }

    @Bean(name = "ds")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
            ds.setUser("root");
            ds.setPassword("Hhn004460");
            return ds;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return null;
        }
    }
}

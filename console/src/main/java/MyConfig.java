import com.beadando.BdDAOJson;
import com.beadando.dao.BdDAO;
import com.beadando.dao.relational.BdDAORelational;
import com.beadando.service.impl.BdServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan("com.beadando.controller")
public class MyConfig {
    @Bean(name = "DBDAO")
    public BdDAORelational relationaldb(){
        return  new BdDAORelational();
    }

    @Qualifier("jsonDBDAO")
    @Bean
    public BdDAO jsondb(){
        try{
            return new BdDAOJson("Bd.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public BdServiceImpl bdService(BdDAO DBDAO){
        return  new BdServiceImpl(DBDAO);
    }
}

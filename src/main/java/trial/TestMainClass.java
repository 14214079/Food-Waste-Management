package trial;

//import org.apache.tomcat.jdbc.pool.DataSource;
//import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TestMainClass {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(TestMainClass.class, args);

	}

}

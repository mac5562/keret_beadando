import com.beadando.controller.BdController;
import com.beadando.service.BdService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args){

        ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
         BdController controller= (BdController) context.getBean("bdController");
        //controller.printAll();
    }
}

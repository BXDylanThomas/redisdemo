import com.dylan.controller.StudentController;
import com.dylan.dao.StudentDao;
import com.dylan.model.Student;
import com.dylan.service.StudentService;
import com.dylan.service.impl.StudentImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@ContextConfiguration(locations = "classpath:application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    @Test
    public  void main() {
//
//        StudentService studentService=new StudentImpl();
//        studentService.getStudent();

        StudentController studentController=new StudentController();
        studentController.test();
    }
}

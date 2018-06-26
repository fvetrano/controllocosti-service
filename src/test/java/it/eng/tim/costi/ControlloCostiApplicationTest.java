package it.eng.tim.costi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by alongo on 13/04/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControlloCostiApplication.class)
public class ControlloCostiApplicationTest {

    @Test
    public void contextLoads() {
    }

    @Test
    public void applicationMainTest() {
    	ControlloCostiApplication.main(new String[] {});
    }

}
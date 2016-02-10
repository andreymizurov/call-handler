package by.avmiz;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Abstract test class with Spring context.
 *
 * @author avmiz created 10.02.2016 at 10:34.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/rootApp-context.xml")
public abstract class ServiceTest {

}

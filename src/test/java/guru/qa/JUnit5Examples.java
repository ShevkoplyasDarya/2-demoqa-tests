package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll()");
        Configuration.browser = "chrome";

    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("        beforeEach()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("        afterEach()");
    }

    @Test
    void firstTest() {
        System.out.println("            firstTest()");
        Assertions.assertTrue(3 > 2); // from JUnit

    }

    @Test
    void secondTest() {
        System.out.println("            secondTest()");
        Assertions.assertTrue(3 > 2); // from JUnit

    }

    @Test
    void thirdTest() {
        System.out.println("            thirdTest()");
        Assertions.assertTrue(3 > 2); // from JUnit

    }
}

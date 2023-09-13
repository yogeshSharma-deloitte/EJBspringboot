package com.hashedin.migration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EjbToSpringBootApplicationTest {

    @MockBean
    private EjbToSpringBootApplication ejbToSpringBootApplication;

    @Test
    public void contextLoads() {
        assertNotNull(ejbToSpringBootApplication);
    }

    @Test
    public void main() {
        EjbToSpringBootApplication.main(new String[] {});
        assertTrue(true);
    }
}
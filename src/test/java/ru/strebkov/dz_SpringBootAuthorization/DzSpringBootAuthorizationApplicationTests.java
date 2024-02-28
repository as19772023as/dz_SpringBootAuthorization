package ru.strebkov.dz_SpringBootAuthorization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@DisplayName("Проверка авторизации")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DzSpringBootAuthorizationApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final GenericContainer<?> devContainer = new GenericContainer<>("authorizationapp")
            .withExposedPorts(8080);
    private static final String ENDPOINT = "/authorize?user=Ana&password=123";

    @BeforeAll
    public static void setUp() {
        devContainer.start();
    }

    @Test
    @DisplayName("Тест на вход")
    void contextLoads() {
        Integer devPort = devContainer.getMappedPort(8080);
        final String expected = "[\"READ\",\"WRITE\",\"DELETE\"]";

        ResponseEntity<String> actual = restTemplate.getForEntity("http://localhost:" + devPort + ENDPOINT, String.class);

        System.out.println("actual =   " + actual.getBody());
        Assertions.assertEquals(expected, actual.getBody());
    }
    
}

package com.immuniti.function.email;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@SpringBootTest(classes = EmailApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmailApplicationTests {

    @Autowired
    private TestRestTemplate rest;

    @Test
    public void shouldConvertToUpperCase() throws Exception {
        ResponseEntity<String> result = this.rest.exchange(
                RequestEntity.post(new URI("/uppercase")).body("hello"), String.class);
        Assertions.assertThat(result.getBody()).isEqualTo("HELLO");
    }

}

package br.gov.sc.sctec.empreendedorismo.backend.api;

import br.gov.sc.sctec.empreendedorismo.backend.api.dto.SegmentoToSaveDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class SegmentoControllerTests {

    @Autowired
    private RestTestClient restTestClient;

    @Test
    @Order(1)
	void readAllTest() {
        log.info("---> readAllTest()");
        restTestClient
                .get()
                .uri("/api/v1/segmentos")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
	}

    @Test
    @Order(2)
    void readOneNotFoundTest() {
        log.info("---> readOneNotFoundTest()");
        restTestClient
                .get()
                .uri("/api/v1/segmentos/6")
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    @Order(3)
    @Rollback(false)
    void createOneTest() {
        log.info("---> createOneTest()");
        SegmentoToSaveDto dto = new SegmentoToSaveDto(
                "Novo segmento"
        );
        restTestClient
                .post()
                .uri("/api/v1/segmentos")
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    @Order(4)
    void readOneTest() {
        log.info("---> readOneTest()");
        restTestClient
                .get()
                .uri("/api/v1/segmentos/6")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    @Order(5)
    @Rollback(false)
    void updateOneTest() {
        log.info("---> updateOneTest()");
        SegmentoToSaveDto dto = new SegmentoToSaveDto(
                "Nome alterado"
        );
        restTestClient
                .put()
                .uri("/api/v1/segmentos/6")
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    @Order(8)
    @Rollback(false)
    void deleteOneTest() {
        log.info("---> deleteOneTest()");
        restTestClient
                .delete()
                .uri("/api/v1/segmentos/6")
                .exchange()
                .expectStatus()
                .isNoContent();
    }

    @Test
    @Order(9)
    void readOneNotFoundAfterDeleteTest() {
        log.info("---> readOneNotFoundAfterDeleteTest()");
        restTestClient
                .get()
                .uri("/api/v1/segmentos/6")
                .exchange()
                .expectStatus()
                .isNotFound();
    }

}

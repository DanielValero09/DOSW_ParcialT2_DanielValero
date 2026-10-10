package edu.dosw.parcial.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.dosw.parcial.main.ParcialApplication;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = ParcialApplication.class, properties = {
        "spring.data.mongodb.uri=mongodb://localhost:27017/dosw_parcial_test?serverSelectionTimeoutMS=1000",
        "JWT_SECRET=test-only-placeholder",
        "logging.level.org.mongodb.driver=OFF",
        "logging.level.org.springframework.boot.autoconfigure.security=OFF"
})
@AutoConfigureMockMvc
class SecurityConfigurationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private List<SecurityFilterChain> filterChains;

    @Test
    void swaggerUiDebeSerPublico() throws Exception {
        mockMvc.perform(get("/swagger-ui/index.html"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @Test
    void openApiJsonDebeSerPublicoYDocumentarHealth() throws Exception {
        mockMvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.info.title").value("DOSW Parcial T2 - API"))
                .andExpect(jsonPath("$.paths['/api/v1/health'].get").exists());
    }

    @Test
    void openApiYamlDebeSerPublico() throws Exception {
        mockMvc.perform(get("/v3/api-docs.yaml"))
                .andExpect(status().isOk());
    }

    @Test
    void otrasRutasDebenRechazarSolicitudesAnonimas() throws Exception {
        mockMvc.perform(get("/api/v1/recurso-protegido"))
                .andExpect(status().isForbidden());
    }

    @Test
    void debeExistirUnaSolaCadenaDeSeguridad() {
        assertEquals(1, filterChains.size());
    }
}

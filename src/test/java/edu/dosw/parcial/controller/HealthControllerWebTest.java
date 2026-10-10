
package edu.dosw.parcial.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.dosw.parcial.config.SecurityConfig;
import edu.dosw.parcial.main.ParcialApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = HealthController.class,
        properties = "logging.level.org.springframework.boot.autoconfigure.security=OFF")
@ContextConfiguration(classes = ParcialApplication.class)
@Import(SecurityConfig.class)
class HealthControllerWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthDebeSerPublicoYRetornarHttp200() throws Exception {
        mockMvc.perform(get("/api/v1/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.service").value("DOSW-ParcialT2"));
    }
}


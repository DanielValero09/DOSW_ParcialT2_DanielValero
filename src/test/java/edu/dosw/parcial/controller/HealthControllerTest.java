package edu.dosw.parcial.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Map;
import org.junit.jupiter.api.Test;

class HealthControllerTest {

    @Test
    void healthDebeRetornarEstadoUpYNombreDelServicio() {
        HealthController controller = spy(new HealthController());

        Map<String, String> response = controller.health();

        assertEquals("UP", response.get("status"));
        assertEquals("DOSW-ParcialT2", response.get("service"));
        assertEquals(2, response.size());
        verify(controller).health();
    }
}

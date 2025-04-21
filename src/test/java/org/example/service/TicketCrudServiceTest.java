package org.example.service;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketCrudServiceTest {

    private static final TicketCrudService ticketService = new TicketCrudService();
    private static final ClientCrudService clientService = new ClientCrudService();

    @BeforeAll
    public static void initDb() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "")
                .locations("filesystem:src/main/resources/db/migration")
                .load();
        flyway.migrate();
    }

    @Test
    public void testCreateTicketWithInvalidClient() {
        assertThrows(IllegalArgumentException.class, () ->
                ticketService.createTicket(null, "EARTH", "MARS")
        );
        assertThrows(IllegalArgumentException.class, () ->
                ticketService.createTicket(999L, "EARTH", "MARS")
        );
    }

    @Test
    public void testCreateTicketWithInvalidPlanets() {
        Long validClientId = clientService.createClient("Yoda");

        assertThrows(IllegalArgumentException.class, () ->
                ticketService.createTicket(validClientId, null, "EARTH")
        );

        assertThrows(IllegalArgumentException.class, () ->
                ticketService.createTicket(validClientId, "INVALID", "EARTH")
        );

        assertThrows(IllegalArgumentException.class, () ->
                ticketService.createTicket(validClientId, "EARTH", "INVALID")
        );
    }
}

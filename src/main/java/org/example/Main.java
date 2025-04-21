package org.example;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();
        TicketCrudService ticketService = new TicketCrudService();

        clientService.createClient("Darth Vader");
        planetService.createPlanet("DEATHSTAR", "Death Star");
        planetService.createPlanet("TATOOINE", "Tatooine");

        Client client = clientService.getClient(1L).orElseThrow();
        Planet from = planetService.getPlanet("DEATHSTAR").orElseThrow();
        Planet to = planetService.getPlanet("TATOOINE").orElseThrow();

        ticketService.createTicket(client.getId(), from.getId(), to.getId());

        List<Ticket> allTickets = ticketService.getAllTickets();
        allTickets.forEach(System.out::println);

        if (!allTickets.isEmpty()) {
            ticketService.deleteTicket(allTickets.get(0));
        }
    }
}

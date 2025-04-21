package org.example.service;

import org.example.dao.ClientDao;
import org.example.dao.PlanetDao;
import org.example.dao.TicketDao;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TicketCrudService {

    private final TicketDao ticketDao = new TicketDao();
    private final ClientDao clientDao = new ClientDao();
    private final PlanetDao planetDao = new PlanetDao();

    public void saveTicket(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public Optional<Ticket> findTicketById(Long id) {
        return ticketDao.getById(id);
    }

    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }

    public void createTicket(Long clientId, String fromPlanetId, String toPlanetId) {
        Optional<Client> clientOptional = clientDao.getById(clientId);
        if (clientId == null || clientOptional.isEmpty()) {
            throw new IllegalArgumentException("Client not found");
        }

        Optional<Planet> fromPlanetOptional = planetDao.getById(fromPlanetId);
        if (fromPlanetId == null || fromPlanetOptional.isEmpty()) {
            throw new IllegalArgumentException("From planet not found");
        }

        Optional<Planet> toPlanetOptional = planetDao.getById(toPlanetId);
        if (toPlanetId == null || toPlanetOptional.isEmpty()) {
            throw new IllegalArgumentException("To planet not found");
        }

        Ticket ticket = new Ticket();
        ticket.setClient(clientOptional.get());
        ticket.setFromPlanet(fromPlanetOptional.get());
        ticket.setToPlanet(toPlanetOptional.get());
        ticket.setCreatedAt(LocalDateTime.now());

        ticketDao.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketDao.getAll();
    }
}

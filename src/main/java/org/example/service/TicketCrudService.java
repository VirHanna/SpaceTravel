package org.example.service;

import org.example.dao.TicketDao;
import org.example.model.Ticket;

import java.util.Optional;

public class TicketCrudService {

    private final TicketDao ticketDao = new TicketDao();

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
}

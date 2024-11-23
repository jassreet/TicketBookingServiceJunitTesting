package com.infotech.book.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.TicketBookingDao;
import com.infotech.book.ticket.app.entities.Ticket;

import java.util.Optional;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingDao ticketBookingDao;
    
    // Create a new ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketBookingDao.save(ticket);
    }

    // Get a ticket by its ID (using findById)
    public Ticket getTicketById(Integer ticketId) {
        Optional<Ticket> ticketOptional = ticketBookingDao.findById(ticketId); // Use findById instead of findOne
        if (ticketOptional.isPresent()) {
            return ticketOptional.get(); // Return the ticket if found
        } else {
            throw new RuntimeException("Ticket not found with id " + ticketId); // Handle not found scenario
        }
    }

    // Get all booked tickets
    public Iterable<Ticket> getAllBookedTickets() {
        return ticketBookingDao.findAll();
    }

    // Delete a ticket by ID (using deleteById)
    public void deleteTicket(Integer ticketId) {
        ticketBookingDao.deleteById(ticketId); // Use deleteById instead of delete
    }

    // Update an existing ticket's email
    public Ticket updateTicket(Integer ticketId, String newEmail) {
        Optional<Ticket> ticketOptional = ticketBookingDao.findById(ticketId); // Use findById instead of findOne
        if (ticketOptional.isPresent()) {
            Ticket ticketFromDb = ticketOptional.get();
            ticketFromDb.setEmail(newEmail); // Update email
            return ticketBookingDao.save(ticketFromDb); // Save updated ticket
        } else {
            throw new RuntimeException("Ticket not found with id " + ticketId); // Handle not found scenario
        }
    }

    // Get a ticket by email
    public Ticket getTicketByEmail(String email) {
        return ticketBookingDao.findByEmail(email);
    }
}

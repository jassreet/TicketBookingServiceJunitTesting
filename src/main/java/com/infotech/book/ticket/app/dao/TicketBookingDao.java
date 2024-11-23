package com.infotech.book.ticket.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;  // Use JpaRepository instead of CrudRepository

import com.infotech.book.ticket.app.entities.Ticket;

public interface TicketBookingDao extends JpaRepository<Ticket, Integer> {
    Ticket findByEmail(String email);  // Custom query to find ticket by email
}

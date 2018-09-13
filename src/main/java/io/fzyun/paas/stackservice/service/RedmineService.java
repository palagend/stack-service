package io.fzyun.paas.stackservice.service;

import io.fzyun.paas.stackservice.model.Ticket;

public interface RedmineService {
    Ticket fetchTicket(String ticketId);
}

package com.oop.module2;

public class Main {
    static void main(String[] args) {
        IO.println("Hello OOP Session 2 - Class Hierarchy Design!\n");

        Ticket[] tickets = {
                new SupportTicket(101, "Chandler", "Normal", "Open", 8, "Premium"),
                new SupportTicket(102, "Monica", "High", "Open", 8, "Basic"),
                new BugTicket(103, "Ross", "Low", "Open", 8, 4),
                new BugTicket(104, "Rachel", "Normal", "Open", 8, 2),
                new MaintenanceTicket(105, "Phoebe", "Normal", "Open", 12.0, 3, true),
                new MaintenanceTicket(106, "Joey", "High", "Open", 12.0, 3, false)
        };

        System.out.println("ALL TICKETS");
        for (Ticket ticket : tickets) {
            System.out.println(ticket.summary());
        }

        System.out.println("\nAT RISK");
        for (Ticket ticket : tickets) {
            if (ticket.isAtRisk()) {
                System.out.println("#" + ticket.getCode() + " - " + ticket.getSeverity());
            }
        }

        System.out.println("\nCLOSING ALL TICKETS");
        for (Ticket ticket : tickets) {
            ticket.setStatus("Closed");
            System.out.println(ticket + " -> " + ticket.getStatus());
        }
    }
}

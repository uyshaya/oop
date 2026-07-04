package com.oop;

import java.util.Objects;

public class Main {
    static void main() {
        IO.println("Hello OOP Session 1 - Encapsulation!\n");

        // 5 objects and store them in an array
        TaskTicket[] tickets = {
                new TaskTicket(1, "OOP Tester 1", "High", "To do", 3),
                new TaskTicket(2, "OOP Tester 2", "High", "To do", 3),
                new TaskTicket(3, "OOP Tester 3", "Normal", "To do", 2),
                new TaskTicket(4, "OOP Tester 4", "Normal", "To do", 2),
                new TaskTicket(5, "OOP Tester 5", "Low", "To do", 1)
        };

        // Iterate through the array
        for (TaskTicket ticket : tickets) {

            // use getters for display
            IO.println("Ticket " + ticket.getCode());
            IO.println("  Owner: " + ticket.getOwner());
            IO.println("  Allocated time: " + ticket.getAllocatedTimeInHours() + "h");

            // use setters, getters, and business methods
            boolean urgent = ticket.isUrgent();
            IO.println("  URGENT: " + urgent);
            IO.println("  Priority: " + ticket.getPriority());
            if (urgent) {
                ticket.extendAllocatedTime(5);
                IO.println("  Allocated time extended to: " + ticket.getAllocatedTimeInHours() + "h");
                ticket.setStatus("Doing");
                IO.println("  Status set to: " + ticket.getStatus());
                IO.println("  Must-have in this version!");
            } else if (Objects.equals(ticket.getPriority(), "Low")) {
                ticket.setAllocatedTimeInHours(0);
                IO.println("  Put in backlog!");
            } else {
                ticket.extendAllocatedTime(1);
                IO.println("  Allocated time extended to: " + ticket.getAllocatedTimeInHours() + "h");
                IO.println("  Nice-to-have in this version!");
            }

            IO.println();
        }
    }
}

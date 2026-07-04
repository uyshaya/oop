package com.oop;

public class Main {
    static void main() {
        IO.println("Hello OOP Session 1 - Encapsulation!");

        final var taskTicket = new TaskTicket(1, "OOP Test", "High", "To do", 0);
        // toString - print readable data
        IO.println("\n" + taskTicket);
        // getters
        IO.println("\n**Methods (Getters and Setters)**");
        IO.println(taskTicket.getAllocatedTimeInHours());
        IO.println(taskTicket.getCode());
        IO.println(taskTicket.getOwner());
        IO.println(taskTicket.getPriority());
        IO.println(taskTicket.getStatus());
        // setters
        taskTicket.setOwner("OOP Test");
        taskTicket.setAllocatedTimeInHours(1);
        taskTicket.setStatus("Done");
        // first business method
        IO.println(taskTicket.isUrgent());
        // second business method
        taskTicket.extendAllocatedTime(1.5);
        // toString again to compare
        IO.println("\n" + taskTicket);
    }
}

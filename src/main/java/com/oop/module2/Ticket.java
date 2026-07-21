package com.oop.module2;

/**
 * Abstract base class for every kind of ticket in a ticket tracking system (i.e. Jira, Redmine).
 */
public abstract class Ticket {

    private int code;
    private String owner;
    private String priority;
    private String status;
    private double allocatedTimeInHours;

    /**
     * Constructs a Ticket with the details shared by all ticket types.
     *
     * @param code                 the ticket number
     * @param owner                the person responsible for the ticket
     * @param priority             the ticket's priority level ("High", "Normal", "Low")
     * @param status               the current status ("Open", "In-progress", "Closed", "Rejected")
     * @param allocatedTimeInHours the time allocated to the ticket, in hours
     */
    public Ticket(int code,
                  String owner,
                  String priority,
                  String status,
                  double allocatedTimeInHours) {
        this.code = code;
        this.owner = owner;
        this.priority = priority;
        this.status = status;
        this.allocatedTimeInHours = allocatedTimeInHours;
    }

    /**
     * Returns the ticket's code.
     *
     * @return the ticket code
     */
    public int getCode() {
        return code;
    }

    /**
     * Returns the ticket's owner.
     *
     * @return the owner name
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Returns the ticket's priority
     *
     * @return the ticket priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Returns the ticket's status.
     *
     * @return the current status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the ticket's status if the provided value is not null or empty.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        if (status != null && !status.isEmpty()) {
            this.status = status;
        }
    }

    /**
     * Returns the time allocated to the ticket.
     *
     * @return the allocated time in hours
     */
    public double getAllocatedTimeInHours() {
        return allocatedTimeInHours;
    }

    /**
     * Abstract method: Returns how many hours the ticket may stay open before it breaches
     * its service target. Each ticket type computes this differently.
     *
     * @return the resolution deadline in hours
     */
    public abstract double getResolutionDeadlineInHours();

    /**
     * Abstract method: Returns the severity label for this ticket.
     *
     * @return the severity, for example "Critical"
     */
    public abstract String getSeverity();

    /**
     * Concrete method: Checks whether the allocated time already exceeds the deadline.
     *
     * @return {@code true} if the ticket is at risk of breaching its target
     */
    public boolean isAtRisk() {
        return allocatedTimeInHours > getResolutionDeadlineInHours();
    }

    /**
     * Concrete method: Builds a one-line summary of the ticket.
     * The format is the same for every ticket type; only the values differ.
     *
     * @return the formatted summary
     */
    public String summary() {
        return String.format("#%d %-10s %-12s %-12s %-18s %5.1fh / %5.1fh %s",
                code, owner, status, priority, getSeverity(),
                allocatedTimeInHours, getResolutionDeadlineInHours(),
                isAtRisk() ? "[AT RISK]" : "");
    }

    /**
     * Returns a string representation of the ticket.
     *
     * @return a formatted string describing the ticket
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{code=" + code +
                ", owner='" + owner + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", allocatedTimeInHours=" + allocatedTimeInHours +
                '}';
    }
}

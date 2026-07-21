package com.oop.module1;

/**
 * Represents a task ticket in a ticket tracking system (i.e. Jira, Redmine)
 * Encapsulation - keep all fields private and expose only what is necessary (getters, setters, and/or other methods)
 */
public class TaskTicket {

    private int code;
    private String owner;
    private String priority;
    private String status;
    private double allocatedTimeInHours;

    /**
     * Constructs a ticket based on the provided values.
     *
     * @param code                 the ticket's unique identifier
     * @param owner                the ticket's owner (person name)
     * @param priority             the ticket's priority level
     * @param status               the ticket's status
     * @param allocatedTimeInHours the ticket's time allocated in hours to be completed
     */
    public TaskTicket(int code, String owner, String priority, String status, double allocatedTimeInHours) {
        this.code = code;
        this.owner = owner;
        this.priority = priority;
        this.status = status;
        this.allocatedTimeInHours = allocatedTimeInHours;
    }

    /**
     * Returns the ticket's code
     *
     * @return the ticket code
     */
    public int getCode() {
        return code;
    }

    /**
     * Returns the ticket's owner
     *
     * @return ticket owner
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
     * Returns the ticket's status
     *
     * @return the ticket status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the ticket's time allocated in hours
     *
     * @return the allocated time in hours
     */
    public double getAllocatedTimeInHours() {
        return allocatedTimeInHours;
    }

    /**
     * Sets the ticket's owner if the provided value is not null or empty.
     *
     * @param owner the owner name to set
     */
    public void setOwner(String owner) {
        if (owner != null && !owner.isEmpty()) {
            this.owner = owner;
        }
    }

    /**
     * Sets the ticket's status if the provided value is not null or empty.
     *
     * @param status the status ("To do", "Doing", "Done", "Rejected") to set
     */
    public void setStatus(String status) {
        if (status != null && !status.isEmpty()) {
            this.status = status;
        }
    }

    /**
     * Sets the ticket's allocated time in hours if the provided value is positive.
     *
     * @param allocatedTimeInHours the hours to set
     */
    public void setAllocatedTimeInHours(double allocatedTimeInHours) {
        if (allocatedTimeInHours > 0) {
            this.allocatedTimeInHours = allocatedTimeInHours;
        }
    }

    /**
     * Checks if the ticket is urgent based on its priority.
     *
     * @return {@code true} if the priority is "High" (case-insensitive),
     * {@code false} otherwise
     */
    public boolean isUrgent() {
        return "High".equalsIgnoreCase(this.priority);
    }

    /**
     * Extends the allocated time by the given number of hours if the provided value is positive.
     *
     * @param additionalHours the hours to add
     */
    public void extendAllocatedTime(double additionalHours) {
        if (additionalHours > 0) {
            this.allocatedTimeInHours += additionalHours;
        }
    }

    @Override
    public String toString() {
        return "TaskTicket{" +
                "code=" + code +
                ", owner='" + owner + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", allocatedTimeInHours=" + allocatedTimeInHours +
                '}';
    }
}

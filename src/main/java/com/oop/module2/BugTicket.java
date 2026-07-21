package com.oop.module2;

/**
 * A software defect ticket. Its deadline and severity come from the reported bug level.
 */
public class BugTicket extends Ticket {

    private int bugLevel;

    /**
     * Constructs a BugTicket.
     *
     * @param code                 the ticket number
     * @param owner                the person responsible for the ticket
     * @param priority             the ticket's priority level
     * @param status               the current status
     * @param allocatedTimeInHours the time allocated to the ticket, in hours
     * @param bugLevel             the defect level, 1 (worst) to 4 (cosmetic)
     */
    public BugTicket(int code,
                     String owner,
                     String priority,
                     String status,
                     double allocatedTimeInHours,
                     int bugLevel) {
        super(code, owner, priority, status, allocatedTimeInHours);
        this.bugLevel = bugLevel;
    }

    /**
     * Returns the defect level.
     *
     * @return the bug level
     */
    public int getBugLevel() {
        return bugLevel;
    }

    /**
     * Lower bug levels are more serious.
     *
     * @return the resolution deadline in hours
     */
    @Override
    public double getResolutionDeadlineInHours() {
        return bugLevel * 8.0;
    }

    /**
     * Returns the severity, based on the defect level.
     *
     * @return the severity label
     */
    @Override
    public String getSeverity() {
        return switch (bugLevel) {
            case 1 -> "Critical";
            case 2 -> "Major";
            case 3 -> "Minor";
            default -> "Cosmetic";
        };
    }
}

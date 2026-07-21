package com.oop.module2;

/**
 * A scheduled maintenance ticket. It is planned ahead of time, so its deadline is the
 * notice period rather than a service target.
 */
public class MaintenanceTicket extends Ticket {

    private int daysUntilWindow;
    private boolean requiresDowntime;

    /**
     * Constructs a MaintenanceTicket.
     *
     * @param code                 the ticket number
     * @param owner                the person responsible
     * @param status               the current status
     * @param allocatedTimeInHours the allocated time in hours
     * @param daysUntilWindow      days remaining before the maintenance window
     * @param requiresDowntime     whether the work requires a system downtime
     */
    public MaintenanceTicket(int code,
                             String owner,
                             String priority,
                             String status,
                             double allocatedTimeInHours,
                             int daysUntilWindow,
                             boolean requiresDowntime) {
        super(code, owner, priority, status, allocatedTimeInHours);
        this.daysUntilWindow = daysUntilWindow;
        this.requiresDowntime = requiresDowntime;
    }

    /**
     * Returns the days remaining before the maintenance window.
     *
     * @return the number of days
     */
    public int getDaysUntilWindow() {
        return daysUntilWindow;
    }

    /**
     * Returns whether the work requires downtime.
     *
     * @return {@code true} if the system goes offline
     */
    public boolean requiresDowntime() {
        return requiresDowntime;
    }

    /**
     * The whole notice period is available, so the deadline is the days
     * remaining converted into working hours.
     *
     * @return the resolution deadline in hours
     */
    @Override
    public double getResolutionDeadlineInHours() {
        return daysUntilWindow * 8.0;
    }

    /**
     * Returns the severity, based on whether downtime is needed.
     *
     * @return the severity label
     */
    @Override
    public String getSeverity() {
        return requiresDowntime ? "Planned - Downtime" : "Planned";
    }
}

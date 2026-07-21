package com.oop.module2;

/**
 * A customer support ticket. Its deadline and severity come from the service tier the customer is on.
 */
public class SupportTicket extends Ticket {

    private String serviceTier;

    /**
     * Constructs a SupportTicket.
     *
     * @param code                 the ticket number
     * @param owner                the person responsible
     * @param status               the current status
     * @param allocatedTimeInHours the allocated time in hours
     * @param serviceTier          the customer's tier: "Premium", "Standard" or "Basic"
     */
    public SupportTicket(int code,
                         String owner,
                         String priority,
                         String status,
                         double allocatedTimeInHours,
                         String serviceTier) {
        super(code, owner, priority, status, allocatedTimeInHours);
        this.serviceTier = serviceTier;
    }

    /**
     * Returns the customer's service tier.
     *
     * @return the service tier
     */
    public String getServiceTier() {
        return serviceTier;
    }

    /**
     * Higher tiers get shorter deadlines.
     *
     * @return the resolution deadline in hours
     */
    @Override
    public double getResolutionDeadlineInHours() {
        if ("Premium".equalsIgnoreCase(serviceTier)) {
            return 6.0;
        } else if ("Standard".equalsIgnoreCase(serviceTier)) {
            return 18.0;
        }
        return 24.0;
    }

    /**
     * Returns the severity, based on the service tier.
     *
     * @return the severity label
     */
    @Override
    public String getSeverity() {
        return "Premium".equalsIgnoreCase(serviceTier) ? "High" : "Normal";
    }
}

package atv2.sdk.stripe;

/** Simula o objeto PaymentIntent retornado pelo SDK do Stripe. */
public class StripePaymentIntent {

    private final String id;
    private final String status;
    private final long   amount;

    public StripePaymentIntent(String id, String status, long amount) {
        this.id     = id;
        this.status = status;
        this.amount = amount;
    }

    public String getId()     { return id;     }
    public String getStatus() { return status; }
    public long   getAmount() { return amount; }

    public boolean isSucceeded() {
        return "succeeded".equalsIgnoreCase(status);
    }
}

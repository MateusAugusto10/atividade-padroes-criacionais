package atv2.sdk.paypal;

/** Simula o objeto de resposta retornado pelo SDK do PayPal. */
public class PayPalOrderResponse {

    private final String orderId;
    private final String status;

    public PayPalOrderResponse(String orderId, String status) {
        this.orderId = orderId;
        this.status  = status;
    }

    public String getOrderId() { return orderId; }
    public String getStatus()  { return status;  }

    public boolean isApproved() {
        return "COMPLETED".equalsIgnoreCase(status);
    }
}

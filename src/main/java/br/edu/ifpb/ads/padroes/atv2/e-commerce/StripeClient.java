package atv2.sdk.stripe;

import java.math.BigDecimal;


public class StripeClient {

    private final String apiKey;

    public StripeClient(String apiKey) {
        this.apiKey = apiKey;
        System.out.println("[Stripe SDK] Client inicializado. ApiKey: " + apiKey.substring(0, 8) + "...");
    }

    /**
     * Simula a criação de um PaymentIntent na API do Stripe.
     * Em produção chamaria api.stripe.com/v1/payment_intents
     */
    public StripePaymentIntent createPaymentIntent(BigDecimal amount, String currency, String description) {
        // Stripe trabalha com centavos
        long amountInCents = amount.multiply(BigDecimal.valueOf(100)).longValue();
        System.out.println("[Stripe SDK] POST /v1/payment_intents");
        System.out.println("[Stripe SDK] amount=" + amountInCents + " (centavos) currency=" + currency);

        return new StripePaymentIntent(
            "pi_" + System.currentTimeMillis(),
            "succeeded",
            amountInCents
        );
    }
}

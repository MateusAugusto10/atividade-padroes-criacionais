package atv2.sdk.pagseguro;

/**
 * Simula o objeto de transação retornado pelo SDK do PagSeguro.
 * Código de status: 1=Aguardando, 2=Em análise, 3=Paga, 4=Disponível,
 *                   5=Em disputa, 6=Devolvida, 7=Cancelada
 */
public class PagSeguroTransacao {

    private final String codigo;
    private final int    status;

    public PagSeguroTransacao(String codigo, int status) {
        this.codigo = codigo;
        this.status = status;
    }

    public String getCodigo() { return codigo; }
    public int    getStatus() { return status; }

    public boolean isPaga() {
        return status == 3 || status == 4;
    }
}

package atv2.sdk.pagseguro;


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

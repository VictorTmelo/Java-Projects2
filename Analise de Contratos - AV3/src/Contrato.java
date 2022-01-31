public class Contrato {
    private int fornecedor;
    private int mesInicial;
    private int mesFinal;
    private double valor;

    public Contrato(String f, String mi, String mf, String v) {
        this.fornecedor = Integer.parseInt(f);
        this.mesInicial = Integer.parseInt(mi);
        this.mesFinal = Integer.parseInt(mf);
        this.valor = Double.parseDouble(v.replaceAll(",", "."));
    }

    public Contrato(int f, int mi, int mf, double v) {
        this.fornecedor = f;
        this.mesInicial = mi;
        this.mesFinal = mf;
        this.valor = v;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getMesInicial() {
        return mesInicial;
    }

    public void setMesInicial(int mesInicial) {
        this.mesInicial = mesInicial;
    }

    public int getMesFinal() {
        return mesFinal;
    }

    public void setMesFinal(int mesFinal) {
        this.mesFinal = mesFinal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return fornecedor + " " + mesInicial + " " + mesFinal + " " + valor;
    }
}

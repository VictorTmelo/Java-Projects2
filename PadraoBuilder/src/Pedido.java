
import Enum.Bebidas;
import Enum.Brindes;
import Enum.PratosPrincipais;
import Enum.PratosSecundarios;

public class Pedido {
    private PratosPrincipais pratoPrincipal;
    private PratosSecundarios pratoSecundario;
    private Bebidas bebida;
    private Brindes brinde;

    private Pedido() {

    }

    @Override
    public String toString() {
        return "Pedido{" +
                "pratoPrincipal=" + pratoPrincipal +
                ", pratoSecundario=" + pratoSecundario +
                ", bebida=" + bebida +
                ", brinde=" + brinde +
                '}';
    }

    public static class Builder {
        private Pedido pedido;

        public Builder() {
            this.pedido = new Pedido();
        }

        Builder setPratoPrincipal(PratosPrincipais pratoPrincipal) {
            pedido.pratoPrincipal = pratoPrincipal;
            return this;
        }

        Builder setPratoSecundario(PratosSecundarios pratoSecudario) {
            pedido.pratoSecundario = pratoSecudario;
            return this;
        }

        Builder setBebida(Bebidas bebida) {
            pedido.bebida = bebida;
            return this;
        }

        Builder setBrinde(Brindes brinde) {
            pedido.brinde = brinde;
            return this;
        }
        
        
        public Pedido build() {
            return pedido;
        }
    }
}

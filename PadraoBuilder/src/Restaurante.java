
import Enum.Bebidas;
import Enum.Brindes;
import Enum.PratosPrincipais;
import Enum.PratosSecundarios;

public class Restaurante {
    public Pedido pedido;

    public Restaurante() {
        pedido = new Pedido.Builder()
                .setPratoPrincipal(PratosPrincipais.HAMBURGER)
                .setPratoSecundario(PratosSecundarios.BATATA_FRITA)
                .setBebida(Bebidas.REFRIGERANTE)
                .setBrinde(Brindes.BRINQUEDO)
                .build();
    }

    public static void main(String[] args) {
        Restaurante r = new Restaurante();
        System.out.println(r.pedido);
    }
}

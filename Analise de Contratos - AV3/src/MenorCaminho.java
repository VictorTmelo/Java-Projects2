import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenorCaminho {

    List<No> g = new ArrayList<No>();
    Map<Integer,Integer> a = new HashMap<Integer,Integer>();
    Contrato[] contratos;
    double taxa;

    public MenorCaminho(Contrato contratos[], double taxa) {
        this.contratos = contratos;
        this.taxa = taxa;
    }

    public List<No> run(List<No> list) {

        while (g.size() > 0) {

            Collections.sort(g);
            No n = g.remove(0);

            for (Transition t : n.transitions) {
                No v = t.no;
                v.contrato.setValor(n.contrato.getValor() + taxa);
                v.ant = n.id;
            }
        }

        Collections.sort(list);

        return list;
    }

    public void caminho() {

        No raiz = new No(0, new Contrato(0, 0, 0, 0));
        
        g.add(raiz);

        for (int i = 1; i < contratos.length; i++) {
            No futuro = new No(i, contratos[i]);
            raiz.addTransition(futuro,taxa);
            //proximo.addTransition(futuro, contratos[i]);
            g.add(futuro);
        }

        raiz.ant = raiz.id;
    }
}

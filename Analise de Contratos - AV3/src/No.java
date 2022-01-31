import java.util.ArrayList;

public class No implements Comparable<No> {

	protected Contrato contrato;
	protected final int id;
	protected int ant = 0;

	protected final ArrayList<Transition> transitions = new ArrayList<Transition>();

	public No(int id, Contrato contrato) {
		this.id = id;
		this.contrato = contrato;
	}

	public void addTransition(No n, double taxa) {

		transitions.add(new Transition(n, taxa));

	}

	@Override
	public String toString() {

		return "[ant=" + this.ant + " , Id=" + this.id + " , value=" + this.contrato.getValor() + "]";

	}

	@Override
	public int compareTo(No o) {
		return 0;
	}
}

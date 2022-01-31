
public class Pedido {

	private String principal;
   	private String secundario;
	private String bebida;
	private String brinquedo;
	
	public Pedido(String p, String s, String d, String b) {
		
		this.principal = p;
		this.secundario = s;
		this.bebida = d;
		this.brinquedo = b;
	}
	
	
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getSecundario() {
		return secundario;
	}
	public void setSecundario(String secundario) {
		this.secundario = secundario;
	}
	public String getBebida() {
		return bebida;
	}
	public void setBebida(String bebida) {
		this.bebida = bebida;
	}
	public String getBrinquedo() {
		return brinquedo;
	}
	public void setBrinquedo(String brinquedo) {
		this.brinquedo = brinquedo;
	}


	@Override
	public String toString() {
		return "Pedido [principal = " + principal + ", secundario = " + secundario + ", bebida = " + bebida + ", brinquedo = "
				+ brinquedo + "]";
	}
	
	
}

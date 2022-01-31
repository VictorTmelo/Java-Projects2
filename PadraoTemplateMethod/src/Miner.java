import java.io.File;

public abstract class Miner {

	public void minerar(String file) {
		
		File f = abrirDocumento(file);
		Object dados = extrairDados(f);
		fechar(f);
		salvarBanco(dados);
		
	}
	
	public File abrirDocumento(String file) {
		
		return null;
	}
	
	
	protected abstract Object extrairDados(File arquivo);
	
	protected abstract void fechar(File arquivo);
		
		
	public void salvarBanco(Object dados) {
		
		
	}
}

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	public List<Espaco> espacos;

	public Tabuleiro(){
		this.espacos = new ArrayList<Espaco>();
	}

	
	public void adicionarEspaco(Espaco espaco) {
		this.espacos.add(espaco);
	}
}

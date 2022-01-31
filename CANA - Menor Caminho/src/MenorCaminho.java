import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenorCaminho {
	
	public List<No> run(List<No> list){
		
		ArrayList<No> g = new ArrayList<No>(list);
		
		while(g.size() > 0) {
			
			Collections.sort(g);
			No n = g.remove(0);
			
			for(Transition t : n.transitions) {
				
				No v = t.no;
				
				v.value = n.value + t.custo;
				
				v.ant = n.id;
				
			}
			
		}
		
		Collections.sort(list);
		
		return list;
	}

}

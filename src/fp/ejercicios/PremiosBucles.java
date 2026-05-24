package fp.ejercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class PremiosBucles implements Premios{
	
	private Set<Premio> premios;
	
	public PremiosBucles(){
		this.premios= new HashSet<>();
		
	}
	
	public PremiosBucles(Stream<Premio> streamPremios) {
		this.premios= new HashSet<>();
		Iterator<Premio> it=streamPremios.iterator();
		while (it.hasNext()) {
            this.premios.add(it.next());
        }
    }

	
	@Override
	public void añadirPremio(Premio p) {
		premios.add(p);
		
	}

	@Override
	public Collection<Premio> obtenerPremiosDeGenero(Genero genero) {
		Collection<Premio> res= new ArrayList<Premio>();
		for(Premio p:premios) {
			if(p.genero().equals(genero)) {
				res.add(p);
			}
		}
		return res;
	}

	@Override
	public Integer calcularNumeroPremiadosMasJovenesDe(Integer edad) {
		Integer res=0;
		for(Premio p:premios) {
			if(p.edadPremiado()<edad) {
				res++;
				
			}
		}
		return res;
	}

	@Override
	public Map<Genero, Integer> calcularNumeroPremiosPorGenero() {
		Map<Genero,Integer> res= new HashMap<>();
		
		for(Premio p:premios) {
			Genero g=p.genero();
			
			if(!res.containsKey(g)) {
				res.put(g,1);
			}else {
				res.put(g,res.get(g)+1);
			}
		}
		return res;
	}

	@Override
	public Map<Integer, List<Premio>> calcularPremiosPorEdad() {
		Map<Integer,List<Premio>> res= new HashMap<>();
		for(Premio p:premios) {
			int edad=p.edadPremiado();
			
			if (!res.containsKey(edad)) {
				res.put(edad, new ArrayList<>());
			}
			res.get(edad).add(p);
		}
		return res;
	}

	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		Map<String,List<Integer>> aux = new HashMap<>();
		for(Premio p:premios) {
			String cat=p.categoria();
			
			if(!aux.containsKey(cat)) {
				aux.put(cat, new ArrayList<>());
			}
			aux.get(cat).add(p.edadPremiado());
		}
		
		Map<String,Double> res= new HashMap<>();
		for(String cat:aux.keySet()) {
			List<Integer> edades=aux.get(cat);
			
			int suma =0;
			
			for(int e:edades) {
				suma+=e;
			}
			res.put(cat,(double) suma/edades.size());
		}
		return res;
	}

	@Override
	public String toString() {
		return "PremiosBucles [premios=" + premios + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(premios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiosBucles other = (PremiosBucles) obj;
		return Objects.equals(premios, other.premios);
	}
	
	

}

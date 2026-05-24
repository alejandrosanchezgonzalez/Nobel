package fp.ejercicios;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PremiosStream implements Premios{
	
	private Set<Premio> premios;
	
	public PremiosStream() {
		this.premios= new HashSet<>();
	}
	
	public PremiosStream(Stream<Premio> streamPremios) {
		this.premios=streamPremios.collect(Collectors.toSet());
	}

	@Override
	public void añadirPremio(Premio p) {
		premios.add(p);
		
	}

	@Override
	public Collection<Premio> obtenerPremiosDeGenero(Genero genero) {
		return premios.stream().filter(p->p.genero().equals(genero)).toList();
	}

	@Override
	public Integer calcularNumeroPremiadosMasJovenesDe(Integer edad) {
		return (int) premios.stream().filter(p->p.edadPremiado()<edad).count();
	}

	@Override
	public Map<Genero, Integer> calcularNumeroPremiosPorGenero() {
		return premios.stream().collect(Collectors.groupingBy(Premio::genero,
				Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}

	@Override
	public Map<Integer, List<Premio>> calcularPremiosPorEdad() {
		return premios.stream().collect(Collectors.groupingBy(Premio::edadPremiado));
	}

	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		return premios.stream().collect(Collectors.groupingBy(Premio::categoria,
				Collectors.averagingInt(Premio::edadPremiado)));
	}
	   @Override
	    public String toString() {

	        return "Número total de premios: " + premios.size();
	    }

	    @Override
	    public boolean equals(Object obj) {

	        if (this == obj) {
	            return true;
	        }

	        if (!(obj instanceof PremiosStream other)) {
	            return false;
	        }

	        return Objects.equals(this.premios, other.premios);
	    }

	    @Override
	    public int hashCode() {

	        return Objects.hash(premios);
	    }
	}


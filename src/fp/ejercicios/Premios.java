package fp.ejercicios;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface Premios {
	void añadirPremio(Premio p);
	Collection<Premio> obtenerPremiosDeGenero(Genero genero);
	Integer calcularNumeroPremiadosMasJovenesDe(Integer edad);
	Map<Genero,Integer> calcularNumeroPremiosPorGenero();
	Map<Integer,List<Premio>> calcularPremiosPorEdad();
	Map<String,Double> calcularMediaEdadPorCategoria();

}

package fp.ejercicios;

import java.util.Objects;

import fp.utiles.Checkers;

public record Premio(Integer año,String categoria,String nombre,String apellidos,Genero genero,Integer añoNacimiento) {
	
	public Premio{
		Checkers.check("el año de nacimiento debe ser menor que el año del premio",añoNacimiento<=año);
	}
	
	public Integer edadPremiado() {
		return año-añoNacimiento;
	}

	@Override
	public String toString() {
		return "Premio [año=" + año + ", categoria=" + categoria + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", genero=" + genero + ", añoNacimiento=" + añoNacimiento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, año, categoria, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premio other = (Premio) obj;
		return Objects.equals(año, other.año) && Objects.equals(categoria, other.categoria)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(apellidos, other.apellidos);
	}
	
	
	
}
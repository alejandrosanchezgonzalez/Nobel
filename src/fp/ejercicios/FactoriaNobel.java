package fp.ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FactoriaNobel {
	
	

    private static Implementacion implementacion = Implementacion.STREAM;

	private static Premio parsearPremio(String lineaCSV) {
		String[] trozos=lineaCSV.split(",");
		
		Integer año=Integer.valueOf(trozos[0].strip());
		String categoria=trozos[1].strip();
		String nombre=trozos[2].strip();
		String apellidos=trozos[3].strip();
		Genero genero=Genero.valueOf(trozos[4].strip().toUpperCase());
		Integer añoNacimiento=Integer.valueOf(trozos[5].strip());
		
		return new Premio(año,categoria,nombre,apellidos,genero,añoNacimiento);
		
	}
	
	public static Premios leerPremios(String rutaFichero) {
		Premios res=null;
		try {

            Stream<Premio> streamPremios =
                    Files.lines(Paths.get(rutaFichero)).skip(1)
                         .map(FactoriaNobel::parsearPremio);

            if (implementacion == Implementacion.STREAM) {

                res = new PremiosStream(streamPremios);

            } else {

                res = new PremiosBucles(streamPremios);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return res;
    }
	
	public static void setImplementacion(Implementacion nuevaImplementacion) {

        implementacion = nuevaImplementacion;
    }
}
	
	
	




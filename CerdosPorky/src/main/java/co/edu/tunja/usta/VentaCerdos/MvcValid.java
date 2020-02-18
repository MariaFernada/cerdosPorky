package co.edu.tunja.usta.VentaCerdos;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** 
 * @Desc Este es un archivo de configuracion para el modulo
 * 		 Spring Framework MVC, este archivo gestiona las vistas por default 
 * 		 de los errores generados como el 403, y 404.
 * @CreateAt 29/09/2019
 * @version 1.0
 * @author alejandrovela
 * @required SpringMVC
**/
@Configuration
public class MvcValid implements WebMvcConfigurer {

	/** 
	 * @Desc Este metodo proporciona el controller de las vistas que estan 
	 * 		 predefinidas para los errores.
	 * 			1. El metodo addViewController indica la ruta y el archivo
	 * 		       al que apunta el error.
	 * 			2. El metodo setViewName asigna el nombre del error e indica
	 * 			   el tipo de error producido. 
	 * @CreateAt 29/09/2019
	 * @version 1.0
	 * @author alejandrovela
	 * @required SpringMVC
	**/
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/error").setViewName("error");
	}

}


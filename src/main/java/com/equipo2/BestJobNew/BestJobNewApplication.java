package com.equipo2.BestJobNew;

import com.equipo2.BestJobNew.Entities.Oferta;
import com.equipo2.BestJobNew.Entities.Tecnologia;
import com.equipo2.BestJobNew.Repositories.OfertaRepository;
import com.equipo2.BestJobNew.Repositories.TecnologiaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * PROYECTO ALPHA BOOTCAMP
 * Entrada al programa
 * Equipo Back: Clemen & Josema
 * Equipo Front: Heyanabanana & Javier_scr
 * @author Clemen & Josema
 * @version 1.0
 */
@SpringBootApplication
public class BestJobNewApplication {

	public static void main(String[] args) {
		//Obtenemos el context para trabajar con los repositories
		ApplicationContext context=SpringApplication.run(BestJobNewApplication.class, args);
		OfertaRepository ofertaRepository=context.getBean(OfertaRepository.class);
		TecnologiaRepository tecnologiaRepository=context.getBean(TecnologiaRepository.class);

		//ofertaRepository.deleteAll();
		//tecnologiaRepository.deleteAll();
		/*Tecnologia tec1=new Tecnologia(null,"Spring");
		Tecnologia tec2=new Tecnologia(null,"React");
		Tecnologia tec3=new Tecnologia(null,"HTML+CSS");
		Tecnologia tec4=new Tecnologia(null,"Java");


		Oferta oferta1=new Oferta(null,
				"FullStack Junior",
				"Programador FullStack Junior 40h remoto",
				0,
				18000,
				"IT Dev S.L",
				"678555888",
				"info@itdev.com",
				true);

		oferta1.addTecnologias(tec1);
		oferta1.addTecnologias(tec2);
		oferta1.addTecnologias(tec3);

		Oferta oferta2=new Oferta(null,
				"Programador Java Junior",
				"Programador Java Junior 40h Madrid",
				0,
				18000,
				"IT Dev S.L",
				"678555888",
				"info@itdev.com",
				true);

		oferta2.addTecnologias(tec4);

		Oferta oferta3=new Oferta(null,
				"Programador React Senior",
				"Programador Senior 40h remoto",
				5,
				42000,
				"RETQ S.A",
				"678555888",
				"info@retq.com",
				true);
		oferta3.addTecnologias(tec2);

		ofertaRepository.save(oferta1);
		ofertaRepository.save(oferta2);
		ofertaRepository.save(oferta3);*/

	}

}

package com.bolsadeideas.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.app.models.Usuario;

@Controller
@RequestMapping("/app") /* Ruta del controlador */
public class IndexController {

	// @RequestMapping(value="/index", method = RequestMethod.GET) Sino se indica el
	// metodo es GET
	
	@Value("${text.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${text.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${text.indexcontroller.listar.titulo}")
	private String textoListar;

	/* RUTAS */
	@GetMapping(value = { "/", "/index", "/home" })
	public String index(Model model) {

		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("brahian");
		usuario.setApellido("quintero");
		usuario.setEmail("brahian@correo.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil + " ".concat(usuario.getNombre()));
		return "perfil";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario("brahian", "quintero", "brahian@correo.com"));
		usuarios.add(new Usuario("diego", "giraldo", "diego@correo.com"));
		usuarios.add(new Usuario("natalia", "gallego", "natalia@correo.com"));
		usuarios.add(new Usuario("brandon", "ramirez", "brandon@correo.com"));
		usuarios.add(new Usuario("Torando", "roe", "tornado@correo.com"));

		return usuarios;
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo",textoListar);
		return "listar";
	}

}

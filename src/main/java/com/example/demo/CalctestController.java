package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CalctestController {
	
	String horasTrabalhadas;
	String horasDevidas;
	
	@Autowired
	Servico service;

	@GetMapping("/")
	public String index(Model model, String texto, Integer feriadosTx, Integer cargaHorariaTx) {
		model.addAttribute("info", true);
		model.addAttribute("calculado", false);
		
		return "index";
	}
	
	@RequestMapping("/calcular")
	public String calcular(Model model, String texto, Integer feriadosTx, Integer cargaHorariaTx, String saidaTx, String entradaTx) {	;
		
		cargaHorariaTx = cargaHorariaTx == null ? 40 : cargaHorariaTx;
		model.addAttribute("feriadosTx", feriadosTx);
		model.addAttribute("cargaHorariaTx", cargaHorariaTx);
		model.addAttribute("saidaTx", saidaTx);
		model.addAttribute("entradaTx", entradaTx);
		model.addAttribute("texto", texto);
		
		if(texto == null || texto.isEmpty()) {

			model.addAttribute("mensagemOn", true);
			model.addAttribute("erro","Você precisa inserir os dados da folha de ponto. Copie do PDF e cole na caixa de texto abaixo");
			return "index";
		}
		
		service.alimentarServico(texto, entradaTx, saidaTx, cargaHorariaTx, feriadosTx);
		
		model.addAttribute("hTrabalhadas", service.horasTrabalhadas());
		model.addAttribute("hDevidas", service.horasDevidas());
		String bh = service.bancoHoras();
		if(!bh.isEmpty()) {			
			if(bh.substring(0,1).equals("-")) {
				String [] he = bh.split(":");
				if(he[1].substring(0,1).equals("-")){
					he[1] = he[1].replace("-", "");
					bh = he[0] + ":" + he[1];
				}
				model.addAttribute("cor", "text-danger");
			}else {
				model.addAttribute("cor", "text-success");
			}
		}else {
			model.addAttribute("cor", "text-success");
			
		}
		
		model.addAttribute("bancoHoras", bh);
		
		
		

		
		model.addAttribute("calculado", true);
		return "index";
	}
}

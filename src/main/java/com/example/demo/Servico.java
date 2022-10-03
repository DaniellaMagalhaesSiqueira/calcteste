package com.example.demo;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Servico {

	String mensagens = "";
	Map<Integer, DiasSemana> calendario = new HashMap<>();
	Map<Integer, Duration> horasTrabalhadas = new HashMap<>();
	int horaDevida;
	int cargaHoraria;
	LocalTime entrada;
	LocalTime saida;
	String texto;
	int feriados;

	public void alimentarServico(String textoTx, String hEntrada, String hSaida, int ch, int feriados) {
		this.texto = textoTx;
		this.entrada = hEntrada != null ? HoraUtils.converter(hEntrada) : null;
		this.saida = hSaida != null ? HoraUtils.converter(hSaida) : null;
		this.feriados = feriados;
		this.cargaHoraria = ch;
		lerTexto();
	}

	public Map<Integer, Duration> lerTexto() {
		String separador = "";
		List<String> blocos = new ArrayList<String>();
		for (String str : this.texto.split("\n")) {
			blocos.add(str);
		}
		if (blocos.get(0).substring(2, 3).equals(" "))
			separador = " ";
		if (blocos.get(0).substring(2, 3).equals("\t"))
			separador = "\t";
		for (String bloco : blocos) {
			String[] dia = bloco.split(separador);
			for (String d : dia) {
				System.out.println("D->" + d);
			}

			if (!bloco.isEmpty()) {
				// retirando os vazios
				int cont = 0;
				for (int i = 0; i < dia.length; i++) {
					dia[i] = dia[i].replace("\n", "").replace("\r", "").replaceAll("\t", "");
					dia[i] = dia[i].trim();
					if (dia[i].isEmpty()) {
						dia[i] = null;
					} else {
						cont++;
					}
				}
				String[] alterar = new String[cont];
				for (int i = 0; i < cont; i++) {
					alterar[i] = dia[i];
				}
				dia = alterar;
				Integer data;
				data = Integer.parseInt(dia[0]);
				DiasSemana semana = DataUtils.saberDiaDaSemana(dia[1]);
				calendario.put(data, semana);
				try {
					data = Integer.parseInt(dia[0]);
					boolean entr = false;
					boolean sai = false;
					if (DataUtils.saberDiaUtil(dia[1])) {
						if (dia.length == 3) {
							LocalTime lt = HoraUtils.converter(dia[2]);
							if (lt.getHour() < 10) {
								if (saida != null) {
									sai = true;
								}
							}
							if (lt.getHour() > 12) {
								if (entrada != null) {
									entr = true;
								}
							}
						}
					}
					Duration d = Duration.ofMinutes(0);
					if (dia.length >= 3) {

						if (dia[2] != null) {
							LocalTime lt = HoraUtils.converter(dia[2]);// hora 1
							LocalTime lt2 = lt;
							if ((!sai && !entr) && dia.length == 3) {
								lt = LocalTime.of(0, 0);
								lt2 = LocalTime.of(0, 0);
							} else if (entr) {
								lt = entrada;
								lt2 = HoraUtils.converter(dia[2]);
							} else if (sai) {
								lt2 = saida;
							} else if (dia[3] != null) {
								lt2 = HoraUtils.converter(dia[3]);// hora 2
							}
							d = Duration.between(lt, lt2);
							horasTrabalhadas.put(data, d.toHours() > 7 ? d.minusHours(1) : d);
							String s = "";
							System.out.println(s);
						}
					}
				} catch (Exception e) {
					horasTrabalhadas.clear();
					String msg = "Algo deu errado na conversão do seu texto."
							+ "Isso pode acntecer por várias razões. Tente copiar as informações diretamente da folha de ponto,"
							+ " pois existem marcações que são usadas para separar uma sequência de caracteres.\n"
							+ "Podem acontecer alterações não previstas no formato da folha de ponto, nesse caso o programa precisa"
							+ "ser alterado.";
					adicionarMensagem(msg);
					e.printStackTrace();
					return horasTrabalhadas;
				}
			}
		}
		return horasTrabalhadas;
	}

	private void adicionarMensagem(String msg) {
		if (this.mensagens.isEmpty()) {
			this.mensagens = msg;
			return;
		}
		this.mensagens += "\n" + msg;
	}

	public String horasTrabalhadas() {
		if (calendario.isEmpty() || horasTrabalhadas.isEmpty()) {
			return "Não computado";
		}
		Duration duration = HoraUtils.horasTotais(horasTrabalhadas);
		String str = duration.toHours() + ":";
		duration = duration.minusHours(duration.toHours());
		str += duration.toMinutes() + "";
		return str;
	}

	public String horasDevidas() {
		int diasUteis = 0;
		if (calendario.isEmpty() || horasTrabalhadas.isEmpty()) {
			return "Não computado";
		}
		for (DiasSemana valor : this.calendario.values()) {
			if (!valor.toString().equals("DOMINGO") && !valor.toString().equals("SÁBADO")) {
				diasUteis += 1;
			}
		}
		diasUteis -= this.feriados;
		int horas = diasUteis * (this.cargaHoraria / 5);
		return horas + "";
	}

	public String bancoHoras() {
		if (calendario.isEmpty() || horasTrabalhadas.isEmpty()) {
			return "Não computado";
		}
		String str = "";
		Duration ht = HoraUtils.horasTotais(horasTrabalhadas);
		int hd = HoraUtils.horasDevidas(this.cargaHoraria, this.texto, this.feriados);
		ht = ht.minusHours(hd);

		str = ht.toHours() + ":";
		ht = ht.minusHours(ht.toHours());
		str += ht.toMinutes();
		return str;

	}

}

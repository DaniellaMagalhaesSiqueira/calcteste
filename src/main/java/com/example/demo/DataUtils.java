package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtils {

	private static SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date criarData(String str) {
		try {		
			Date data = FORMATO_DATA.parse(str);
			return data;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String dataFormatada(Date data) {
		if (data == null) {
			return "vazia";
		}

		return FORMATO_DATA.format(data).toString();// .replace("/", "");
	}
	
	public static List<Date> datasComDiasSemanaPorMesAno(List<DiasSemana> dias, int ano, int mes){
		List<Date> datas = pegarDatasDoMes(mes, ano);
		
		for(Date data: datas) {
			for(DiasSemana dia: dias) {
				if(saberDiaDaSemana(data) == dia) {
					datas.add(data);
				}
			}
		}
				
		return datas;
	}
	

	public static DiasSemana saberDiaDaSemana(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		DiasSemana d = null;
		switch(calendar.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.MONDAY:
				d =  DiasSemana.SE;
				break;
			case Calendar.TUESDAY:
				d = DiasSemana.TE;
				break;
			case Calendar.WEDNESDAY:
				d = DiasSemana.QA;
				break;
			case Calendar.THURSDAY:
				d = DiasSemana.QI;
				break;
			case Calendar.FRIDAY:
				d = DiasSemana.SX;
				break;
			case Calendar.SATURDAY:
				d = DiasSemana.SA;
				break;
			case Calendar.SUNDAY:
				d = DiasSemana.DO;
		}
		return d;
	}
		
	public static DiasSemana saberDiaDaSemana(String str) {
		
		DiasSemana d = null;
		switch(str) {
		case "SEGUNDA":
			d =  DiasSemana.SE;
			break;
		case "TERÇA":
			d = DiasSemana.TE;
			break;
		case "QUARTA":
			d = DiasSemana.QA;
			break;
		case "QUINTA":
			d = DiasSemana.QI;
			break;
		case "SEXTA":
			d = DiasSemana.SX;
			break;
		case "SÁBADO":
			d = DiasSemana.SA;
			break;
		case "DOMINGO":
			d = DiasSemana.DO;
		}
		return d;
	}
	
	private static int obterUltimoDiaMes(int mes) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, mes);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	
	private static int obterPrimeiroDiaMes(int mes) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, mes);
		return calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
	}
	
	public static int pegarAnoAtual() {
		LocalDate current_date = LocalDate.now();
		return current_date.getYear();		
	}
	
	public static List<Date> pegarDatasDoMes(int mes, int ano){
		List<Date> datas = new ArrayList<Date>();
		int primeiroDia = obterPrimeiroDiaMes(mes);
		int ultimoDia = obterUltimoDiaMes(mes);
		
		StringBuilder dtStr = new StringBuilder("/"+ mes +"/" + ano);
		
		String stri = "";
		
		for(int i = primeiroDia ; i <= ultimoDia; i++) {
			
			if(i == primeiroDia) {	
				stri = "0" + i;
				dtStr.insert(0, stri);
			}
			
			else if(i <= 9 && i != primeiroDia) {
				stri = "0" + i;
				dtStr.replace(0, 2, stri);				
				
			}else {
				stri = i +"";
				dtStr.replace(0, 2, stri);				
			}
			
			Date data = DataUtils.criarData(dtStr.toString());
			datas.add(data);			
		}
		return datas;
	}

	public static Date data(int dia, int mes, int ano) {
		String data = dia + "/" + mes + "/" + ano;
		return criarData(data);
	}
	
	public static int diasUteis(int mes, int ano) {
		List<Date> datas = pegarDatasDoMes(mes, ano);
		int dias = 0;
		for(Date d: datas) {
			
			if(saberDiaDaSemana(d) != DiasSemana.SA && saberDiaDaSemana(d) != DiasSemana.DO) {
				dias += 1;
			}
		}
		
		return dias;
	}
	
	public static int diasUteis(String tabela) {
		int qtd = 0;
		Map<Integer, DiasSemana> map = pegarDiasUteisTabela(tabela);
		for(DiasSemana valor: map.values()) {
			if(!valor.equals(DiasSemana.DO) && !valor.equals(DiasSemana.SA) ) {
				qtd += 1;
			}
		}
		System.out.println("Dias úteis: " + qtd);
		return qtd;
	}
	
	public static boolean saberDiaUtil(String diaSemana) {
		if(DiasSemana.DO.toString().equals(diaSemana)|| DiasSemana.SA.toString().equals(diaSemana)){
			return false;
		}
		return true;
	}
	
	public static Map<Integer, DiasSemana> pegarDiasUteisTabela(String tabela) {
		Map<Integer, DiasSemana> calendario = new HashMap<Integer, DiasSemana>();
		// Depurando valores
		List<String> blocos = new ArrayList<String>();
		for (String str : tabela.split("\n")) {
			blocos.add(str);
		}
		String separador = "";
		if (blocos.get(0).substring(2, 3).equals(" "))
			separador = " ";
		if (blocos.get(0).substring(2, 3).equals("\t"))
			separador = "\t";
		for (String bloco : blocos) {
			String[] dia = bloco.split(separador);
			if (!bloco.isEmpty()) {
				for (int i =0; i < dia.length; i++) {
					dia[i] = dia[i].replace("\n", "").replace("\r", "").replaceAll("\t", "");
					dia[i].trim();
					if (dia[i].isEmpty()) {
						dia[i] = null;
					}
				}
				Integer data;
				data = Integer.parseInt(dia[0]);
				DiasSemana semana = saberDiaDaSemana(dia[1]);
				calendario.put(data,semana);

			}
		}
		
		return calendario;
	}
	
}

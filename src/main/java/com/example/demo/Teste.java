package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Teste {
	
	@Autowired
	Servico service;

	public static void main(String[] args) {
		//Setembro - Manipulada
		String setembroM = "01 QUINTA\r\n" + 
				"02 SEXTA\r\n03 SÁBADO\r\n04 DOMINGO\r\n05 SEGUNDA\r\n06 TERÇA\r\n" + 
				"07 QUARTA\r\n08 QUINTA 06:49:00 17:57:00	\r\n09 SEXTA\r\n10 SÁBADO\r\n" + 
				"11 DOMINGO\r\n12 SEGUNDA\r\n13 TERÇA\r\n14 QUARTA 06:49:00 18:01:00	\r\n15 QUINTA 06:55:00				\r\n" + 
				"16 SEXTA\r\n17 SÁBADO\r\n18 DOMINGO\r\n19 SEGUNDA\r\n20 TERÇA\r\n21 QUARTA 07:52:00 17:12:00	\r\n" + 
				"22 QUINTA 06:54:00 18:00:00	\r\n23 SEXTA\r\n24 SÁBADO\r\n25 DOMINGO\r\n" + 
				"26 SEGUNDA\r\n27 TERÇA\r\n28 QUARTA 06:41:00 17:53:00	\r\n29 QUINTA 06:49:00				\r\n30 SEXTA";
		//Julho Marcelle
		String julhoM = "01	SEXTA	06:52:00	15:55:00	 	 	 	 	 	 	 	 	\r\n" + 
				"02	SÁBADO											\r\n" + 
				"03	DOMINGO											\r\n" + 
				"04	SEGUNDA											\r\n" + 
				"05	TERÇA											\r\n" + 
				"06	QUARTA	06:48:00	17:58:00	 	 	 	 	 	 	 	 	\r\n" + 
				"07	QUINTA	07:14:00	18:05:00	 	 	 	 	 	 	 	 	\r\n" + 
				"08	SEXTA											\r\n" + 
				"09	SÁBADO											\r\n" + 
				"10	DOMINGO											\r\n" + 
				"11	SEGUNDA											\r\n" + 
				"12	TERÇA											\r\n" + 
				"13	QUARTA	06:47:00	18:00:00	 	 	 	 	 	 	 	 	\r\n" + 
				"14	QUINTA	06:58:00	18:03:00	 	 	 	 	 	 	 	 	\r\n" + 
				"15	SEXTA											\r\n" + 
				"16	SÁBADO											\r\n" + 
				"17	DOMINGO											\r\n" + 
				"18	SEGUNDA											\r\n" + 
				"19	TERÇA											\r\n" + 
				"20	QUARTA	06:48:00	17:50:00	 	 	 	 	 	 	 	 	\r\n" + 
				"21	QUINTA	06:48:00	18:01:00	 	 	 	 	 	 	 	 	\r\n" + 
				"22	SEXTA											\r\n" + 
				"23	SÁBADO											\r\n" + 
				"24	DOMINGO											\r\n" + 
				"25	SEGUNDA											\r\n" + 
				"26	TERÇA											\r\n" + 
				"27	QUARTA	06:54:00	18:00:00	 	 	 	 	 	 	 	 	\r\n" + 
				"28	QUINTA	07:11:00	 	 	 	 	 	 	 	 	 	\r\n" + 
				"29	SEXTA											\r\n" + 
				"30	SÁBADO											\r\n" + 
				"31	DOMINGO											\r\n" + 
				"";
		
		//Julho Leda
		
		String julhoL = "01	SEXTA											\r\n" + 
				"02	SÁBADO											\r\n" + 
				"03	DOMINGO											\r\n" + 
				"04	SEGUNDA											\r\n" + 
				"05	TERÇA	06:58:00	17:31:00	 	 	 	 	 	 	 	 	\r\n" + 
				"06	QUARTA	07:01:00	17:58:00	 	 	 	 	 	 	 	 	\r\n" + 
				"07	QUINTA											\r\n" + 
				"08	SEXTA											\r\n" + 
				"09	SÁBADO											\r\n" + 
				"10	DOMINGO											\r\n" + 
				"11	SEGUNDA											\r\n" + 
				"12	TERÇA	07:00:00	17:54:00	 	 	 	 	 	 	 	 	\r\n" + 
				"13	QUARTA	06:57:00	17:59:00	 	 	 	 	 	 	 	 	\r\n" + 
				"14	QUINTA											\r\n" + 
				"15	SEXTA											\r\n" + 
				"16	SÁBADO											\r\n" + 
				"17	DOMINGO											\r\n" + 
				"18	SEGUNDA											\r\n" + 
				"19	TERÇA	06:57:00	17:51:00	 	 	 	 	 	 	 	 	\r\n" + 
				"20	QUARTA	07:01:00	17:50:00	 	 	 	 	 	 	 	 	\r\n" + 
				"21	QUINTA											\r\n" + 
				"22	SEXTA											\r\n" + 
				"23	SÁBADO											\r\n" + 
				"24	DOMINGO											\r\n" + 
				"25	SEGUNDA											\r\n" + 
				"26	TERÇA	07:04:00	16:47:00	 	 	 	 	 	 	 	 	\r\n" + 
				"27	QUARTA											\r\n" + 
				"28	QUINTA											\r\n" + 
				"29	SEXTA											\r\n" + 
				"30	SÁBADO											\r\n" + 
				"31	DOMINGO			";
		
		//Keiko julho - 10 dias ferias
		String julhoK = "01	SEXTA	07:06:00	18:10:00	 	 	 	 	 	 	 	 	\r\n" + 
				"02	SÁBADO											\r\n" + 
				"03	DOMINGO											\r\n" + 
				"04	SEGUNDA	06:47:00	18:20:00	 	 	 	 	 	 	 	 	\r\n" + 
				"05	TERÇA	06:56:00	16:55:00	 	 	 	 	 	 	 	 	\r\n" + 
				"06	QUARTA	06:46:00	17:30:00	 	 	 	 	 	 	 	 	\r\n" + 
				"07	QUINTA	07:35:00	18:05:00	 	 	 	 	 	 	 	 	\r\n" + 
				"08	SEXTA	07:10:00	16:24:00	 	 	 	 	 	 	 	 	\r\n" + 
				"09	SÁBADO											\r\n" + 
				"10	DOMINGO											\r\n" + 
				"11	SEGUNDA											\r\n" + 
				"12	TERÇA	07:10:00	17:56:00	 	 	 	 	 	 	 	 	\r\n" + 
				"13	QUARTA	06:56:00	17:59:00	 	 	 	 	 	 	 	 	\r\n" + 
				"14	QUINTA	07:10:00	18:03:00	 	 	 	 	 	 	 	 	\r\n" + 
				"15	SEXTA											\r\n" + 
				"16	SÁBADO											\r\n" + 
				"17	DOMINGO											\r\n" + 
				"18	SEGUNDA											\r\n" + 
				"19	TERÇA											\r\n" + 
				"20	QUARTA											\r\n" + 
				"21	QUINTA											\r\n" + 
				"22	SEXTA											\r\n" + 
				"23	SÁBADO											\r\n" + 
				"24	DOMINGO											\r\n" + 
				"25	SEGUNDA											\r\n" + 
				"26	TERÇA											\r\n" + 
				"27	QUARTA											\r\n" + 
				"28	QUINTA											\r\n" + 
				"29	SEXTA											\r\n" + 
				"30	SÁBADO											\r\n" + 
				"31	DOMINGO											\r\n";
		
		//thyssiane julho - 10 feriados
		String julhoT = "01	SEXTA	07:11:00	17:35:00	 	 	 	 	 	 	 	 	\r\n" + 
				"02	SÁBADO											\r\n" + 
				"03	DOMINGO											\r\n" + 
				"04	SEGUNDA	07:13:00	17:01:00	 	 	 	 	 	 	 	 	\r\n" + 
				"05	TERÇA	07:38:00	17:31:00	 	 	 	 	 	 	 	 	\r\n" + 
				"06	QUARTA	07:00:00	16:10:00	 	 	 	 	 	 	 	 	\r\n" + 
				"07	QUINTA	07:01:00	17:00:00	 	 	 	 	 	 	 	 	\r\n" + 
				"08	SEXTA	07:09:00	17:35:00	 	 	 	 	 	 	 	 	\r\n" + 
				"09	SÁBADO											\r\n" + 
				"10	DOMINGO											\r\n" + 
				"11	SEGUNDA											\r\n" + 
				"12	TERÇA											\r\n" + 
				"13	QUARTA											\r\n" + 
				"14	QUINTA											\r\n" + 
				"15	SEXTA											\r\n" + 
				"16	SÁBADO											\r\n" + 
				"17	DOMINGO											\r\n" + 
				"18	SEGUNDA											\r\n" + 
				"19	TERÇA											\r\n" + 
				"20	QUARTA											\r\n" + 
				"21	QUINTA											\r\n" + 
				"22	SEXTA	07:08:00	17:11:00	 	 	 	 	 	 	 	 	\r\n" + 
				"23	SÁBADO											\r\n" + 
				"24	DOMINGO											\r\n" + 
				"25	SEGUNDA	07:03:00	17:02:00	 	 	 	 	 	 	 	 	\r\n" + 
				"26	TERÇA	07:01:00	16:47:00	 	 	 	 	 	 	 	 	\r\n" + 
				"27	QUARTA											\r\n" + 
				"28	QUINTA											\r\n" + 
				"29	SEXTA											\r\n" + 
				"30	SÁBADO											\r\n" + 
				"31	DOMINGO			";
		
		String julhoPortal = "01	SEXTA	07:29:00	16:55:00	 	 	 	 	 	 	 	 	\r\n" + 
				"02	SÁBADO											\r\n" + 
				"03	DOMINGO											\r\n" + 
				"04	SEGUNDA	07:24:00	17:01:00	 	 	 	 	 	 	 	 	\r\n" + 
				"05	TERÇA	07:37:00	17:14:00	 	 	 	 	 	 	 	 	\r\n" + 
				"06	QUARTA	07:55:00	17:22:00	 	 	 	 	 	 	 	 	\r\n" + 
				"07	QUINTA	07:58:00	17:08:00	 	 	 	 	 	 	 	 	\r\n" + 
				"08	SEXTA	07:58:00	16:10:00	 	 	 	 	 	 	 	 	\r\n" + 
				"09	SÁBADO											\r\n" + 
				"10	DOMINGO											\r\n" + 
				"11	SEGUNDA	07:33:00	17:00:00	 	 	 	 	 	 	 	 	\r\n" + 
				"12	TERÇA	07:27:00	17:31:00	 	 	 	 	 	 	 	 	\r\n" + 
				"13	QUARTA	07:30:00	 	 	 	 	 	 	 	 	 	\r\n" + 
				"14	QUINTA											\r\n" + 
				"15	SEXTA											\r\n" + 
				"16	SÁBADO											\r\n" + 
				"17	DOMINGO											\r\n" + 
				"18	SEGUNDA											\r\n" + 
				"19	TERÇA											\r\n" + 
				"20	QUARTA	07:22:00	17:16:00	 	 	 	 	 	 	 	 	\r\n" + 
				"21	QUINTA	07:51:00	17:14:00	 	 	 	 	 	 	 	 	\r\n" + 
				"22	SEXTA	07:44:00	16:18:00	 	 	 	 	 	 	 	 	\r\n" + 
				"23	SÁBADO											\r\n" + 
				"24	DOMINGO											\r\n" + 
				"25	SEGUNDA	07:59:00	17:02:00	 	 	 	 	 	 	 	 	\r\n" + 
				"26	TERÇA	07:40:00	16:47:00	 	 	 	 	 	 	 	 	\r\n" + 
				"27	QUARTA	08:25:00	18:00:00	 	 	 	 	 	 	 	 	\r\n" + 
				"28	QUINTA	07:45:00	17:43:00	 	 	 	 	 	 	 	 	\r\n" + 
				"29	SEXTA											\r\n" + 
				"30	SÁBADO											\r\n" + 
				"31	DOMINGO				";
		
		//janeiro portal
		String janeiroPortal = "01	SÁBADO											\r\n" + 
				"02	DOMINGO											\r\n" + 
				"03	SEGUNDA	07:49:00	17:00:00	 	 	 	 	 	 	 	 	\r\n" + 
				"04	TERÇA	07:49:00	17:09:00	 	 	 	 	 	 	 	 	\r\n" + 
				"05	QUARTA	07:46:00	17:43:00	17:58:00	 	 	 	 	 	 	 	\r\n" + 
				"06	QUINTA	07:56:00	17:00:00	 	 	 	 	 	 	 	 	\r\n" + 
				"07	SEXTA	07:58:00	16:49:00	 	 	 	 	 	 	 	 	\r\n" + 
				"08	SÁBADO											\r\n" + 
				"09	DOMINGO											\r\n" + 
				"10	SEGUNDA	07:22:00	17:02:00	 	 	 	 	 	 	 	 	\r\n" + 
				"11	TERÇA	07:48:00	17:40:00	 	 	 	 	 	 	 	 	\r\n" + 
				"12	QUARTA	06:53:00	18:10:00	 	 	 	 	 	 	 	 	\r\n" + 
				"13	QUINTA	07:39:00	17:23:00	 	 	 	 	 	 	 	 	\r\n" + 
				"14	SEXTA	07:33:00	17:46:00	 	 	 	 	 	 	 	 	\r\n" + 
				"15	SÁBADO											\r\n" + 
				"16	DOMINGO											\r\n" + 
				"17	SEGUNDA	07:50:00	16:03:00	 	 	 	 	 	 	 	 	\r\n" + 
				"18	TERÇA	06:40:00	17:33:00	 	 	 	 	 	 	 	 	\r\n" + 
				"19	QUARTA											\r\n" + 
				"20	QUINTA											\r\n" + 
				"21	SEXTA											\r\n" + 
				"22	SÁBADO											\r\n" + 
				"23	DOMINGO											\r\n" + 
				"24	SEGUNDA	07:40:00	16:52:00	 	 	 	 	 	 	 	 	\r\n" + 
				"25	TERÇA	07:44:00	17:02:00	 	 	 	 	 	 	 	 	\r\n" + 
				"26	QUARTA	07:34:00	17:16:00	 	 	 	 	 	 	 	 	\r\n" + 
				"27	QUINTA	07:53:00	17:10:00	 	 	 	 	 	 	 	 	\r\n" + 
				"28	SEXTA	07:19:00	16:17:00	 	 	 	 	 	 	 	 	\r\n" + 
				"29	SÁBADO											\r\n" + 
				"30	DOMINGO											\r\n" + 
				"31	SEGUNDA	07:51:00	17:44:00	 	 	 	 	 	 	 	 	\r\n";
		
		
//		System.out.println("Horas Devidas: " + HoraUtils.horasDevidas(20, julhoM, 3));
//		Map<Integer, Duration> map = HoraUtils.pegarHorasDiasUteis(setembroM, null, "18:00");
//		System.out.println("Horas Totais: " + HoraUtils.horasTotais(map));
		
		System.out.println();

		
	}
}

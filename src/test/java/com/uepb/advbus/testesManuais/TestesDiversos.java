package com.uepb.advbus.testesManuais;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TestesDiversos {

	public static void main(String[] args) throws EmailException {
		String x = new SimpleDateFormat("MM/yyy").format(new Date()) + 
		" - " + new SimpleDateFormat("MM/yyy").format(new Date());
		System.out.println(x);
		
		SimpleEmail email = new SimpleEmail();
	
		System.out.println("alterando host");
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.addTo("diego@synctech.com.br", "Diego");
		email.setFrom("diegors90@gmail.com", "ADVBus");
		email.setSubject("Teste");
		email.setMsg("Testando envio de emails ");
		System.out.println("altenticando");
		email.setSSL(true);
		email.setAuthentication("diegors90@gmail.com", "180407010311100914s");
		System.out.println("enviando...");
		email.send();
		System.out.println("Email enviado");
		
		
		
		
	}
}

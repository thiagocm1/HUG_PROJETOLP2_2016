package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import hotel.Hospede;
import junit.framework.Assert;
import quarto.Quarto;

public class HospedeTest {
	@Before
	public void setUp() throws Exception {
		Hospede novoHospede = new Hospede("Livia", "livia_123@em.com", "1990");
		assertEquals("Livia", novoHospede.getNomeHospede());
		assertEquals("livia_123@em.com", novoHospede.getEmailHospede());
		assertEquals("1990", novoHospede.getAnoNascimento());

		Hospede hospede = new Hospede("Sven Svensson", "sven@sverige.se", "10/02/1978");
		assertEquals("Sven Svensson", hospede.getNomeHospede());
		assertEquals("sven@sverige.se", hospede.getEmailHospede());
		assertEquals("10/02/1978", hospede.getAnoNascimento());
		
		
	}

	@Test
	public void testeSets() throws Exception {
		Hospede novoHospede = new Hospede("Livia", "livia_123@em.com", "1990");
		novoHospede.setNomeHospede("Rebeca");
		novoHospede.setEmailHospede("rebeca_beltrao@em.com");
		novoHospede.setAnoNascimento("1996");
		assertEquals("Rebeca", novoHospede.getNomeHospede());
		assertEquals("rebeca_beltrao@em.com", novoHospede.getEmailHospede());
		assertEquals("1996", novoHospede.getAnoNascimento());

	}

	@Test
	public void testeComException() throws Exception {
		try {
			new Hospede(null, "rebeca_beltrao@em.com", "1996");
		} catch (Exception e) {
			assertEquals("Mensagem de excecao capturada.", "String nao pode ser nula ou vazia", e.getMessage());
		}
		try {
			new Hospede("Rebeca", "rebeca_beltrao@em.com", "-12");
		} catch (Exception e) {
			assertEquals("Mensagem de excecao capturada.", "Numero nao pode ser negativo ou zero.", e.getMessage());
		}
		try {
			new Hospede("", "rebeca_beltrao@em.com", "1996");
		} catch (Exception e) {
			assertEquals("Mensagem de excecao capturada.", "String nao pode ser nula ou vazia", e.getMessage());
		}
		try {
			new Hospede("Rebeca", "rebeca_beltrao@em.com", "0");
		} catch (Exception e) {
			assertEquals("Mensagem de excecao capturada.", "Numero nao pode ser negativo ou zero.", e.getMessage());
		}
		try {
			new Hospede("Rebeca", null, "1996");
		} catch (Exception e) {
			assertEquals("Mensagem de excecao capturada.", "String nao pode ser nula ou vazia", e.getMessage());
		}
		try {
			new Hospede("Rebeca","", "1996");
		} catch (Exception e) {
			assertEquals("Mensagem de excecao capturada.", "String nao pode ser nula ou vazia", e.getMessage());
		}
		try {
			new Hospede(null, null, "1996");
		} catch (Exception e) {
			assertEquals("Mensagem de excecao capturada.", "String nao pode ser nula ou vazia", e.getMessage());
		}

		try {
			new Hospede(null, "", "1996");
		} catch (Exception e) {
			assertEquals("Mensagem de excecao capturada.", "String nao pode ser nula ou vazia", e.getMessage());
		}

	}
}

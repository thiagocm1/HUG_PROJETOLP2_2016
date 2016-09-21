package restaurante;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import excecoes.BuscaPratoException;
import excecoes.CadastraPratoInvalidoException;
import excecoes.ComponenteVazioException;
import excecoes.ConsultaHospedagemException;
import excecoes.Excecoes;
import excecoes.QuantidadeInvalidaPratosException;

public class RestauranteController {

	private HashSet<Prato> cardapio;
	private List<RefeicaoCompleta> refeicoes;
	private RefeicaoFactory factoryRefeicao;
	private PratosFactory factoryPratos;

	public RestauranteController() {

		this.cardapio = new HashSet<Prato>();
		this.refeicoes = new ArrayList<RefeicaoCompleta>();
		this.factoryPratos = new PratosFactory();
		this.factoryRefeicao = new RefeicaoFactory();

	}

	public void iniciaSistema() {

	}

	public boolean cadastraPrato(String nome, double preco, String descricao) throws Exception {
		
		Excecoes.CadastroInvalidoPrato(nome, descricao, preco);
		Prato prato = factoryPratos.criaPrato(nome, preco, descricao);
		
		return cardapio.add(prato);
	}

	public boolean removeCardapio(Prato prato) {
		for (Prato removeprato : cardapio) {
			if (removeprato.equals(prato)) {
				removeprato.equals(removeprato);
				return true;
			}
		}
		return false;
	}

	public double compraPrato(Prato prato) throws Exception {
		Excecoes.verificaPrato(prato);
		if (!(buscaPrato(prato))) {
			throw new BuscaPratoException();
		}
		return prato.getPrecoPrato() - (prato.getPrecoPrato() * 0.1);
	}

	public boolean buscaPrato(Prato prato) {
		return cardapio.contains(prato);
	}

	public Prato buscaCardapio(String nome) {
		for (Prato prato : cardapio) {
			if (nome.equalsIgnoreCase(prato.getNomePrato())) {
				return prato;
			}
		}
		return null;
	}


	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception {
		Excecoes.CadastroInvalidoRefeicao(nome, descricao, componentes);
		String[] pratos = componentes.split(";");
		if(componentes == null || componentes.trim().isEmpty()){
			throw new ComponenteVazioException();
		}
		if (pratos.length < 3 || pratos.length > 4) {
			throw new QuantidadeInvalidaPratosException();
			}
		for (String prato : pratos) {
			if (buscaCardapio(prato) == null) {
				throw new CadastraPratoInvalidoException();			}

		}

		RefeicaoCompleta refeicao = factoryRefeicao.criaRefeicao(nome, descricao);

		refeicoes.add(refeicao);
		for (String outroPrato : pratos) {
			refeicao.adicionaPrato(buscaCardapio(outroPrato));
		}
	}
	
	public RefeicaoCompleta buscaRefeicao(String nome) {
		for (RefeicaoCompleta refeicao : refeicoes) {
			if (nome.equalsIgnoreCase(refeicao.getNomeRefeicao())) {
				return refeicao;
			}
		}
		return null;
	}
			
	public String consultaRestaurante(String nome, String atributo) throws Exception {
		Excecoes.ConsultaRestauranteException(nome, atributo);
		String informacaoConsulta = "";
		if (buscaCardapio(nome) != null) {
			Prato prato = buscaCardapio(nome);
			if (atributo.equalsIgnoreCase("preco")) {
				double tado = prato.getPrecoPrato();
				informacaoConsulta = String.format("R$%.2f", tado);
				
			}
			if (atributo.equalsIgnoreCase("descricao")) {
				informacaoConsulta += prato.getDescricaoPrato();
			}
		}

		if (buscaRefeicao(nome) != null) {
			RefeicaoCompleta refeicao = buscaRefeicao(nome);
			if (atributo.equalsIgnoreCase("preco")) {
				double i = refeicao.calculaPrecoTotal();
				informacaoConsulta = String.format("R$%.2f", i);
			}
			if (atributo.equalsIgnoreCase("descricao")) {
				return refeicao.informacaoRefeicao();
			}
		}
		return informacaoConsulta;
	}

	public void fechaSistema() {

	}
}
package restaurante;

import java.util.ArrayList;
import java.util.List;

import excecoes.Excecoes;

public class RefeicaoCompleta {

	private String nomeRefeicao, descricaoRefeicao;
	private List<Prato> listaPrato;

	public RefeicaoCompleta(String nomeRefeicao, String descricaoRefeicao) throws Exception {

		Excecoes.StringException(nomeRefeicao);
		Excecoes.StringException(descricaoRefeicao);

		this.nomeRefeicao = nomeRefeicao;
		this.descricaoRefeicao = descricaoRefeicao;
		// this.componentes = componentes;
		this.listaPrato = listaPrato;

	}

	public double calculaConta() {
		double desconto = 0.1;
		double contaAPagar = 0;

		for (Prato prato : listaPrato) {
			contaAPagar += prato.getPrecoPrato();
		}
		return contaAPagar = contaAPagar * desconto;
	}

	public String getNomeRefeicao() {
		return nomeRefeicao;
	}

	public String getDescricaoRefeicao() {
		return descricaoRefeicao;
	}

	public List<Prato> getListaPrato() {
		return listaPrato;
	}

	public void setNomeRefeicao(String nomeRefeicao) throws Exception {
		Excecoes.StringException(nomeRefeicao);
		this.nomeRefeicao = nomeRefeicao;
	}

	public void setDescricaoRefeicao(String descricaoRefeicao) throws Exception {
		Excecoes.StringException(descricaoRefeicao);
		this.descricaoRefeicao = descricaoRefeicao;
	}

	public void setListaPrato(ArrayList<Prato> listaPrato) throws Exception {
		Excecoes.verificaTamanhoArray(listaPrato);
		this.listaPrato = listaPrato;
	}

	public void adicionaPrato(Prato prato) {
		listaPrato.add(prato);
	}

	public double calculaPrecoTotal() {
		double total = 0;
		for (Prato prato : listaPrato) {
			total += prato.getPrecoPrato();
		}
		return total;
	}

	@Override
	public String toString() {

		String listaConcatena = "";
		Prato objprato = null;
		for (Prato prato : listaPrato) {
			objprato = prato;
			listaConcatena += objprato.getNomePrato() + "/n";
		}

		return "Refeicao Completa: " + nomeRefeicao + ",- Descricao: " + descricaoRefeicao + "Lista de Pratos: \n"
				+ listaConcatena;
	}

	@Override
	public boolean equals(Object refeicao) {
		if (refeicao instanceof RefeicaoCompleta) {
			RefeicaoCompleta novaRefeicao = (RefeicaoCompleta) refeicao;
			if (novaRefeicao.getNomeRefeicao().equalsIgnoreCase(nomeRefeicao)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoRefeicao == null) ? 0 : descricaoRefeicao.hashCode());
		result = prime * result + ((listaPrato == null) ? 0 : listaPrato.hashCode());
		result = prime * result + ((nomeRefeicao == null) ? 0 : nomeRefeicao.hashCode());
		return result;
	}

}

package entities;

import java.util.Objects;

public class Coberturas {
	
	private String dataInicio;
	private String dataFim;
	private String tipo;
	private String matriculaCobertura;
	private String nomeCobertura;
	private String postoCobertura;
	private String matriculaFaltante;
	private String nomeFaltante;
	private String cliente;
	private String postoFaltante;
	private String recursoCobertura;
	private String horarioPrevisto;
	private String chPrevista;
	
	public Coberturas(String dataInicio, String dataFim, String tipo, String matriculaCobertura, String nomeCobertura,
			String postoCobertura, String matriculaFaltante, String nomeFaltante, String cliente, String postoFaltante,
			String recursoCobertura, String horarioPrevisto, String chPrevista) {
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipo = tipo;
		this.matriculaCobertura = matriculaCobertura;
		this.nomeCobertura = nomeCobertura;
		this.postoCobertura = postoCobertura;
		this.matriculaFaltante = matriculaFaltante;
		this.nomeFaltante = nomeFaltante;
		this.cliente = cliente;
		this.postoFaltante = postoFaltante;
		this.recursoCobertura = recursoCobertura;
		this.horarioPrevisto = horarioPrevisto;
		this.chPrevista = chPrevista;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMatriculaCobertura() {
		return matriculaCobertura;
	}

	public void setMatriculaCobertura(String matriculaCobertura) {
		this.matriculaCobertura = matriculaCobertura;
	}

	public String getNomeCobertura() {
		return nomeCobertura;
	}

	public void setNomeCobertura(String nomeCobertura) {
		this.nomeCobertura = nomeCobertura;
	}

	public String getPostoCobertura() {
		return postoCobertura;
	}

	public void setPostoCobertura(String postoCobertura) {
		this.postoCobertura = postoCobertura;
	}

	public String getMatriculaFaltante() {
		return matriculaFaltante;
	}

	public void setMatriculaFaltante(String matriculaFaltante) {
		this.matriculaFaltante = matriculaFaltante;
	}

	public String getNomeFaltante() {
		return nomeFaltante;
	}

	public void setNomeFaltante(String nomeFaltante) {
		this.nomeFaltante = nomeFaltante;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getPostoFaltante() {
		return postoFaltante;
	}

	public void setPostoFaltante(String postoFaltante) {
		this.postoFaltante = postoFaltante;
	}

	public String getRecursoCobertura() {
		return recursoCobertura;
	}

	public void setRecursoCobertura(String recursoCobertura) {
		this.recursoCobertura = recursoCobertura;
	}

	public String getHorarioPrevisto() {
		return horarioPrevisto;
	}

	public void setHorarioPrevisto(String horarioPrevisto) {
		this.horarioPrevisto = horarioPrevisto;
	}

	public String getChPrevista() {
		return chPrevista;
	}

	public void setChPrevista(String chPrevista) {
		this.chPrevista = chPrevista;
	}

	@Override
	public String toString() {
		String descricao = "";
		
			if(dataInicio.compareTo(dataFim) == 0) {
				descricao += "Cob em " + dataInicio + " por " + nomeCobertura + " - " + matriculaCobertura;
			}
			
			if(dataInicio.compareTo(dataFim) != 0) {
				descricao += "Cob de " + dataInicio + " a " + dataFim + " por " + nomeCobertura + " - " + matriculaCobertura;
			}		
		
		return descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chPrevista, cliente, dataFim, dataInicio, horarioPrevisto, matriculaCobertura,
				matriculaFaltante, nomeCobertura, nomeFaltante, postoCobertura, postoFaltante, recursoCobertura, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coberturas other = (Coberturas) obj;
		return Objects.equals(chPrevista, other.chPrevista) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(dataFim, other.dataFim) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(horarioPrevisto, other.horarioPrevisto)
				&& Objects.equals(matriculaCobertura, other.matriculaCobertura)
				&& Objects.equals(matriculaFaltante, other.matriculaFaltante)
				&& Objects.equals(nomeCobertura, other.nomeCobertura)
				&& Objects.equals(nomeFaltante, other.nomeFaltante)
				&& Objects.equals(postoCobertura, other.postoCobertura)
				&& Objects.equals(postoFaltante, other.postoFaltante)
				&& Objects.equals(recursoCobertura, other.recursoCobertura) && Objects.equals(tipo, other.tipo);
	}
	
	
	
	
	

}

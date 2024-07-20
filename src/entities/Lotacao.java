package entities;

import java.util.Objects;

public class Lotacao {
	
	private String posto;
	private String matricula;
	private String nome;
	private String admissao;
	private String situacao;
	private String feristaSN;
	private String escala;
	private String chMes;
	private String cargo;
	
	public Lotacao(String posto, String matricula, String nome, String admissao, String situacao, String feristaSN,
			String escala, String chMes, String cargo) {
		this.posto = posto;
		this.matricula = matricula;
		this.nome = nome;
		this.admissao = admissao;
		this.situacao = situacao;
		this.feristaSN = feristaSN;
		this.escala = escala;
		this.chMes = chMes;
		this.cargo = cargo;
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAdmissao() {
		return admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}

	public String getsituacao() {
		return situacao;
	}

	public void setsituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getFeristaSN() {
		return feristaSN;
	}

	public void setFeristaSN(String feristaSN) {
		this.feristaSN = feristaSN;
	}

	public String getEscala() {
		return escala;
	}

	public void setEscala(String escala) {
		this.escala = escala;
	}

	public String getChMes() {
		return chMes;
	}

	public void setChMes(String chMes) {
		this.chMes = chMes;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "Lotacao [posto=" + posto + ", matricula=" + matricula + ", nome=" + nome + ", admissao=" + admissao
				+ ", situacao=" + situacao + ", feristaSN=" + feristaSN + ", escala=" + escala + ", chMes=" + chMes + ", cargo=" + cargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(admissao, cargo, chMes, escala, feristaSN, matricula, nome, posto,
				situacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lotacao other = (Lotacao) obj;
		return Objects.equals(admissao, other.admissao) && Objects.equals(cargo, other.cargo)
				&& Objects.equals(chMes, other.chMes)
				&& Objects.equals(escala, other.escala)
				&& Objects.equals(feristaSN, other.feristaSN) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(nome, other.nome) && Objects.equals(posto, other.posto)
				&& Objects.equals(situacao, other.situacao);
	}
	
	

}

package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Ocorrencias {

	private String matricula;
	private String nome;
	private String cargo;
	private String admissao;
	private String inicioOcorrenciaData;
	private String inicioOcorrenciaHora;
	private String codEvento;
	private String descEvento;
	private String fimOcorrenciaData;
	private String fimOcorrenciaHora;
	private String obs;
	private String inicioPeriodoAquisitivo;
	private String fimPeriodoAquisitivo;
	
	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

	public Ocorrencias(String matricula, String nome, String cargo, String admissao, String inicioOcorrenciaData,
			String inicioOcorrenciaHora, String codEvento, String descEvento, String fimOcorrenciaData,
			String fimOcorrenciaHora, String obs, String inicioPeriodoAquisitivo, String fimPeriodoAquisitivo) {
		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.admissao = admissao;
		this.inicioOcorrenciaData = inicioOcorrenciaData;
		this.inicioOcorrenciaHora = inicioOcorrenciaHora;
		this.codEvento = codEvento;
		this.descEvento = descEvento;
		this.fimOcorrenciaData = fimOcorrenciaData;
		this.fimOcorrenciaHora = fimOcorrenciaHora;
		this.obs = obs;
		this.inicioPeriodoAquisitivo = inicioPeriodoAquisitivo;
		this.fimPeriodoAquisitivo = fimPeriodoAquisitivo;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getAdmissao() {
		return admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}

	public String getInicioOcorrenciaData() {
		return inicioOcorrenciaData;
	}

	public void setInicioOcorrenciaData(String inicioOcorrenciaData) {
		this.inicioOcorrenciaData = inicioOcorrenciaData;
	}

	public String getInicioOcorrenciaHora() {
		return inicioOcorrenciaHora;
	}

	public void setInicioOcorrenciaHora(String inicioOcorrenciaHora) {
		this.inicioOcorrenciaHora = inicioOcorrenciaHora;
	}

	public String getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(String codEvento) {
		this.codEvento = codEvento;
	}

	public String getDescEvento() {
		return descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public String getFimOcorrenciaData() {
		return fimOcorrenciaData;
	}

	public void setFimOcorrenciaData(String fimOcorrenciaData) {
		this.fimOcorrenciaData = fimOcorrenciaData;
	}

	public String getFimOcorrenciaHora() {
		return fimOcorrenciaHora;
	}

	public void setFimOcorrenciaHora(String fimOcorrenciaHora) {
		this.fimOcorrenciaHora = fimOcorrenciaHora;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getInicioPeriodoAquisitivo() {
		return inicioPeriodoAquisitivo;
	}

	public void setInicioPeriodoAquisitivo(String inicioPeriodoAquisitivo) {
		this.inicioPeriodoAquisitivo = inicioPeriodoAquisitivo;
	}

	public String getFimPeriodoAquisitivo() {
		return fimPeriodoAquisitivo;
	}

	public void setFimPeriodoAquisitivo(String fimPeriodoAquisitivo) {
		this.fimPeriodoAquisitivo = fimPeriodoAquisitivo;
	}
	
	public Long qtdDias() {
		

		LocalDate dataInicio = LocalDate.parse(this.inicioOcorrenciaData, formatoData);
		LocalDate dataFim = LocalDate.parse(this.fimOcorrenciaData, formatoData);
		Long qtdDias = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;
		
		return qtdDias;
		
	}

	/*public Double qtdHorasEmDias() {
		
		return
	}
	
	public Date qtdHorasEmHoras() {
		
		return
	}*/
	
	@Override
	public String toString() {
		return "Ocorrencia [matricula=" + matricula + ", nome=" + nome + ", cargo=" + cargo + ", admissao=" + admissao
				+ ", inicioOcorrenciaData=" + inicioOcorrenciaData + ", inicioOcorrenciaHora=" + inicioOcorrenciaHora
				+ ", codEvento=" + codEvento + ", descEvento=" + descEvento + ", fimOcorrenciaData=" + fimOcorrenciaData
				+ ", fimOcorrenciaHora=" + fimOcorrenciaHora + ", obs=" + obs + ", inicioPeriodoAquisitivo="
				+ inicioPeriodoAquisitivo + ", fimPeriodoAquisitivo=" + fimPeriodoAquisitivo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(admissao, cargo, codEvento, descEvento, fimOcorrenciaData, fimOcorrenciaHora,
				fimPeriodoAquisitivo, inicioOcorrenciaData, inicioOcorrenciaHora, inicioPeriodoAquisitivo, matricula,
				nome, obs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ocorrencias other = (Ocorrencias) obj;
		return Objects.equals(admissao, other.admissao) && Objects.equals(cargo, other.cargo)
				&& Objects.equals(codEvento, other.codEvento) && Objects.equals(descEvento, other.descEvento)
				&& Objects.equals(fimOcorrenciaData, other.fimOcorrenciaData)
				&& Objects.equals(fimOcorrenciaHora, other.fimOcorrenciaHora)
				&& Objects.equals(fimPeriodoAquisitivo, other.fimPeriodoAquisitivo)
				&& Objects.equals(inicioOcorrenciaData, other.inicioOcorrenciaData)
				&& Objects.equals(inicioOcorrenciaHora, other.inicioOcorrenciaHora)
				&& Objects.equals(inicioPeriodoAquisitivo, other.inicioPeriodoAquisitivo)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nome, other.nome)
				&& Objects.equals(obs, other.obs);
	}

	
	
}

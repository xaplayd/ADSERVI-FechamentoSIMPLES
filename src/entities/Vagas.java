package entities;

import java.util.Objects;

public class Vagas {
	
	private Integer ctoInt;
	private String rateio;
	private String posto;
	private Double valor;
	private Integer qtdPosto;
	
	public Vagas(Integer ctoInt, String rateio, String posto, Double valor, Integer qtdPosto) {

		this.ctoInt = ctoInt;
		this.rateio = rateio;
		this.posto = posto;
		this.valor = valor;
		this.qtdPosto = qtdPosto;
	}

	public Integer getCtoInt() {
		return ctoInt;
	}

	public void setCtoInt(Integer ctoInt) {
		this.ctoInt = ctoInt;
	}

	public String getRateio() {
		return rateio;
	}

	public void setRateio(String rateio) {
		this.rateio = rateio;
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQtdPosto() {
		return qtdPosto;
	}

	public void setQtdPosto(Integer qtdPosto) {
		this.qtdPosto = qtdPosto;
	}

	@Override
	public String toString() {
		return "QuadroLotacao [ctoInt=" + ctoInt + ", rateio=" + rateio + ", posto=" + posto
				+ ", valor=" + valor + ", qtdPosto=" + qtdPosto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ctoInt, posto, qtdPosto, rateio, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vagas other = (Vagas) obj;
		return  Objects.equals(ctoInt, other.ctoInt)
				&& Objects.equals(posto, other.posto) && Objects.equals(qtdPosto, other.qtdPosto)
				&& Objects.equals(rateio, other.rateio) && Objects.equals(valor, other.valor);
	}
	
	
	

}

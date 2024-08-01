package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Coberturas;
import entities.Lotacao;
import entities.Ocorrencias;
import entities.Vagas;
import javafx.scene.control.Alert;

public class Execution {

	/* INICIO UTILIZAVEIS */
	Integer matConfere = 9;
	Integer dataConfere = 9;
	Integer postConfere = 14;
	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
	List<Lotacao> lotacoesNaoAlocadas = new ArrayList<Lotacao>();
	List<Ocorrencias> ocorrenciasNaoAlocadas = new ArrayList<Ocorrencias>();
	List<Coberturas> coberturasNaoAlocadas = new ArrayList<Coberturas>();

	/* FIM UTILIZAVEIS */

	public List lerVagas(String caminho) {
		String tempCaminhoQuadroVagas = caminho;
		List<Vagas> listaDeVagas = new ArrayList<Vagas>();
		File arquivoQuadroVagas = new File(tempCaminhoQuadroVagas);
		try (BufferedReader tblQuadroVagas = new BufferedReader(new FileReader(arquivoQuadroVagas, StandardCharsets.ISO_8859_1))) {
			String vaga = tblQuadroVagas.readLine();
			while (vaga != null) {
				String[] fields = vaga.split(";", -1);
				// cto int
				String coluna0 = fields[0];
				boolean confereLinha = coluna0.chars().allMatch(Character::isDigit);
				if (confereLinha == true) {
					Integer colunaZero = Integer.parseInt(coluna0);
					// rateio
					String coluna1 = fields[1];
					// posto
					String coluna2 = fields[2];
					// cargo
					String coluna3 = fields[3];
					// valor
					String coluna4 = fields[4].replace(",", ".");
					Double colunaQuatro = Double.parseDouble(coluna4);
					// qtdVagas
					Integer coluna5 = Integer.parseInt(fields[5]);
					if (coluna5 >= 1) {
						int i = 1;
						while (i <= coluna5) {
							listaDeVagas.add(new Vagas(colunaZero, coluna1, coluna2, coluna3, colunaQuatro, coluna5));
							i++;
						}
					}
				}
				vaga = tblQuadroVagas.readLine();
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return listaDeVagas;
	}

	public List lerLotacao(String caminho, List vagas) {
		List<Vagas> tempList = vagas;
		String tempCaminhoQuadroLotacao = caminho;
		File arquivoQuadroLotacao = new File(tempCaminhoQuadroLotacao);
		try (BufferedReader tblQuadroLotacao = new BufferedReader(new FileReader(arquivoQuadroLotacao, StandardCharsets.ISO_8859_1))) {
			String lotacao = tblQuadroLotacao.readLine();
			while (lotacao != null) {
				String[] fields = lotacao.split(";", -1);
				// branco
				String coluna0 = fields[0];
				// codPosto
				String coluna1 = fields[1];
				// posto
				String coluna2 = fields[2];
				// matricula
				String coluna5 = fields[5].replace(",00", "").replace(".", "");

				if (coluna0 == "" && coluna1.length() >= postConfere && coluna2 != ""
						&& coluna5.length() == matConfere) {
					// nome
					String coluna6 = fields[6];
					// admissao
					String coluna9 = fields[9];
					// situcao
					String coluna11 = fields[11];
					// feristaSN
					String coluna13 = fields[13];
					// escala
					String coluna16 = fields[16];
					// chMes
					String coluna18 = fields[18];
					// cargo
					String coluna20 = fields[20];
					Integer i = 0;
					Integer z = 0;
					for (Vagas y : tempList) {
						if (coluna2.compareTo(y.getPosto()) == 0 && y.getColaborador() == null && z == 0) {
							y.setColaborador(new Lotacao(coluna2, coluna5, coluna6, coluna9, coluna11, coluna13,
									coluna16, coluna18, coluna20));
							i++;
							z++;
						}
					}
					if (i == 0) {
						lotacoesNaoAlocadas.add(new Lotacao(coluna2, coluna5, coluna6, coluna9, coluna11, coluna13,
								coluna16, coluna18, coluna20));
					}
					i = 0;
					lotacao = tblQuadroLotacao.readLine();
				} else {
					lotacao = tblQuadroLotacao.readLine();
				}
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return tempList;
	}

	/* INICIO DA LEITURA DAS OCORRENCIAS */
	public List lerOcorrencias(String caminho, List vagasElotacoes) {

		String tempCaminho = caminho;
		
		List<Vagas> tempList = vagasElotacoes;

		List<Ocorrencias> listaDeOcorrencias = new ArrayList<Ocorrencias>();

		File arquivoOcorrencias = new File(tempCaminho);

		matConfere = 9;

		try (BufferedReader tblOcorrencias = new BufferedReader(new FileReader(arquivoOcorrencias, StandardCharsets.ISO_8859_1))) {
			String ocorrencia = tblOcorrencias.readLine();

			while (ocorrencia != null) {

				String[] fields = ocorrencia.split(";", -1);

				// matricula
				String coluna0 = fields[0].replace(",00", "").replace(".", "");

				if (coluna0.length() == matConfere) {

					// nome
					String coluna1 = fields[1];

					// cargo
					String coluna5 = fields[5];

					// admissao
					String coluna8 = fields[8];

					// inicioOcorrenciaData
					String coluna9 = fields[9];

					// inicioOcorrenciaHora
					String coluna10 = fields[10];
					if (coluna10.compareTo("00:00") == 0) {
						coluna10 = null;
					}

					// codEvento
					String coluna11 = fields[11];

					// descEvento
					String coluna13 = fields[13];

					// fimOcorrenciaData
					String coluna15 = fields[15];
					if (coluna15.compareTo("00/00/0000") == 0) {

						LocalDate dataInicio = LocalDate.parse(coluna9, formatoData);
						LocalDate dataFinal = dataInicio.with(TemporalAdjusters.lastDayOfMonth());
						coluna15 = dataFinal.format(formatoData);
					}

					// fimOcorrenciaHora
					String coluna16 = fields[16];
					if (coluna16.compareTo("00:00") == 0) {
						coluna16 = null;
					}

					// obs
					String coluna17 = fields[17];

					// inicioPeriodoAquisitivo
					String coluna21 = fields[21];

					// fimPeriodoAquisitivo
					String coluna22 = fields[22];
					
					for(Vagas x : tempList) {
						if(x.getColaborador() != null && x.getColaborador().getMatricula().compareTo(coluna0) == 0) {
							x.adicionaOcorrencia(new Ocorrencias(coluna0, coluna1, coluna5, coluna8, coluna9, coluna10,
							coluna11, coluna13, coluna15, coluna16, coluna17, coluna21, coluna22));
						}else {
							ocorrenciasNaoAlocadas.add(new Ocorrencias(coluna0, coluna1, coluna5, coluna8, coluna9, coluna10,
							coluna11, coluna13, coluna15, coluna16, coluna17, coluna21, coluna22));
							
						}
						
					}

					
					
					//listaDeOcorrencias.add(new Ocorrencias(coluna0, coluna1, coluna5, coluna8, coluna9, coluna10,
					//		coluna11, coluna13, coluna15, coluna16, coluna17, coluna21, coluna22));
					
					
					
					
				}

				ocorrencia = tblOcorrencias.readLine();

			}
		} catch (IOException e) {
			e.getMessage();
		}
		return tempList;
	}
	/* FIM DA LEITURA DAS OCORRENCIAS */

	/* INICIO DA LEITURA DAS COBERTURAS */
	public List lerCoberturas(String caminho) {

		String tempCaminho = caminho;

		List<Coberturas> listaDeCoberturas = new ArrayList<Coberturas>();

		File arquivoCoberturas = new File(tempCaminho);

		try (BufferedReader tblCoberturas = new BufferedReader(new FileReader(arquivoCoberturas, StandardCharsets.ISO_8859_1))) {
			String cobertura = tblCoberturas.readLine();

			while (cobertura != null) {

				String[] fields = cobertura.split(";", -1);

				// dataInicioCobertura
				String coluna0 = fields[0];
				String colunaZeroNumero = coluna0.replace("/", "");

				boolean confereLinha = colunaZeroNumero.chars().allMatch(Character::isDigit);

				if (confereLinha == true) {

					// dataFimCobertura
					String coluna2 = fields[2];

					// tipo
					String coluna3 = fields[3];

					// matriculaCobertura
					String coluna4 = fields[4];

					// nomeCobertura
					String coluna5 = fields[5];

					// postoCobertura
					String coluna8 = fields[8];

					// matriculaFaltante
					String coluna11 = fields[11];
					if (coluna11 == "") {
						coluna11 = null;
					}

					// nomeFaltante
					String coluna12 = fields[12];
					if (coluna12 == "") {
						coluna12 = null;
					}

					// cliente
					String coluna14 = fields[14];

					// postoFaltante
					String coluna15 = fields[15];

					// recursoCobertura
					String coluna20 = fields[20];
					if (coluna20 == "") {
						coluna20 = null;
					}

					// horarioPrevisto
					String coluna21 = fields[21];

					// chPrevisto
					String coluna22 = fields[22];

					listaDeCoberturas.add(new Coberturas(coluna0, coluna2, coluna3, coluna4, coluna5, coluna8, coluna11,
							coluna12, coluna14, coluna15, coluna20, coluna21, coluna22));

					cobertura = tblCoberturas.readLine();
				}

				cobertura = tblCoberturas.readLine();

			}
		} catch (IOException e) {
			e.getMessage();
		}

		for (Coberturas x : listaDeCoberturas) {
			System.out.println(x);
		}
		return listaDeCoberturas;
	}
	/* FIM DA LEITURA DAS COBERTURAS */

	/* INICIO DA ESCRITA CONSOLIDADA */
	public void consolidar(String caminhoVagas, String caminhoLotacao, String caminhoOcorrencias,
			String caminhoCoberturas, String caminhoSalvarEm) {

		escreve(lerOcorrencias(caminhoOcorrencias,(lerLotacao(caminhoLotacao, lerVagas(caminhoVagas)))), caminhoSalvarEm);

	}
	/* FIM DA ESCRITA CONSOLIDADA */

	public void escreve(List listaRecebidaAlocados, String caminhoSalvarEm) {

		List<Vagas> tempList = listaRecebidaAlocados;

		File arquivoNovo = new File(caminhoSalvarEm + ".crypt");
		try{BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoNovo), StandardCharsets.ISO_8859_1));
		pw.write(";;QUADRO EFETIVO" + "\n");
		pw.write("CTO INT; RATEIO; POSTO; CARGO; VALOR; MATRICULA; NOME; ADMISSÃO; ESCALA; \n");

		for (Vagas x : tempList) {
			
			
			if (x.getColaborador() != null) {
				
				if(x.getOcorrencia() != null) {
					String descOcorrencias = "";
					for(Ocorrencias y : x.getOcorrencia()) {
						
						if(descOcorrencias == "") {
							descOcorrencias += y.toString();
						} else {
						descOcorrencias += " || ";
						descOcorrencias += y.toString();
						}
						
					}
					pw.write(x.getCtoInt() + ";" + x.getRateio() + ";" + x.getPosto() + ";" + x.getCargo() + ";"
							+ x.getValor() + ";" + x.getColaborador().getMatricula() + ";"
							+ x.getColaborador().getNome() + ";" + x.getColaborador().getAdmissao() + ";"
							+ x.getColaborador().getEscala() + ";" + descOcorrencias + "\n");
					
					
				}else {
				
				pw.write(x.getCtoInt() + ";" + x.getRateio() + ";" + x.getPosto() + ";" + x.getCargo() + ";"
						+ x.getValor() + ";" + x.getColaborador().getMatricula() + ";"
						+ x.getColaborador().getNome() + ";" + x.getColaborador().getAdmissao() + ";"
						+ x.getColaborador().getEscala() + ";" + "\n");
				}
			
				
		
			} else {
				pw.write(x.getCtoInt() + ";" + x.getRateio() + ";" + x.getPosto() + ";" + x.getCargo() + ";"
						+ x.getValor() + ";" + "\n");

			}
		}

		pw.write("\n\n");
		pw.write(";;QUADRO NÃO ALOCADO \n");
		for (Lotacao x : lotacoesNaoAlocadas) {
			pw.write(";;" + x.getPosto() + ";;;" + x.getMatricula() + ";" + x.getNome() + ";" + x.getAdmissao()
					+ ";" + x.getEscala() + "\n");
		}

		pw.flush();
		pw.close();

	} catch (IOException e) {
		e.getMessage();
	}
		
	

	}

}

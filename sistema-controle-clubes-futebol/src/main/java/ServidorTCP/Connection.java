package ServidorTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.ConfederacaoBrasileiraDeFutebol;
import pojos.Jogador;
import pojos.Partida;
import pojos.SerieA;
import pojos.SerieB;
import pojos.SocioTorcedor;
import pojos.Tecnico;
import pojos.Time;
import request.reply.Reply;
import request.reply.Request;

public class Connection implements Runnable {

	private Socket socket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;

	public Connection(Socket socket, DataInputStream dataInputStream, DataOutputStream dataOutputStream)
			throws IOException {
		this.socket = socket;
		this.dataInputStream = dataInputStream;
		this.dataOutputStream = dataOutputStream;
	}

	public void run() {

		try {

			ConfederacaoBrasileiraDeFutebol cbf = new ConfederacaoBrasileiraDeFutebol("Edson Arantes do Nascimento",
					"Fortaleza-Ce, Brasil");

			boolean sair = false;

			while (!sair) {

				String dadosRecebidos = this.dataInputStream.readUTF();

				// Desserializando
				ObjectMapper mapper = new ObjectMapper();
				Request request = mapper.readValue(dadosRecebidos, Request.class);

				String metodoVindoDoCliente = request.getMetodoServidor();
				
				if(metodoVindoDoCliente == null) {
					metodoVindoDoCliente = "6";
				}

				switch (metodoVindoDoCliente) {

				case "1":

					try {

						Jogador jogador = mapper.convertValue(request.getEntidade(), Jogador.class);

						if (cbf.addJogador(jogador)) {
							Reply reply = new Reply("Cadastro do jogador realizado com sucesso!");

							// Serializando Resposta e enviando para o cliente
							this.dataOutputStream.writeUTF(mapper.writeValueAsString(reply));

						} else {
							Reply reply = new Reply("Cadastro Inválido | O jogador já está cadastrado!");

							// Serializando Resposta e enviando para o cliente
							ObjectMapper objectMapper = new ObjectMapper();
							this.dataOutputStream.writeUTF(objectMapper.writeValueAsString(reply));
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "2":

					try {

						Time time = mapper.convertValue(request.getEntidade(), Time.class);
						if (cbf.addTime(time)) {
							Reply reply = new Reply("Cadastro do time realizado com sucesso!");
							this.dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						} else {
							Reply reply = new Reply("Cadastro Inválido | O time já está cadastrado!");
							this.dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "3":

					try {

						Tecnico tecnico = mapper.convertValue(request.getEntidade(), Tecnico.class);
						if (cbf.addTecnico(tecnico)) {
							Reply reply = new Reply("Cadastro de Técnico realizado com sucesso!");
							this.dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						} else {
							Reply reply = new Reply("Cadastro Inválido | O técnico já está cadastrado");
							this.dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "4":

					try {

						int idCampeonato = request.getIdCampeonato();

						if (idCampeonato == 1) {

							SerieA serieA = mapper.convertValue(request.getEntidade(), SerieA.class);

							if (cbf.criarCampeonato(serieA , 1)) {
								Reply reply = new Reply("Campeonato criado com sucesso!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							} else {
								Reply reply = new Reply("Não foi possível criar esse campeonato. Coloque outro ano!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							}

						} else if (idCampeonato == 2) {

							SerieB serieB = mapper.convertValue(request.getEntidade(), SerieB.class);

							if (cbf.criarCampeonato(serieB , 2)) {
								Reply reply = new Reply("Campeonato criado com sucesso!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							} else {
								Reply reply = new Reply("Não foi possível criar esse campeonato. Coloque outro ano!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							}

						} 
					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "5":

					try {

						int idCampeonato = request.getIdCampeonato();
						String nomeTime = request.getNomeTime();

						Time time = cbf.encontrarTime(nomeTime);

						if (time == null) {
							Reply reply = new Reply("O time informado não está cadastrado!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							break;
						}

						if (idCampeonato == 1) {

							SerieA serieA = mapper.convertValue(request.getEntidade(), SerieA.class);

							if (cbf.addTimeCampeonato(serieA.getAno(), time, 1)) {
								Reply reply = new Reply("Time adicionado ao campeonato com sucesso!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							} else {
								Reply reply = new Reply("Falhou | time já cadastrado ou campeonato não criado ainda!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							}

						} else if (idCampeonato == 2) {

							SerieB serieB = mapper.convertValue(request.getEntidade(), SerieB.class);

							if (cbf.addTimeCampeonato(serieB.getAno(), time, 2)) {
								Reply reply = new Reply("Time adicionado ao campeonato com sucesso!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							} else {
								Reply reply = new Reply("Falhou | time já cadastrado ou campeonato não criado ainda!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							}

						} 
					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "6":

					try {

						int idCampeonato = request.getIdCampeonato();

						Time timeCasa = cbf.encontrarTime(request.getTimeCasa());
						Time timeVisitante = cbf.encontrarTime(request.getTimeFora());
						Time timeVencedor = cbf.encontrarTime(request.getTimeVencedor());

						if(timeVencedor.equals(timeCasa) == false && timeVencedor.equals(timeVisitante) == false) {
							Reply reply = new Reply("Preencha os nomes dos times corretamente!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							break;
						}
						
						if (timeCasa == null || timeVisitante == null || timeVencedor == null || timeCasa.equals(timeVisitante)) {
							Reply reply = new Reply("Preencha os nomes dos times corretamente!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							break;
						}

						Partida partida = mapper.convertValue(request.getPartida(), Partida.class);
						partida.setTime1(timeCasa);
						partida.setTime2(timeVisitante);
						partida.setVencedor(timeVencedor);

						if (idCampeonato == 1) {

							SerieA serieA = mapper.convertValue(request.getEntidade(), SerieA.class);

							if (cbf.realizarPartidaCampeonato(serieA, partida, 1)) {
								Reply reply = new Reply("Partida adicionada ao campeonato com sucesso!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							} else {
								Reply reply = new Reply("O campeonato informado não existe!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							}

						} else if (idCampeonato == 2) {

							SerieB serieB = mapper.convertValue(request.getEntidade(), SerieB.class);

							if (cbf.realizarPartidaCampeonato(serieB, partida, 2)) {
								Reply reply = new Reply("Partida adicionada ao campeonato com sucesso!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							} else {
								Reply reply = new Reply("O campeonato informado não existe!");
								dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							}

						} 
					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "7":
					try {

						List<SerieA> listSerieA = cbf.getListSerieA();
						List<SerieB> listSerieB = cbf.getListSerieB();

						String campeonatosSerieAJson = mapper.writeValueAsString(listSerieA);
						dataOutputStream.writeUTF(campeonatosSerieAJson);
						
						String campeonatosSerieBJson = mapper.writeValueAsString(listSerieB);
						dataOutputStream.writeUTF(campeonatosSerieBJson);

					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "8":
					try {
						List<Jogador> jogadores = cbf.jogadores();

						String jogadoresJson = mapper.writeValueAsString(jogadores);
						dataOutputStream.writeUTF(jogadoresJson);

					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "9":

					try {

						List<Tecnico> tecnicos = cbf.tecnicos();

						String tecnicosJson = mapper.writeValueAsString(tecnicos);
						dataOutputStream.writeUTF(tecnicosJson);

					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "10":
					try {

						List<Time> times = cbf.times();

						String timesJson = mapper.writeValueAsString(times);
						dataOutputStream.writeUTF(timesJson);

					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "11":
					try {

						Jogador jogador = cbf.encontrarJogador(request.getCpf());

						if (jogador == null) {
							Reply reply = new Reply("O jogador não está cadastrado no sistema!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							break;
						}
						
						Time time = cbf.encontrarTime(request.getNomeTime());

						if (time == null) {
							Reply reply = new Reply("O time não está cadastrado no sistema!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							break;
						}

						if (time.comprarJogador(jogador,time)) {
							Reply reply = new Reply("O jogador foi comprado com sucesso!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						} else {
							Reply reply = new Reply("Falhou | O jogador informado já possui um time!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						}

					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "12":

					try {
						
						String cpf = request.getCpf();

						Tecnico tecnico = cbf.encontrarTecnico(cpf);
						Time time = cbf.encontrarTime(request.getNomeTime());

						if (tecnico == null) {
							Reply reply = new Reply("O técnico não está cadastrado no sistema!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							break;
						}

						if (time == null) {
							Reply reply = new Reply("O time não está cadastrado no sistema!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							break;
						}

						if (time.comprarTecnico(tecnico,time)) {
							Reply reply = new Reply("O técnico foi comprado com sucesso!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						} else {
							Reply reply = new Reply("Falhou | O técnico informado já possui um time!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						}

					} catch (Exception e) {
						e.printStackTrace();

					}
					break;

				case "13":

					try {

						Time time = cbf.encontrarTime(request.getNomeTime());
						
						SocioTorcedor socioTorcedor = mapper.convertValue(request.getEntidade(), SocioTorcedor.class);
						
						if (time == null) {
							Reply reply = new Reply("O time não está cadastrado no sistema!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
							break;
						}else {
							time.addSocioTorcedor(socioTorcedor);
							Reply reply = new Reply("Parabéns | Você acabou de se tornar socio torcedor!");
							dataOutputStream.writeUTF(mapper.writeValueAsString(reply));
						}


					} catch (Exception e) {
						e.printStackTrace();

					}
					
					break;

				case "sair":
					sair = true;
					break;

				default:
					System.out.println("Entrada inválida!");
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

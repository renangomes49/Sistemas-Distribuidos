package ClienteTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.Campeonato;
import pojos.Jogador;
import pojos.Partida;
import pojos.SerieA;
import pojos.SerieB;
import pojos.SocioTorcedor;
import pojos.Tecnico;
import pojos.Time;
import request.reply.Reply;
import request.reply.Request;

public class ClienteTCP {
	public static void main(String[] args) {

		Socket socketCliente = null;

		try {

			int portaServidor = 7896;
			socketCliente = new Socket("localhost", portaServidor);

			DataOutputStream outputStream = new DataOutputStream(socketCliente.getOutputStream());

			DataInputStream inputStream = new DataInputStream(socketCliente.getInputStream());

			System.out.println(
					"==============================SISTEMA DE CONTROLE DE PARTIDADES DE CAMPEONATOS DE FUTEBOL==============================\n");
			System.out.println("1 - Cadastrar jogador na CBF");
			System.out.println("2 - Cadastrar time na CBF");
			System.out.println("3 - Cadastrar técnico na CBF");
			System.out.println("4 - Criar campeonato");
			System.out.println("5 - Cadastrar time em determinado campeonato");
			System.out.println("6 - Cadastrar partida em determinado campeonato ");
			System.out.println("7 - Listar campeonatos");
			System.out.println("8 - Listar jogadores");
			System.out.println("9 - Listar técnicos");
			System.out.println("10 - Listar Times");
			System.out.println("11 - Comprar jogador - Time");
			System.out.println("12 - Comprar técnico - Time");
			System.out.println("13 - Cadastrar Sócio Torcedor - Time");
			System.out.println("14 - Sair");

			Scanner entrada = new Scanner(System.in);
			boolean sair = false;

			while (!sair) {
				System.out.print("\n>> ");
				String operacao = entrada.nextLine();

				switch (operacao) {

				case "1":
					try {

						System.out.println("Informe o nome: ");
						String nome = entrada.nextLine();
						System.out.println("Informe a data de nascimento: ");
						String dataNacimento = entrada.nextLine();
						System.out.println("Informe a cidade onde nasceu: ");
						String cidade = entrada.nextLine();
						System.out.println("Informe o estado onde nasceu: ");
						String estado = entrada.nextLine();
						System.out.println("Informe o país onde nasceu: ");
						String pais = entrada.nextLine();
						System.out.println("Informe a idade: ");
						int idade = Integer.parseInt(entrada.nextLine());
						System.out.println("Informe o cpf: ");
						String cpf = entrada.nextLine();
						System.out.println("Informe a posição do jogador");
						String posicao = entrada.nextLine();

						Jogador jogador = new Jogador(nome, dataNacimento, cidade, estado, pais, idade, cpf, posicao);
						Request request = new Request("1", jogador);

						// Serializando em JSON
						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						// enviando o JSON
						outputStream.writeUTF(requestJson);

						// Recebedo a resposta Serializada e Desserializabdo
						String replyJson = inputStream.readUTF();

						ObjectMapper objectMapper = new ObjectMapper();
						Reply reply = objectMapper.readValue(replyJson, Reply.class);
						System.out.println(reply.getDescricaoResposta());

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						System.out.println("Entrada Inválida");
					}

					break;

				case "2":
					try {
						System.out.println("Digite o nome do time: ");
						String nome = entrada.nextLine();
						System.out.println("Digite o nome do estádio do time: ");
						String estadio = entrada.nextLine();
						System.out.println("Onde fica a sede do clube: ");
						String localizacao = entrada.nextLine();

						// Enviando os dados para o servidor
						Time time = new Time(nome, estadio, localizacao);
						Request request = new Request("2", time);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor
						String replyJson = inputStream.readUTF();
						Reply reply = mapper.readValue(replyJson, Reply.class);
						System.out.println(reply.getDescricaoResposta());

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					break;

				case "3":

					try {
						System.out.println("Digite o nome do técnico: ");
						String nome = entrada.nextLine();
						System.out.println("Digite a data de nascimento do técnico: ");
						String dataNascimeto = entrada.nextLine();
						System.out.println("Digite o cpf: ");
						String cpf = entrada.nextLine();

						// Enviando os dados para o servidor
						Tecnico tecnico = new Tecnico(nome, dataNascimeto, cpf);
						Request request = new Request("3", tecnico);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor
						String replyJson = inputStream.readUTF();
						Reply reply = mapper.readValue(replyJson, Reply.class);
						System.out.println(reply.getDescricaoResposta());

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					break;

				case "4":

					try {

						System.out.println("1 - Criar Campeonato Série A");
						System.out.println("2 - Criar Campeonato Série B");

						System.out.println(">> ");
						String opcao = entrada.nextLine();

						if (opcao.equals("1")) {

							System.out.println("Digite o ano do Campeonato: ");
							int ano = Integer.parseInt(entrada.nextLine());
							SerieA serieA = new SerieA(ano, "Serie A");

							Request request = new Request("4", serieA, 1);

							ObjectMapper objectMapper = new ObjectMapper();
							String requestJson = objectMapper.writeValueAsString(request);
							outputStream.writeUTF(requestJson);

							String replyJson = inputStream.readUTF();
							Reply reply = objectMapper.readValue(replyJson, Reply.class);
							System.out.println(reply.getDescricaoResposta());
							break;

						} else if (opcao.equals("2")) {

							System.out.println("Digite o ano do Campeonato: ");
							int ano = Integer.parseInt(entrada.nextLine());
							SerieB serieB = new SerieB(ano, "Serie B");

							Request request = new Request("4", serieB, 2);

							ObjectMapper objectMapper = new ObjectMapper();
							String requestJson = objectMapper.writeValueAsString(request);
							outputStream.writeUTF(requestJson);

							String replyJson = inputStream.readUTF();
							Reply reply = objectMapper.readValue(replyJson, Reply.class);
							System.out.println(reply.getDescricaoResposta());
							break;

						}
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						System.out.println("Entrada Inválida");
					}

					break;

				case "5":

					try {

						System.out.println("1 - Selecionar Campeonato Série A");
						System.out.println("2 - Selecionar Campeonato Série B");

						System.out.println(">> ");

						String opcao = entrada.nextLine();

						if (opcao.equals("1")) {

							System.out.println("Digite o ano do Campeonato: ");
							int ano = Integer.parseInt(entrada.nextLine());
							System.out.println("Qual o nome do time que você quer adicionar ao campeonato: ");
							String nomeTime = entrada.nextLine();

							SerieA serieA = new SerieA(ano, "Serie A");

							Request request = new Request("5", serieA, 1, nomeTime);

							ObjectMapper objectMapper = new ObjectMapper();
							String requestJson = objectMapper.writeValueAsString(request);
							outputStream.writeUTF(requestJson);

							String replyJson = inputStream.readUTF();
							Reply reply = objectMapper.readValue(replyJson, Reply.class);
							System.out.println(reply.getDescricaoResposta());

						} else if (opcao.equals("2")) {

							System.out.println("Digite o ano do Campeonato: ");
							int ano = Integer.parseInt(entrada.nextLine());
							System.out.println("Qual o nome do time que você quer adicionar ao campeonato: ");
							String nomeTime = entrada.nextLine();

							SerieB serieB = new SerieB(ano, "Série B");

							Request request = new Request("5", serieB, 2, nomeTime);

							ObjectMapper objectMapper = new ObjectMapper();
							String requestJson = objectMapper.writeValueAsString(request);
							outputStream.writeUTF(requestJson);

							String replyJson = inputStream.readUTF();
							Reply reply = objectMapper.readValue(replyJson, Reply.class);
							System.out.println(reply.getDescricaoResposta());

						}
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						System.out.println("Entrada Inválida");
					}

					break;

				case "6":

					try {

						System.out.println("1 - Selecionar Campeonato Série A");
						System.out.println("2 - Selecionar Campeonato Série B");
						
						System.out.println(">> ");

						String opcao = entrada.nextLine();

						if (opcao.equals("1")) {

							System.out.println("Digite o ano do Campeonato: ");
							int ano = Integer.parseInt(entrada.nextLine());
							System.out.println("Qual o nome do time que jogou em casa: ");
							String nomeTimeCasa = entrada.nextLine();
							System.out.println("Qual o nome do time visitante: ");
							String nomeTimeFora = entrada.nextLine();
							System.out.println("Qual o nome do time que venceu a partida: ");
							String nomeTimeVencedor = entrada.nextLine();
							System.out.println("Qual o nome do estádio que a partida foi realizada: ");
							String estadio = entrada.nextLine();
							System.out.println("Qual a data da realização da partida: ");
							String data = entrada.nextLine();
							System.out.println("Qual o horario que começou a partida: ");
							String horario = entrada.nextLine();
							

							SerieA serieA = new SerieA(ano, "Serie A");
							Partida partida = new Partida(estadio, data, horario);

							Request request = new Request("6", serieA, partida, nomeTimeCasa, nomeTimeFora, nomeTimeVencedor, 1);
							
							ObjectMapper objectMapper = new ObjectMapper();
							String requestJson = objectMapper.writeValueAsString(request);
							outputStream.writeUTF(requestJson);

							String replyJson = inputStream.readUTF();
							Reply reply = objectMapper.readValue(replyJson, Reply.class);
							System.out.println(reply.getDescricaoResposta());

						} else if (opcao.equals("2")) {

							System.out.println("Digite o ano do Campeonato: ");
							int ano = Integer.parseInt(entrada.nextLine());
							System.out.println("Qual o nome do time que jogou em casa: ");
							String nomeTimeCasa = entrada.nextLine();
							System.out.println("Qual o nome do time visitante: ");
							String nomeTimeFora = entrada.nextLine();
							System.out.println("Qual o nome do time que venceu a partida: ");
							String nomeTimeVencedor = entrada.nextLine();
							System.out.println("Qual o nome do estádio que a partida foi realizada: ");
							String estadio = entrada.nextLine();
							System.out.println("Qual a data da realização da partida: ");
							String data = entrada.nextLine();
							System.out.println("Qual o horario que começou a partida: ");
							String horario = entrada.nextLine();

							SerieB serieB = new SerieB(ano, "Serie B");
							Partida partida = new Partida(estadio, data, horario);

							Request request = new Request("6", serieB, partida, nomeTimeCasa, nomeTimeFora,
									nomeTimeVencedor, 2);

							ObjectMapper objectMapper = new ObjectMapper();
							String requestJson = objectMapper.writeValueAsString(request);
							outputStream.writeUTF(requestJson);

							String replyJson = inputStream.readUTF();
							Reply reply = objectMapper.readValue(replyJson, Reply.class);
							System.out.println(reply.getDescricaoResposta());

						} 
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}catch (NumberFormatException e) {
						System.out.println("Entrada Inválida");
					}

					break;

				case "7":
					try {

						// Enviando os dados para o servidor
						Request request = new Request("7", null);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor - Campeonato Serie A
						String campeonatosSerieAJson = inputStream.readUTF();
						List<SerieA> campeonatosSerieA = mapper.readValue(campeonatosSerieAJson,
								new TypeReference<List<SerieA>>() {
								});
									
						if (campeonatosSerieA.isEmpty()) {
							System.out.println("Não tem campeonatos Serie A cadastrados!");
						}else {
							for (SerieA serieA : campeonatosSerieA) {
								System.out.println(serieA);
							}
						}
						
						// Recebendo os dados do Servidor - Campeonato Serie A
						String campeonatosSerieBJson = inputStream.readUTF();
						List<SerieB> campeonatosSerieB = mapper.readValue(campeonatosSerieBJson,
								new TypeReference<List<SerieB>>() {
								});
									
						if (campeonatosSerieB.isEmpty()) {
							System.out.println("Não tem campeonatos Serie A cadastrados!");
						}else {
							for (SerieB serieB : campeonatosSerieB) {
								System.out.println(serieB);
							}
						}

						

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					break;

				case "8":
					try {

						// Enviando os dados para o servidor
						Request request = new Request("8", null);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor
						String replyJson = inputStream.readUTF();

						List<Jogador> jogadores = mapper.readValue(replyJson, new TypeReference<List<Jogador>>() {
						});

						if (jogadores.isEmpty()) {
							System.out.println("O sistema não possui jogadores cadastrados");
							break;
						}

						for (Jogador jogador : jogadores) {
							System.out.println(jogador);
						}

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					break;

				case "9":
					try {

						// Enviando os dados para o servidor
						Request request = new Request("9", null);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor
						String replyJson = inputStream.readUTF();

						List<Tecnico> tecnicos = mapper.readValue(replyJson, new TypeReference<List<Tecnico>>() {
						});

						if (tecnicos.isEmpty()) {
							System.out.println("O sistema não possui técnicos cadastrados");
							break;
						}

						for (Tecnico tecnico : tecnicos) {
							System.out.println(tecnico);
						}

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					break;

				case "10":

					try {

						// Enviando os dados para o servidor
						Request request = new Request("10", null);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor
						String replyJson = inputStream.readUTF();

						List<Time> times = mapper.readValue(replyJson, new TypeReference<List<Time>>() {
						});

						if (times.isEmpty()) {
							System.out.println("O sistema não possui times cadastrados");
							break;
						}

						for (Time time : times) {
							System.out.println(time);
						}

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
					break;

				case "11":
					try {

						System.out.println("Digite o nome do time que quer comprar o jogador: ");
						String time = entrada.nextLine();
						System.out.println("Digite o nome do jogador: ");
						String nome = entrada.nextLine();
						System.out.println("Digite o cpf do jogador: ");
						String cpf = entrada.nextLine();

						Request request = new Request("11", time, cpf);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor
						String replyJson = inputStream.readUTF();
						Reply reply = mapper.readValue(replyJson, Reply.class);
						System.out.println(reply.getDescricaoResposta());

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					break;

				case "12":

					try {

						System.out.println("Digite o nome do time que quer comprar o técnico: ");
						String time = entrada.nextLine();
						System.out.println("Digite o nome do técnico: ");
						String nome = entrada.nextLine();
						System.out.println("Digite o cpf do técnico: ");
						String cpf = entrada.nextLine();

						Request request = new Request("12", time, cpf);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor
						String replyJson = inputStream.readUTF();
						Reply reply = mapper.readValue(replyJson, Reply.class);
						System.out.println(reply.getDescricaoResposta());

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					break;

				case "13":

					try {
						System.out.println("Digite o seu nome: ");
						String nome = entrada.nextLine();
						System.out.println("Digite a sua data de nascimento: ");
						String dataNascimento = entrada.nextLine();
						System.out.println("Digite o seu CPF: ");
						String cpf = entrada.nextLine();
						System.out.println("Digite o valor que você vai doar para o clube: ");
						double valor = Double.parseDouble(entrada.nextLine());
						System.out.println("Digite o nome do time que você vai virar sócio: ");
						String nomeTime = entrada.nextLine();

						// Enviando os dados para o servidor
						SocioTorcedor socioTorcedor = new SocioTorcedor(nome, dataNascimento, cpf, valor);
						Request request = new Request("13", socioTorcedor, -1, nomeTime);

						ObjectMapper mapper = new ObjectMapper();
						String requestJson = mapper.writeValueAsString(request);

						outputStream.writeUTF(requestJson);

						// Recebendo os dados do Servidor
						String replyJson = inputStream.readUTF();
						Reply reply = mapper.readValue(replyJson, Reply.class);
						System.out.println(reply.getDescricaoResposta());

					} catch (JsonProcessingException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						System.out.println("Entrada Inválida");
					}

					break;

				case "14":
					sair = true;

					Request request = new Request("sair", null);
					ObjectMapper mapper = new ObjectMapper();
					String requestJson = mapper.writeValueAsString(request);
					outputStream.writeUTF(requestJson);

					entrada.close();
					System.out.println("Logout!");
					break;

				default:
					System.out.println("Entrada inválida!");
					break;
				}
			}

		} catch (UnknownHostException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline: " + e.getMessage());
		} finally {
			if (socketCliente != null) {
				try {
					socketCliente.close();
				} catch (IOException e) {
					System.out.println("Close: " + e.getMessage());
				}
			}
		}

	}

}

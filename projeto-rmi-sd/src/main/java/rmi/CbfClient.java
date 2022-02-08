package rmi;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class CbfClient {

	public static void main(String[] args) {

		Cbf cbf = null;

		try {

			cbf = (Cbf) Naming.lookup("//localhost/Cbf"); // CHAMADA REMOTA
			System.out.println("Found server");

			System.out.println("============================== Projeto RMI ==============================\n");
			System.out.println("1 - Cadastrar jogador");
			System.out.println("2 - Cadastrar time");
			System.out.println("3 - Cadastrar técnico");
			System.out.println("4 - Criar campeonato");
			System.out.println("5 - Listar jogadores");
			System.out.println("6 - Listar técnicos");
			System.out.println("7 - Listar times");
			System.out.println("8 - Listar campeonatos");
			System.out.println("9 - Excluir jogador");
			System.out.println("10 - Excluir Técnico");
			System.out.println("11 - Sair");

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

						String msgRetorno = cbf.addJogador(jogador);

						System.out.println(msgRetorno);

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

						Time time = new Time(nome, estadio, localizacao);

						String msgRetorno = cbf.addTime(time);

						System.out.println(msgRetorno);

					} catch (Exception e) {
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
						System.out.println("Digite o time do técnico: ");
						String time = entrada.nextLine();

						Tecnico tecnico = new Tecnico(nome, dataNascimeto, cpf, time);

						String msgRetorno = cbf.addTecnico(tecnico);

						System.out.println(msgRetorno);

					} catch (Exception e) {
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

							String msgRetorno = cbf.addCampeonatoSerieA(serieA);
							System.out.println(msgRetorno);

						} else if (opcao.equals("2")) {

							System.out.println("Digite o ano do Campeonato: ");
							int ano = Integer.parseInt(entrada.nextLine());
							SerieB serieB = new SerieB(ano, "Serie B");

							String msgRetorno = cbf.addCampeonatoSerieB(serieB);
							System.out.println(msgRetorno);

						}
					} catch (NumberFormatException e) {
						System.out.println("Entrada Inválida");
					}

					break;

				case "5":

					try {

						List<Jogador> jogadores = cbf.jogadores();

						for (Jogador jogador : jogadores) {
							System.out.println(jogador);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "6":

					try {

						List<Tecnico> tecnicos = cbf.tecnicos();

						for (Tecnico tecnico : tecnicos) {
							System.out.println(tecnico);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "7":
					try {

						List<Time> times = cbf.times();

						for (Time time : times) {
							System.out.println(time);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "8":

					try {
						System.out.println("1 - Listar Campeonatos Série A");
						System.out.println("2 - Listar Campeonatos Série B");

						System.out.println(">> ");
						String opcao = entrada.nextLine();

						if (opcao.equals("1")) {

							List<SerieA> serieAs = cbf.campeonatosSerieA();

							for (SerieA serieA : serieAs) {
								System.out.println(serieA);
							}

						} else if (opcao.equals("2")) {

							List<SerieB> serieBs = cbf.campeonatosSerieB();

							for (SerieB serieB : serieBs) {
								System.out.println(serieB);
							}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "9":

					try {
						System.out.println("Digite o CPF do jagador");

						System.out.println(">> ");
						String cpf = entrada.nextLine();

						String msgRetorno = cbf.excluirJogador(cpf);
						System.out.println(msgRetorno);

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "10":

					try {
						System.out.println("Digite o CPF do técnico");

						System.out.println(">> ");
						String cpf = entrada.nextLine();

						String msgRetorno = cbf.excluirTecnico(cpf);
						System.out.println(msgRetorno);

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case "11":
					sair = true;
					entrada.close();
					System.out.println("Logout!");
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

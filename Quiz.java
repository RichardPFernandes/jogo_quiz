import java.util.HashMap;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         HashMap<Usuario, Integer> ranking = new HashMap<Usuario, Integer>();
         cleanScreen();
         System.out.println("Bem vindo ao Quiz!");
         System.out.println("Faça as perguntas e veja quem é o melhor!");
        System.out.println("Digite o numero de perguntas: ");
        int numeroPerguntas = scanner.nextInt();
        Pergunta[] perguntas = new Pergunta[numeroPerguntas];
        cleanScreen();
        for(int i = 0; i < numeroPerguntas; i++){
            cleanScreen();
            scanner.nextLine();
            System.out.println("Digite a pergunta: ");
            String pergunta = scanner.nextLine();
            cleanScreen();
            Alternativas[] alternativas = new Alternativas[4];
            System.out.println("Alternativas: ");
            for(int j = 0; j < 4; j++){
                int alternativa = j + 1;
                System.out.println("Digite a resposta da alterantiva " + alternativa + ": ");
                String respostaAlternativa = scanner.nextLine();
                Alternativas alternativaObjeto = new Alternativas(alternativa, respostaAlternativa);
                alternativas[j] = alternativaObjeto;
            }
            System.out.println("Digite a alterativa certa: ");
            int resposta = scanner.nextInt();
            Pergunta perguntaObjeto = new Pergunta(pergunta, resposta, alternativas);
            perguntas[i] = perguntaObjeto;
        }
        scanner.nextLine();
        cleanScreen();
        do{
            System.out.println("Bem vindo usuário!");
            System.out.println("Faça Cadastro para jogar!");
            System.out.println("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.println("Digite seu email: ");
            String email = scanner.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = scanner.nextLine();
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            for(int i = 0; i < numeroPerguntas; i++){
                cleanScreen();
                perguntas[i].mostrarPergunta();
                System.out.println("Digite a resposta: ");
                int resposta = scanner.nextInt();
                if(perguntas[i].verificarResposta(resposta)){
                    usuario.aumentarPontuacao(10);
                    System.out.println("Resposta correta!");
                    scanner.nextLine();
                }else{
                    usuario.diminuirPontuacao(5);
                    System.out.println("Resposta errada!");
                    System.out.println("Resposta correta: " + perguntas[i].getResposta());
                    scanner.nextLine();
                }
            }
        cleanScreen();
        System.out.println("Pontuação final: " + usuario.getPontuacao());
        ranking.put(usuario, usuario.getPontuacao());
        for(int i = 0; i < ranking.size(); i++){
            Usuario usuarioRanking = (Usuario) ranking.keySet().toArray()[i];
            int pontuacaoRanking = ranking.get(usuarioRanking);
            for(int j = i + 1; j < ranking.size(); j++){
                Usuario usuarioRanking2 = (Usuario) ranking.keySet().toArray()[j];
                int pontuacaoRanking2 = ranking.get(usuarioRanking2);
                if(pontuacaoRanking < pontuacaoRanking2){
                    ranking.put(usuarioRanking, pontuacaoRanking2);
                    ranking.put(usuarioRanking2, pontuacaoRanking);
                }
            }
        }
        System.out.println("Ranking: ");
        for(int i = 0; i < ranking.size(); i++){
            Usuario usuarioRanking = (Usuario) ranking.keySet().toArray()[i];
            int pontuacaoRanking = ranking.get(usuarioRanking);
            System.out.println("Nome: " + usuarioRanking.getNome() + " Pontuação: " + pontuacaoRanking);
        }
        System.out.println("Deseja jogar novamente? (S/N)");
        String resposta = scanner.nextLine();
        if(resposta.equals("N") || resposta.equals("n")){
            break;
        }
        }while(true);
        scanner.close();
        
       
        
        

    }

    public static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private int ranking;
    private int pontuacao;

    public Usuario() {
        this.ranking = 0;
        this.pontuacao = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public int getRanking() {
        return this.ranking;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        if (senha.length() < 6) {
            System.out.println("Senha muito curta!");
        } else {
            this.senha = senha;
        }
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }


    public void aumentarPontuacao(int pontuacao) {
        this.pontuacao += pontuacao;
    }

    public void diminuirPontuacao(int pontuacao) {
        this.pontuacao -= pontuacao;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }



}

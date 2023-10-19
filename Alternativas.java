public class Alternativas {
    public int alternativa;
    public String resposta;

    public Alternativas(int alternativa, String resposta) {
        this.alternativa = alternativa;
        this.resposta = resposta;
    }

    public String toString() {
        return "Alternativa " + this.alternativa + ": " + this.resposta;
    }

    
}

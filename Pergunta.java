public class Pergunta{
    private String pergunta;
    private int resposta;
    private Alternativas[] alternativas = new Alternativas[4];
    
    public Pergunta(String pergunta, int resposta, Alternativas[] alternativas){
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.alternativas = alternativas;
    }

    public String getPergunta(){
        return this.pergunta;
    }

    public int getResposta(){
        return this.resposta;
    }

    public Alternativas[] getAlternativas(){
        return this.alternativas;
    }

    public void setPergunta(String pergunta){
        this.pergunta = pergunta;
    }

    public void setResposta(int resposta){
        this.resposta = resposta;
    }

    public void setAlternativas(Alternativas[] alternativas){
        this.alternativas = alternativas;
    }

    public void mostrarPergunta(){
        System.out.println(this.pergunta);
        for(int i = 0; i < this.alternativas.length; i++){
            System.out.println(this.alternativas[i]);
        }
    }

    public boolean verificarResposta(int resposta){
        if(resposta == this.resposta){
            return true;
        }else{
            return false;
        }
    }
}
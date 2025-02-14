
public class personaxesecundario {
    String nome;
    int vida;

    /**
     * Constructor por defecto
     */

public personaxesecundario() {

    this.nome = "Mutenroy";
    this.vida = 1000;
}

    /**
     * Constructor para nuevo nombre personalizado
     * @param nuevonombre del personaje
     */

public personaxesecundario(String nuevonombre){

    this.nome = nuevonombre;
    this.vida = 100;
}

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int perdervida(int danho){
            if (danho<0){
                danho=0;
            }

            vida = vida-danho;
            if (vida<0){
                vida=0;
             }
            return vida ;

        }
}


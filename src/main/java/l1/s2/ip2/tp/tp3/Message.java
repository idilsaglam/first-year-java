package l1.s2.ip2.tp.tp3;

/**
 * Exercice 2
 */
public class Message {
    public Utilisateur u;
    private String content;

    Message(Utilisateur u, String content){
        this.u = u;
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }


    
}

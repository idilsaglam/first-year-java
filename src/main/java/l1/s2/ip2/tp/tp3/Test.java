package l1.s2.ip2.tp.tp3;

public class Test {
    public static void main(String[] args){
        // Question 1.5
        Utilisateur idil = new Utilisateur("idil", "123123","idil@hello.com");
        Utilisateur fifi = new Utilisateur("fifi", "kakd?","fifi@hello.com");
        System.out.println(idil.testMotDePasse("123123"));
        System.out.println(idil.testMotDePasse("abbba"));

        // Ceci ne doit pas changer le mots de passe car première argument est faux.
        idil.changeMotDePasse("abbb","bb");

        // Ceci doit changer le mots de passe d'Utilisateur idil par "bb".
        idil.changeMotDePasse("123123","bb");

        //Ceci doit renvoyer "idil" car le pseudo d'Utilisateur idil est "idil'
        System.out.println(idil.getPseudonyme());

        // Nous voyons que quand nous appelons le méthode "setPseudonyme", il change le pseudo avec argument donnée.
        idil.setPseudonyme("Kaan");
        System.out.println(idil.getPseudonyme());

        //Exercice 2
        Message m = new Message(idil,"Hello World");
        Message n = new Message(fifi,"Hello!");

        System.out.println(m.getContent());

        //Question 3.6





    }
}

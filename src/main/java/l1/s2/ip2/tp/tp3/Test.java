package l1.s2.ip2.tp.tp3;

public class Test {
    public static void main(String[] args){
        Utilisateur u1 = new Utilisateur("idilsaglam","123","hello@idil.com");
        System.out.println(u1.testMotDePasse("123"));
        System.out.println(u1.testMotDePasse("234"));

        u1.changerMotDePasse("123","456");
        u1.changerMotDePasse("900","555");

        System.out.println(u1.getPseudo());
        u1.setPseudo("Kaan");
        System.out.println(u1.getPseudo());

        Utilisateur u2 = new Utilisateur("lala","19Gd","hello@idil.com");
        Utilisateur u3 = new Utilisateur("fifi","136","hello@fifi.com");
        Utilisateur u4 = new Utilisateur("tutu","12rgr","hello@tutu.com");

        Salon salon = new Salon(new Utilisateur[]{u2,u3,u4});
        Message m = new Message(u2,"Hey");
        Message m2 = new Message(u2,"Heyhey");
        Message m3 = new Message(u2,"Heyheyhey");
        salon.ajouterMessage(m);
        salon.ajouterMessage(m2);
        salon.ajouterMessage(m3);
        salon.afficher();
    }
}

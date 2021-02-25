package l1.s2.ip2.tp.tp3;

import jdk.jshell.execution.Util;

public class Test {
    public static void main(String[] args) {
        // Question 1.5

        // Déclarons deux utilisateur idil et fifi
        Utilisateur idil = new Utilisateur("idil", "123123", "idil@hello.com");
        Utilisateur fifi = new Utilisateur("fifi", "kakd?", "fifi@hello.com");
        Utilisateur riri = new Utilisateur("riri", "kaddd?", "riri@hello.com");
        Utilisateur lili = new Utilisateur("sssfffs", "kfkf?", "lili@hello.com");



        // Ceci va retourner true
        System.out.println(idil.testMotDePasse("123123"));

        // Ceci va retourner false
        System.out.println(idil.testMotDePasse("abbba"));

        // Ceci ne doit pas changer le mots de passe car première argument est faux.
        idil.changeMotDePasse("abbb", "bb");

        // Ceci doit changer le mots de passe d'Utilisateur idil par "bb".
        idil.changeMotDePasse("123123", "bb");

        //Ceci doit renvoyer "idil" car le pseudo d'Utilisateur idil est "idil'
        System.out.println(idil.getPseudonyme());

        // Nous voyons que quand nous appelons le méthode "setPseudonyme", il change le pseudo avec argument donnée.
        idil.setPseudonyme("Kaan");
        System.out.println(idil.getPseudonyme());

        //Exercice 2
        Message m = new Message(idil, "Hello World");
        Message n = new Message(fifi, "Hello!");

        System.out.println(m.getContent());

        //Question 3.6
        Salon salon = new Salon(new Utilisateur[]{idil,fifi});
        Salon salon2 = new Salon(new Utilisateur[]{fifi,riri});
        Chat chat = new Chat();
        //Ceci doit renvoyer false car Utilisateur riri n'est pas présent dans le salon
        System.out.println(salon.estPresent(riri));
        salon.ajouterUtilisateur(riri);
        //Ceci doit renvoyer true car Utilisateur riri est maintenant présent dans le salon
        System.out.println(salon.estPresent(riri));
        //salon.ajouterMessage(idil,"Heyyy");
        //Ceci doit ajouter le message n dans le salon.
        salon.ajouterMessage(n);
        //Ceci doit afficher fifi: Hello car dans le salon il y a que cet message.
        salon.afficher();
        // Ceci doit exclure l'utilisateur idil dans le salon.
        salon.exclusUtilisateur(idil);

        //Question 4.5
        Chat ch = new Chat();
        ch.ajouterSalon(salon);
        ch.ajouterSalon(salon2);

        // Ceci doit renvoyer true car riri est present
        System.out.println(ch.estPresent(riri));
        // Ceci doit renvoyer false car lili n'est pas present
        System.out.println(ch.estPresent(lili));

        // Ceci doit renvoyer le nombre de messages de riri
        System.out.println(ch.nombreMessages(riri));

        //Ceci doit renvoyer le plus bavarde utilisateur du chat
        System.out.println(ch.bavarde());








    }
}

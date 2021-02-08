public class TestEtudiant {

    public static void main(String[] args) {
        Etudiant.afficher(new Etudiant("Idil", "Saglam", 22015094, 20));
        System.out.println(Etudiant.estAdmis(new Etudiant("Kaan", "Yagci", 99712213, 9)));
        System.out.println(Etudiant.estAdmis(new Etudiant("Idil", "Saglam", 22015094, 18)));
        System.out.println(Etudiant.mention(new Etudiant("Kaan", "Yagci", 99712213, -2)));
        System.out.println(Etudiant.mention(new Etudiant("Kaan", "Yagci", 99712213, 21)));
        System.out.println(Etudiant.mention(new Etudiant("Kaan", "Yagci", 99712213, 16)));
        System.out.println(Etudiant.mention(new Etudiant("Kaan", "Yagci", 99712213, 15)));
        System.out.println(Etudiant.mention(new Etudiant("Kaan", "Yagci", 99712213, 13)));
        System.out.println(Etudiant.mention(new Etudiant("Kaan", "Yagci", 99712213, 9)));

    }
}

public class Etudiant {
        String nom;
        String prenom;
        int num;
        int note;

        Etudiant(String nom, String prenom, int num, int note) {
            this.nom = nom;
            this.prenom = prenom;
            this.note = note;
            this.num = num;
        }

        public static void afficher(Etudiant etudiant) {
            System.out.println(etudiant.nom + " " + etudiant.prenom + " (" + etudiant.num + "):" + etudiant.note);
        }

        public static boolean estAdmis(Etudiant etudiant) {
            return etudiant.note >= 10;
        }

        public static String mention(Etudiant etudiant) {
            String note = "";

            if (etudiant.note < 0 || etudiant.note > 20) {
                note = "Note Invalide";
            }

            if (etudiant.note >= 16 && etudiant.note < 20) {
                note = "Très bien";
            }

            if (etudiant.note >= 14 && etudiant.note < 16) {
                note = "Bien";
            }

            if (etudiant.note >= 12 && etudiant.note < 14) {
                note = "Assez Bien";
            }

            if (etudiant.note >= 10 && etudiant.note < 12) {
                note = "Passable";
            }

            if (etudiant.note > 0 && etudiant.note < 10) {
                note = "Ajourné";
            }

            return note;
        }}

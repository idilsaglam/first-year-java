package l1.s2.ip2.tp.tp5;

public class Main {
    public static void main(String[] args){
        Employe e = new Employe("idil",990000);
        Employe kaan = new Employe("kaan",99900999);
        Employe djj = new Employe("djdj",55);
        Employe ee = new Employe("sila",99999);

        Cellule c = new Cellule(e,null);
        Cellule d = new Cellule(kaan,c);
        Cellule f = new Cellule(djj,d);

        Cellule g = new Cellule(ee,null);

        Enteprise enteprise = new Enteprise("aa",f);
        //enteprise.afficher();

        enteprise.ajouteEnTete(g);
        enteprise.afficher();

        enteprise.ajouteEnTete(g);
        enteprise.afficher();

        System.out.println(enteprise.appartient("idil"));
        System.out.println(enteprise.appartient("sila"));

        enteprise.demission("sila");
        enteprise.afficher();
        System.out.println(enteprise.appartient("sila"));
    }
}

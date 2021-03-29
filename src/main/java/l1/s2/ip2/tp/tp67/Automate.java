package l1.s2.ip2.tp.tp67;

public class Automate {
    private Cellule fin;
    private Cellule debut;

    /*
     * Question 1.2
     */
    public void ajouter(boolean b){
        if(this.debut == null){
            return;
        }
        Cellule tmp =this.debut;
        this.debut = new Cellule(b);
        this.debut.setSuivante(tmp);
    }

    public Cellule getFin(){
        return this.fin;
    }
    public Cellule getDebut(){
        return this.debut;
    }
    public void setFin(Cellule fin){
        this.fin = fin;
    }
    public void setDebut(Cellule debut){
        this.debut = debut;
    }

    public Automate(String str){
        Cellule res = new Cellule(true);
        if(str.charAt(0) == '-'){
            res.setNoire(false);
        }
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)=='#'){
                res.ajouteALaFin(new Cellule(true));
                continue;
            }
            res.ajouteALaFin(new Cellule(false));

        }
    }

    public void initialisation(){
        Cellule a = new Cellule(true);
        Cellule b = new Cellule(true);
        Cellule c = new Cellule(true);

        Cellule d = new Cellule(false);
        Cellule e = new Cellule(false);
        Cellule f = new Cellule(false);

        Cellule g = new Cellule(true);
        Cellule h = new Cellule(false);
        Cellule i = new Cellule(false);
        Cellule j = new Cellule(false);
        Cellule k = new Cellule(false);

        this.debut = a;
        a.setSuivante(b);
        b.setSuivante(c);
        c.setSuivante(d);
        d.setSuivante(e);
        e.setSuivante(f);
        f.setSuivante(g);
        g.setSuivante(h);
        h.setSuivante(i);
        i.setSuivante(j);
        j.setSuivante(k);
        this.fin = k;
    }

    public void changeStatus(){
        if(this.debut == null){
            return;
        }
        this.debut.changeStatus();
    }


    public void prochaineEtape(){
        if(this.debut == null){
            return;
        }
        if(this.debut.getSuivante() == null){
            this.debut.setProchainEtat(false);
        }
        this.debut.setProchainEtat(this.debut.getSuivante().getNoir());
        this.fin.setProchainEtat(this.fin.getPrecedente().getNoir());
        this.debut.prochaineEtape();
    }

    public void uneEtape(){
        if(this.debut == null) {
            return;
        }
        this.debut.prochaineEtape();
        this.debut.miseAJour();
    }

    public void nEtapes(int n){
        if(this.debut == null){
            return;
        }
        this.debut.nEtapes(n);
    }

}

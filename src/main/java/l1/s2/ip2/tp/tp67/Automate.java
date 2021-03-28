package l1.s2.ip2.tp.tp67;

public class Automate {
    public Cellule fin;
    public Cellule debut;

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
        this.changeStatus();
    }
}

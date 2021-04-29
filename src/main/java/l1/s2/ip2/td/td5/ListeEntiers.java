package l1.s2.ip2.td.td5;

public class ListeEntiers {
    private Cellule premier;

    public ListeEntiers(){
        this.premier = null;
    }

    public Cellule getPremier(){
        return this.premier;
    }
    public void setPremier(Cellule premier){
        this.premier = premier;
    }

    public void add(int x){
        if(this.premier == null){
            this.premier = new Cellule(x);
            return;
        }
        Cellule tmp = this.premier;
        this.setPremier(new Cellule(x));
        this.premier.setSuivante(tmp);
    }

    public void description(){
        if(this.premier == null){
            return;
        }
        this.premier.description();
    }

    public void description2(){
        if(this.premier == null){
            return;
        }
        System.out.print("(");
        this.premier.description2();
    }
    public int taille(){
        if(this.premier == null){
            return 0;
        }
        return this.premier.taille();
    }

    public int somme(){
        if(this.premier == null){
            return 0;
        }
        return this.premier.somme();
    }

    public void ajouter_en_i(int i, int v ){
        if(this.premier == null){
            return;
        }
        if(i<0){
            Cellule c = new Cellule(v);
            Cellule tmp = this.premier;
            this.setPremier(c);
            c.setSuivante(tmp);
            return;
        }

        this.premier.ajouter_en_i(i,v);
    }

    public boolean egal(ListeEntiers liste){
        if(this.premier == null){
            return false;
        }
        return this.equals(liste);
    }

    public int supprimer_k_occ(int k,int v){
        if(this.premier == null){
            return 0;
        }
        return this.premier.supprimer_k_occ(k,v);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof ListeEntiers){
            ListeEntiers l = (ListeEntiers) o;
            return this.premier.equals(l.premier);
        }
        return false;
    }
}

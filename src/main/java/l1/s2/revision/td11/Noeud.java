package l1.s2.revision.td11;

import java.util.ArrayList;

public class Noeud {
    ArrayList<Noeud> fils = new ArrayList<Noeud>();
    char character;

    public Noeud(){
        this.fils = new ArrayList<>();
        this.character = '\0';
    }
    public Noeud(char c) {
        this.character = c;
        this.fils = new ArrayList<>();
    }

    public Noeud aPourEnfant(char a){
        if(this.character==a){
            return this;
        }
        for(int i=0; i<fils.size(); i++) {
            Noeud f = this.fils.get(i); // i inci elemnanini aliyor.
            if (f.character != ' ') {
                f = f.aPourEnfant(a);
            }
            if(f != null){
                return f;
            }
        }
        return null;
    }

    public boolean appartient(String w){
        if(this.character !=w.charAt(0)){
            return false;
        }
        w=w.substring(1);
        boolean res = false;
        for(int i=0; i<this.fils.size(); i++){
            Noeud n = this.fils.get(i);
            if(n.character==' ' && w.length()==0){
                return true;
            }
            if(n.character!=' ') {
                res = res || n.appartient(w);
            }
        }
        return res;
    }


    private void ajouteMotInterne(String mot) {
        mot = mot.substring(1);
        if (mot.length() == 0) {
            for (int i = 0; i<this.fils.size(); i++) {
                if (this.fils.get(i).character == ' ') {
                    return;
                }
            }
            this.fils.add(new Noeud(' '));
            return;
        }
        for (int i = 0; i<this.fils.size(); i++) {
            if (this.fils.get(i).character == mot.charAt(0)) {
                this.fils.get(i).ajouteMotInterne(mot);
                return;
            }
        }
        Noeud n = new Noeud(mot.charAt(0));
        this.fils.add(n);
        n.ajouteMotInterne(mot);
    }

    public void ajouteUnMot(String mot){
        if (this.character == mot.charAt(0)) {
            this.ajouteMotInterne(mot);
        }
    }


    public void afficheSorted() {

    }




}

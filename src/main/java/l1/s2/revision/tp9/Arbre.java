package l1.s2.revision.tp9;

public class Arbre {
    private Noeud sommet;
    public Arbre(Noeud sommet){
        this.sommet = sommet;
    }
    public Arbre(){
        this.sommet = null;
    }

    public Arbre(Arbre a){
        if(a == null || a.sommet==null){
            this.sommet=null;
            return;
        }
        this.sommet=a.sommet.copie();
    }

    public Arbre(int[] tab){
        if(tab.length==0){
            this.sommet=null;
            return;
        }
        int r = tab.length/2;
        this.sommet=new Noeud(tab[r]);
            this.sommet.setGauche(new Arbre(subArray(tab,0,r)).sommet);
            this.sommet.setDroit(new Arbre(subArray(tab,r+1,tab.length)).sommet);

    }

    private int[] subArray(int[] array, int start,int end){
        int[] m = new int[end-start];
        for(int i=0; i<end-start; i++){
            m[i] = array[start+i];
        }
        return m;
    }

    public void afficheInfixe(){
        if(this.sommet == null){
            return;
        }
        this.sommet.afficheInfixe();
    }

    public void afficheSuffixe(){
        if(this.sommet == null){
            return;
        }
        this.sommet.afficheSuffixe();
    }

    public void affichePrefixe(){
        if(this.sommet == null){
            return;
        }
        this.sommet.affichePrefixe();
    }

    public int nbDeNoeuds(){
        if(this.sommet == null) {
            return 0;
        }
        return this.sommet.nbDeNoeuds();
    }

    public int somme(){
        if(this.sommet == null){
            return 0;
        }
        return this.sommet.somme();
    }

    public boolean recherche(int e){
        if(this.sommet == null){
            return false;
        }
        return this.sommet.recherche(e);
    }

    public void affiche(int p)  {
        if(this.sommet==null){
            return;
        }
         this.sommet.affiche(p);
    }

    public void affichePenchee(){
        if(this.sommet==null){
            return;
        }
        this.sommet.affiche(0);
    }

    public void afficheLargeur() {
        if (this.sommet == null) {
            return;
        }
        NodeList list = new NodeList();
        list.push(this.sommet);
        while(list.getRoot() != null) {
            Noeud n = list.pop();
            System.out.printf("%s ",n.getEtiquette());
            if (n.getGauche() != null) {
                list.push(n.getGauche());
            }
            if (n.getDroit() != null) {
                list.push(n.getDroit());
            }
        };
    }
}

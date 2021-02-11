package l1.s2.ip2.td.td3;

public class Gestion {
    Article[] catalogue;
    Article[] vendus;
    Gestion(Article[] catalogue, Article[] vendus){
        this.catalogue = catalogue;
        this.vendus = vendus;
    }
    public void vendre(Article article){
        Article[] newVendus = new Article[this.vendus.length+1];
        for(int i=0; i<newVendus.length-1; i++){
            newVendus[i] = this.vendus[i];
        }
        newVendus[this.vendus.length+1] = article;
        this.vendus = newVendus;

        Article[] newCatalogue = new Article[this.catalogue.length-1];
        for(int i=0; i<catalogue.length; i++){
            if(catalogue[i].equals(article)){
                continue;
            }
            newCatalogue[i] = this.catalogue[i];
            this.catalogue = newCatalogue;
        }
    }
}

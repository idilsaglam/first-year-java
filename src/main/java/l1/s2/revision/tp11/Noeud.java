package l1.s2.revision.tp11;

import java.util.ArrayList;

    public class Noeud {
        ArrayList<Noeud> fils = new ArrayList<>();
        String etiquette;

        public Noeud(){
            this.fils = new ArrayList<>();
            this.etiquette = null;
        }
        public Noeud(String c) {
            this.etiquette = c;
            this.fils = new ArrayList<>();
        }

        public void addFils(Noeud n) {
            this.fils.add(n);
        }

        private static boolean estNombre(String x){
            return x.matches("^(\\+|-)?[0-9]+(\\.[0-9]+)?$"); //pipe ayiriyor, ? olabilir
        }

        private static boolean estMathOperator(String s) {
            return s.matches("^(\\+|-|/|\\*)$");
        }

        public boolean verif() {
            //gercek bir sayi mi diye kontrol etmek
            //feuille ler sayi olacak sekilde

            // Feuille nodelar bir sayi mi diye kontrol et
            if (this.fils.size() == 0) {
                return estNombre(this.etiquette);
            }
            // Feuille olmayan nodelar matematik sembolu mu diye kontrol et
            if (!estMathOperator(this.etiquette)) {
                return false;
            }
            boolean result = true;
            for (int i = 0; i<this.fils.size(); i++) {
                result = result && this.fils.get(i).verif();
            }
            return result;
        }

        public void afficheInfixe(){
            if (this.fils.size() == 1) {
                // In this case, we have an unary operation such as absolute value or unary minus
                System.out.print(this.etiquette);
                this.fils.get(0).afficheInfixe();
            }
            if (this.fils.size() == 0) {
                System.out.print(this.etiquette);
            }
            if (this.fils.size() > 1) {
                for (int i = 0; i<this.fils.size(); i++) {
                    this.fils.get(i).afficheInfixe();
                    if (i < this.fils.size() -1) { // sondan bir oncekine kadar kendisine basiyor ex +
                        System.out.print(this.etiquette);
                    }
                }
            }
        }

        public void afficheExpression(){
            if (this.fils.size() == 1) {
                // In this case, we have an unary operation such as absolute value or unary minus
                System.out.print("(");
                System.out.print(this.etiquette);
                System.out.print("(");
                this.fils.get(0).afficheExpression();
                System.out.print(")");
                System.out.print(")");
            }
            if (this.fils.size() == 0) {
                System.out.print(this.etiquette);
            }
            if (this.fils.size() > 1) {
                System.out.print("(");
                for (int i = 0; i<this.fils.size(); i++) {
                    this.fils.get(i).afficheExpression();
                    if (i < this.fils.size() -1) { // sondan bir oncekine kadar kendisine basiyor ex +
                        System.out.print(this.etiquette);
                    }
                }
                System.out.print(")");
            }
        }

        public double eval(){

        }




    }

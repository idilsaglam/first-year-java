package l1.s2.ip2.tp.tp10;

public class Paire {
    private int value;
    private Noeud node;

    public Paire(int v, Noeud n) {
        this.value = v;
        this.node = n;
    }

    public Paire(Noeud n) {
        this.value =










































                n.hauteur();
        this.node = n;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Noeud getNode() {
        return node;
    }

    public void setNode(Noeud node) {
        this.node = node;
    }

}

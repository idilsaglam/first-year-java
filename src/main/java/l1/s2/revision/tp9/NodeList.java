package l1.s2.revision.tp9;

public class NodeList {
    private NodeListElement root;

    NodeList() {
        this.root = null;
    }

    public NodeListElement getRoot() {
        return root;
    }

    public void setRoot(NodeListElement root) {
        this.root = root;
    }

    public Noeud pop() {
        if (this.root == null) {
            return null;
        }
        NodeListElement oldRoot = this.root;
        this.root = this.root.getNext();
        return oldRoot.getContent();
    }

    public void push (Noeud n) {
        NodeListElement ne = new NodeListElement(n, null);
        if (this.root == null) {
            this.root = ne;
            return;
        }
        NodeListElement tmp = this.root;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(ne);
    }

}

package l1.s2.revision.tp9;

public class NodeListElement {
    private Noeud content;
    private NodeListElement next;

    public NodeListElement(Noeud content, NodeListElement next) {
        this.content = content;
        this.next = next;
    }

    public Noeud getContent() {
        return content;
    }

    public void setContent(Noeud content) {
        this.content = content;
    }

    public NodeListElement getNext() {
        return next;
    }

    public void setNext(NodeListElement next) {
        this.next = next;
    }
}

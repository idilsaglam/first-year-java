
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static int fermantCorrespondant(String programme, int depart){
        Stack<Character> stack = new Stack<>();

        for (int i = depart; i < programme.length(); i++) {
            if (programme.charAt(i) == '[') {
                stack.push(programme.charAt(i));
            }
            if (programme.charAt(i) == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                    if (stack.empty()) {
                        return i;
                    }
                    continue;
                }
                stack.push(programme.charAt(i));
            }
        }
        return -1;
    }

    public static int ouvrantCorrespondant(String programme, int depart) {
        Stack<Character> stack = new Stack<>();
        for (int i = depart; i >= 0; i--) {
            if (programme.charAt(i) == ']') {
                stack.push(programme.charAt(i));
            }
            if (programme.charAt(i) == '[') {
                if (stack.peek() == ']') {
                    stack.pop();
                    if (stack.empty()) {
                        return i;
                    }
                    continue;
                }
                stack.push(programme.charAt(i));
            }
        }
        return -1;
    }
    public static void brainf_ck(String programme) {
        Memoire memoire = new Memoire(programme.length());
        int i = 0;
        while (i<programme.length()) {
            char currentChar = programme.charAt(i);
            switch (currentChar) {
                case '>':
                    memoire = memoire.getSuivante();
                    i++;
                    break;
                case '<':
                    memoire = memoire.getPrecedente();
                    i++;
                    break;
                case '+':
                    memoire.incrementValeur();
                    i++;
                    break;
                case '-':
                    memoire.decrimentValeur();
                    i++;
                    break;
                case '.':
                    System.out.println(memoire.getValeur());
                    i++;
                    break;
                case ',':
                    System.out.print("Veuillez saisir une valeur: ");
                    Scanner s = new Scanner(System.in);
                    int newValue = s.nextInt();
                    memoire.setValeur(newValue);
                    i++;
                    break;
                case '[':
                    if (memoire.getValeur() == 0) {
                        i = fermantCorrespondant(programme,i) + 1;
                    } else {
                        i++;
                    }
                    break;
                case ']':
                    i = ouvrantCorrespondant(programme, i);
                    break;
                default:
                    i++;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Memoire m = new Memoire(5);
        m.inspecte();
        m = m.getSuivante().getSuivante().getSuivante();
        m.setValeur(42);
        m.inspecte();
        m = m.getPrecedente();
        m.setValeur(11);
        m.inspecte();
        brainf_ck(",>,[-<->]<.");
        //brainf_ck(">>,<[>[<<+<+>>>-]<<[>>+<<-]>-]>[-]<<[-]<.");
    }
}

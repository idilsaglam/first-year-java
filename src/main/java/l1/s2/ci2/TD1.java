package l1.s2.ci2;
import java.util.Stack;

public class TD1 {
  public void afficher(Stack<Integer> s1){
    return;
  }
  public void transvaser(Stack<Integer> s1, Stack<Integer> s2){
    if(s1 == null || s2 == null){
        return;
    }
    while(!s1.empty()){
        s2.push(s1.pop());
    }
  }
  public void deplacer(Stack<Integer> s1, Stack<Integer> s2){
    if(s1 == null || s2 == null){
        return;
    }
    transvaser(s1,s2);
    Stack<Integer> s3 = new Stack<Integer>();
    transvaser(s2,s3);
  }
  public void deplacerPairImpair(Stack<Integer> s1, Stack<Integer> pair){

      if(s1 == null || pair == null){
          return;
      }
      Stack<Integer> impair = new Stack<Integer>();

      while(!s1.empty()){
          int c = s1.pop();
          if(c % 2 == 0){
            pair.push(c);
          }else{
              impair.push(c);
          }
      }

      while (!pair.empty()){
          impair.push(pair.pop());
      }
  }

  public void copierPairs(Stack<Integer> s1, Stack<Integer> s2){
      if(s1 == null || s2 == null){
          return;
      }
      int c = s1.pop();
      Stack<Integer> s3 = new Stack<Integer>();
      while (!s1.empty()){
          if(c % 2 == 0){
              s2.push(c);
              s3.push(c);
          }
      }
  }


}

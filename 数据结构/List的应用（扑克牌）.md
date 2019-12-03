public class Card {

        public int rank;  //牌面值
        public String suit; //花色
        Card(int rank,String suit){
            this.suit = suit;
            this.rank = rank;
        }
        @Override
        public String toString(){
    
            return String.format("[%s %d]",suit,rank);//覆写toString方法
        }

}



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class pork {
    public static final String[] huase = {"♠", "♥", "♣", "♦"};
    public static List<Card> creatCard(){
        List<Card> deck = new ArrayList<>(52);
        for(int i=0;i<4;i++){  //四种花色
            for(int j=0;j<13;j++){  //每种花色十三张

                Card card = new Card(j+1,huase[i]);
                deck.add(card);
            }
    
        }
        return deck;
    }
    public static void shuffle(List<Card> deck){ //洗牌
        Random random = new Random(20191203);  //设置随机数
        for(int i=deck.size()-1;i>0;i--){ 
            int j = random.nextInt(i); 
            swap(deck,i,j);
        }
    }
    private static void swap(List<Card> deck,int i,int j){
        Card temp = deck.get(i);  //临时对象拿到deck 的i位置
        deck.set(i,deck.get(j)); //将deck的i位置设置为j位置的对象
        deck.set(j,temp);//将j位置设置为i位置的对象以完成交换牌
    }
    
    public static void main(String[] args) {
        List<Card> deck = creatCard();
        System.out.println("刚买回的牌");
        System.out.println(deck);
        shuffle(deck);
        System.out.println("洗过的牌");
        System.out.println(deck);
        List<List<Card>> hands = new ArrayList<>(); 
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        for(int i=0;i<5;i++){
            for(int j =0;j<3;j++){
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println("剩余的牌");
        System.out.println(deck);
        System.out.println("A手中的牌");
        System.out.println(hands.get(0));
        System.out.println("B手中的牌");
        System.out.println(hands.get(1));
        System.out.println("C手中的牌");
        System.out.println(hands.get(2));
    }
}
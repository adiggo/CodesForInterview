package GuideWire;

import java.util.*;

/**
 * Created by i843719 on 12/9/14.
 */
public class PokerGame {
    public class Card {
        String val;
        String color;

        public Card(String val, String color) {
            this.val = val;
            this.color = color;
        }
    }

    int cardsForFive = 5;
    public boolean isValidTwoPair(Card[] cards) {
        if (cards == null) return false;
        if (cards.length != cardsForFive)
            return false;
        for (Card card : cards) {
            if (card.getClass() != Card.class)
                return false;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < cards.length; i++) {
            if (!map.containsKey(cards[i].val)) {
                map.put(cards[i].val, 1);
            } else {
                map.put(cards[i].val, map.get(cards[i].val) + 1);
            }
        }
        Collection<Integer> c = map.values();
        if (c.size() != 3)
            return false;
        //System.out.println(c);
        for (Integer i : c) {
            if (i != 1 && i != 2) { // if there is one number is not 1 or 2, return false; since the total num is fixed: 5
                // System.out.println(i);
                return false;
            }
        }
        // System.out.println(c);
        return true;
    }


    public boolean isValidFiveLong(Card[] cards) {

        if (cards == null || cards.length != 5)
            return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        // add number into treeset, and return false if dup
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].val.equals("A")) {
                set.add(1);
            } else if (cards[i].val.equals("J")) {
                set.add(11);
            } else if (cards[i].val.equals("Q")) {
                set.add(12);
            } else if (cards[i].val.equals("K")) {
                set.add(13);
            } else {
                if (Integer.valueOf(cards[i].val) <= 10 && Integer.valueOf(cards[i].val) >= 2) {
                    set.add(Integer.valueOf(cards[i].val));
                }
            }
        }
        if (set.size() != 5)
            return false;
        if (set.contains(1)) {
            if (set.contains(2)) {
                isAdjacent(set);
            } else if (set.contains(11)) {
                int prev = set.pollFirst();
                boolean check = false;
                while (!set.isEmpty()) {
                    int cur = set.pollFirst();
                    if (!check) {
                        check = true;
                        if (cur - prev != 9)
                            return false;
                    } else {
                        if (cur - prev != 1)
                            return false;
                    }
                    prev = cur;
                }
                return true;
            } else {
                return false;
            }
        } else {
            isAdjacent(set);
        }
        return true;
    }

    private boolean isAdjacent(TreeSet<Integer> set) {
        int prev = set.pollFirst();
        while (!set.isEmpty()) {
            int cur = set.pollFirst();
            if (cur - prev != 1)
                return false;
            prev = cur;   //update prev
        }
        return true;
    }


    public boolean isSameColor(Card[] cards){
        if (cards.length != 5)
            return false;
        HashSet<String> color = new HashSet<String>();
        for (int i = 0; i < cards.length; i++){
            color.add(cards[i].color);
        }
        if (color.size() == 1)
            return true;
        else
            return false;
    }

    public boolean isFourSameNumber(Card[] cards){
        if (cards.length != 5)
            return false;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i].val)) {
                map.put(cards[i].val, map.get(cards[i].val) + 1);
            }else{
                map.put(cards[i].val, 1);
            }
        }
        // because it at most have 4 same number
        if (map.size() != 2){
            return false;
        }
        for (Integer i : map.values()){
            if (i != 1 && i != 4){
                return false;
            }
        }
        return true;
    }

    public boolean threeToTwoPair(Card[] cards){
        if (cards.length != 5)
            return false;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < cards.length; i++){
            if (map.containsKey(cards[i].val)){
                map.put(cards[i].val, map.get(cards[i].val) + 1);
            }else{
                map.put(cards[i].val, 1);
            }
        }
        if (map.size() != 2)
            return false;
        Collection<Integer> helper = map.values();
        for (Integer i : helper){
            if (i != 2 && i != 3)
                return false;
        }
        return true;
    }

}

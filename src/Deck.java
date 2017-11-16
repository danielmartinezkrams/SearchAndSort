import java.util.Arrays;
import java.util.Collections;

public class Deck {
    Card[] allCards = new Card[52];
    Card[] hand = new Card[7];
    static int cardCount = 0;
    public Deck(boolean fullSize){
        cardCount = 0;
        if(fullSize){
            for(int i = 1; i <= 4; i++){
                for(int j = 1; j <= 13; j++){
                    allCards[cardCount] = new Card(i, j);
                    cardCount++;
                }
            }
        }
        else{
            for(int k = 0; k < 13; k++){
                allCards[cardCount] = new Card(1, k);
                cardCount++;
            }
        }
    }
    public void swap(int first, int second) {
        Card extra = hand[first];
        hand[first] = hand[second];
        hand[second] = extra;
    }
    public void dealHand(int numCards){
        for(int n = 0; n < numCards; n++){
            hand[n] = allCards[n];
        }
    }
    public void listHand(){
        for(int i = 0; i < hand.length; i++){
            System.out.println(hand[i].name + " ");
        }
    }
    public void shuffleDeck(){
        Collections.shuffle(Arrays.asList(allCards));
    }
    public void bubbleSortHand(){
        for(int z = 0; z < hand.length - 1; z++){
            for(int i = 0; i < hand.length - 1; i++){
                if(hand[i].value > hand[i+1].value){
                    swap(i, i+1);
                }
            }
        }
    }
    public void selectionSortHand(){
        for(int i = 0; i < hand.length - 1; i++){
            if(hand[i].value < hand[i+1].value){
                int lowest = i;
                swap(0, i);
                if(hand[i].value < hand[i+1].value){
                    lowest = i;
                    swap(0, i);
                }
            }
        }
    }
    public void mergeSortHand() {
        mergeSort(hand);
    }
    public void mergeSort(Card[] array){
        if (array.length > 2) {
            Card[] left = leftHalf(array);
            Card[] right = rightHalf(array);
            mergeSort(leftHalf(array));
            mergeSort(right);
            merge(array, left, right);
        }
    }
    public static Card[] leftHalf(Card[] array) {
        int size = array.length / 2;
        Card[] left = new Card[size];
        for (int i = 0; i < size; i++) {
            left[i] = array[i];
        }
        return left;
    }
    public static Card[] rightHalf(Card[] array) {
        int size = array.length / 2;
        int sizeB = array.length - size;
        Card[] right = new Card[sizeB];
        for (int i = 0; i <= sizeB - 1; i++) {
            right[i] = array[i - 1 + sizeB];
        }
        return right;
    }
    public static void merge(Card[] result, Card[] left, Card[] right) {
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = 0; i < result.length; i++) {
            if (indexRight >= right.length || (indexLeft < left.length && left[indexLeft].value <= right[indexRight].value)) {
                result[i] = left[indexLeft];
                indexLeft++;
            } else {
                result[i] = right[indexRight];
                indexRight++;
            }
        }
    }
    public void binarySearchHand(int searchSuit, int searchFace){
        binarySearch(hand, searchSuit, searchFace);
    }
    public void binarySearch(Card[] array, int searchSuit, int searchFace){
        if(searchSuit == array[array.length / 2].suit && searchFace == array[array.length / 2].value){
            System.out.println("Found: " + array[array.length / 2].name);
        }
        if(searchSuit < array[array.length / 2].suit || searchFace < array[array.length / 2].value){
            binarySearch(leftHalf(array), searchSuit, searchFace);
        }
        if(searchFace > array[array.length / 2].value || searchSuit > array[array.length / 2].suit){
            binarySearch(rightHalf(array), searchSuit, searchFace);
        }
        if(array.length == 1){
            System.out.println("Card not in hand");
        }
    }
}



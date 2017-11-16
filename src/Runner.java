public class Runner {
    int cards[];
    public static void main(String args[]){
        Deck d = new Deck(true);
        d.shuffleDeck();
        d.dealHand(7);
        d.listHand();
        d.bubbleSortHand();
        System.out.println("Bubble Sort:");
        d.listHand();
        d.selectionSortHand();
        System.out.println("Selection Sort:");
        d.listHand();
        d.mergeSortHand();
        System.out.println("Merge Sort:");
        d.listHand();
        d.binarySearchHand(2,3);
    }


}

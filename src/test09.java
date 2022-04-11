public class test09 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,8};
        SingListNodeInser singListNodeInser = new SingListNodeInser();
        SingListNode listNode = singListNodeInser.arrayToListNode(arr);
        singListNodeInser.addnode(new SingListNode(8));
        singListNodeInser.addnode(new SingListNode(2));
        singListNodeInser.addnode(new SingListNode(77));
        singListNodeInser.printListNode();
    }
}

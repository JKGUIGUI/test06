public class ArrayToDoubleListNode {
    public ArrayToDoubleListNode(int[] arr){
        HeroNode head = new HeroNode(arr[0]); //根节点
        HeroNode other = head; //临时变量
        for (int i = 1;i<arr.length;i++){ //从1开始遍历数组
            HeroNode temp = new HeroNode(arr[i]);//每循环一次生成一个新的节点
            other.next = temp;  //将other的下一个节点指向生成的新节点
            other = temp;  //other为临时变量，指向当前节点
        }
    }
}

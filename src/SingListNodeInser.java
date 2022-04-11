public class SingListNodeInser {
    SingListNode root ;
    /*
    将数组转化为链表
     */
    public SingListNode arrayToListNode(int[] arr){
        //生成链表的根节点，并将数组的第一个元素的值赋给链表的根节点
        SingListNode root = new SingListNode(arr[0]);
        SingListNode other = root; //other作为临时变量
        for (int i = 1;i<arr.length;i++){ //从1开始遍历数组
            SingListNode temp = new SingListNode(arr[i]);//每循环一次生成一个新的节点
            other.next = temp;  //将other的下一个节点指向生成的新节点
            other = temp;  //other为临时变量，指向当前节点
//            if(i==arr.length-1){
//                temp.next = null;
//            }
        }
       this.root = root;
        return root;
    }

    /*
    将元素插入链表
     */
    public void addnode(SingListNode node){
        SingListNode temp = root;  //临时变量
        if (root.next == null){
            root.next = node;
            System.out.println("到尾了");
            return;
        }
        while (temp.next!=null&&temp.next.val<node.val){
            temp = temp.next;  //往下遍历下一个节点
        }
        if (temp.next == null){//到链表尾
            temp.next = node;
            node.next = null;
        }else {
            node.next = temp.next;
            temp.next = node;
        }
        System.out.println("节点"+node.val+"插入成功");
    }

    /*
    遍历链表
     */
    public void printListNode(){
        SingListNode temp = root;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }

}




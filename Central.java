public class Central {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = linkedList.head();
        linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.add(new LinkedList.Node("6"));
        linkedList.add(new LinkedList.Node("7"));
        linkedList.add(new LinkedList.Node("8"));
        linkedList.add(new LinkedList.Node("9"));
        linkedList.add(new LinkedList.Node("10"));
        linkedList.add(new LinkedList.Node("11"));
        linkedList.add(new LinkedList.Node("12"));
        linkedList.add(new LinkedList.Node("13"));
        linkedList.add(new LinkedList.Node("14"));
        linkedList.add(new LinkedList.Node("15"));
        linkedList.add(new LinkedList.Node("16"));
        linkedList.add(new LinkedList.Node("17"));
        linkedList.add(new LinkedList.Node("18"));
        linkedList.add(new LinkedList.Node("19"));
        linkedList.add(new LinkedList.Node("20"));
        linkedList.add(new LinkedList.Node("21"));
        linkedList.add(new LinkedList.Node("22"));
        LinkedList.Node middle = head;
        int length = 0;
        LinkedList.Node current = head;

        while (current.next() != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next();
            }
            current = current.next();
        }
        if (length % 2 == 1) {
            middle = middle.next();
        }

        System.out.println("Middle element of LinkedList: " + middle);
        System.out.println("Length of LikedList: " + length);
    }
}
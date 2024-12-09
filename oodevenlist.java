public class oodevenlist {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public static oodevenlist.ListNode insert(ListNode head, int val) {
            ListNode node = new ListNode(val);
            ListNode current = head;
            if (head == null)
                return node;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            return head;
        }

        public static void print(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + "->");
                current = current.next;
            }
            System.out.println("null");
        }

        private static ListNode even(ListNode head) {
            ListNode evenHead = null; // Head of the new list
            ListNode evenTail = null; // Tail to keep track of the last node in the new list
            ListNode current = head;

            while (current != null) {
                if (current.val % 2 == 0) { // Check if the value is even
                    ListNode newNode = new ListNode(current.val); // Create a new node
                    if (evenHead == null) { // First even-valued node
                        evenHead = newNode;
                        evenTail = newNode;
                    } else { // Append to the new list
                        evenTail.next = newNode;
                        evenTail = newNode;
                    }
                }
                current = current.next; // Move to the next node
            }
            return evenHead; // Return the head of the new even list
        }

        private static oodevenlist.ListNode odd(ListNode head) {
            ListNode oddHead = null; // Head of the new list
            ListNode oddTail = null; // Tail to keep track of the last node in the new list
            ListNode current = head;

            while (current != null) {
                if (current.val % 2 == 1) { // Check if the value is even
                    ListNode newNode = new ListNode(current.val); // Create a new node
                    if (oddHead == null) { // First even-valued node
                        oddHead = newNode;
                        oddTail = newNode;
                    } else { // Append to the new list
                        oddTail.next = newNode;
                        oddTail = newNode;
                    }
                }
                current = current.next; // Move to the next node
            }
            return oddHead; // Return the head of the new even list
        }

        public static oodevenlist.ListNode mergeLists(ListNode head) {
            ListNode oddList = odd(head);    // Extract odd-valued nodes
            ListNode evenList = even(head);  // Extract even-valued nodes
        
            if (oddList == null) return evenList;  // If no odd nodes, return even list
            if (evenList == null) return oddList;  // If no even nodes, return odd list
        
            // Find the last node of the odd list
            ListNode tail = oddList;
            while (tail.next != null) {
                tail = tail.next;
            }
        
            // Append the even list to the end of the odd list
            tail.next = evenList;
            return oddList;  // Return merged list
        }
        
    }

    public static void main(String[] args) {
        ListNode merge = null;
        ListNode head = null;
       
        head = ListNode.insert(head, 1);
        head = ListNode.insert(head, 2);
        head = ListNode.insert(head, 3);
        head = ListNode.insert(head, 4);
        head = ListNode.insert(head, 5);
        ListNode.print(head);
       
        head = ListNode.mergeLists(head);
        ListNode.print(head);
    }

}
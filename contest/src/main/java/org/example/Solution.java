package org.example;

import java.util.*;

class Solution {
        public Node hasCycle(Node head) {
            if(head == null || head.next == null ){
                return null;
            }

            Node link1 = head;
            Node link2 = head.next;
            int i = 0;
            while (link1 != link2 && link2 != null){
                link2 = link2.next;
                if(link1 == link2){
                    break;
                }
                if( link2 == null){
                    return null;
                }
                link2 = link2.next;

                link1 = link1.next;
                i++;

            }
            if(link2 == link1){
                Node temp = head;
                for(int j =0;j < i; j++){
                    temp = temp.next;
                }
                return temp;
            }else{
                return null;
            }
        }
}
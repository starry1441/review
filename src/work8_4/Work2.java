package work8_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -08 -04
 * Time: 15:29
 */
public class Work2 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k == 0) return new ArrayList<Integer>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });
        for(int i = 0; i < input.length; i++) {
            if(queue.size() < k) {
                queue.offer(input[i]);
            }else {
                int top = queue.peek();
                if(input[i] < top) {
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list;
    }

}

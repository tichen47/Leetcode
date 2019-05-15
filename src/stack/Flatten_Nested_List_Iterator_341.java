package stack;

import java.util.*;

public class Flatten_Nested_List_Iterator_341 {

    public class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new ArrayDeque<>();
            flattenHelper(nestedList);
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger temp = stack.peek();
                if (temp.isInteger())
                    return true;
                else
                    flattenHelper(stack.pop().getList());
            }
            return false;
        }

        public void flattenHelper(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
    }
}

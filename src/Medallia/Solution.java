package Medallia;

import java.util.Iterator;

/**
 * Created by i843719 on 11/26/14.
 */
public class Solution{
// list is updated whenever we call next()
    private int nextIndex;







    public static Iterator<String> flatten(final Iterator<Iterator<String>> iters) {

        return new Iterator<String>() {
            private Iterator<String> cur = null;
            private String nextString = getNextString();

            private String getNextString() {
                //edge case check
                if (iters == null && cur == null) throw new NullPointerException();
                // two condition: 1. iters has next 2. current iterator has next element
                while ((iters != null && iters.hasNext()) || (cur != null && cur.hasNext())) {
                    if ((cur == null || !cur.hasNext())) {
                        if (iters != null && iters.hasNext())
                            cur = iters.next();
                    }
                    // if the iterators has a iterator which does not contains anything, skip
                    if (cur == null) continue;

                    while (cur.hasNext()) {
                        String result = cur.next();
                        if (result != null) return result;
                    }
                }

                return null;
            }

            public boolean hasNext() {
                return nextString != null;
            }

            public String next() {
                if (!hasNext())
                    throw new NullPointerException();

                String oldItem = nextString;
                nextString = getNextString();
                return oldItem;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


}

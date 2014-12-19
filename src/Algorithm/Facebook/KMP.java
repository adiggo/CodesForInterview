package Algorithm.Facebook;

/**
 * Created by i843719 on 11/10/14.
 */
public class KMP {
    //two steps
    //the first is pre-precessing
    // the second is search

    public int[] prePrecessPattern(char[] ptrn) {
        int i = 0, j = -1;
        int ptrnLen = ptrn.length;
        int[] b = new int[ptrnLen + 1];
        // i definitely is the index
        // j the value to each index
        b[i] = j;
        while (i < ptrnLen) {
            while (j >= 0 && ptrn[i] != ptrn[j]) {
                j = b[j];// if current one is not equal
                // j is always 0, if no match found
            }
            i++;
            j++;
            b[i] = j;
        }
        return b;
    }

    public void searchSubstring(char[] text, char[] ptrn) {
        int i = 0, j = 0;
        int ptrnLen = ptrn.length;
        int textLen = text.length;
        int[] b = prePrecessPattern(ptrn);
        while (i < textLen) {
            while (j >= 0 && text[i] != ptrn[j]) {
                j = b[j];
            }
            i++;
            j++;
            if (j == ptrnLen) {
                j = b[j];
                System.out.println("found a substring");
            }
        }
    }

    static int maxRounds(String s, String t) {
        if (t.length() > s.length())
            return 0;
        int res = 0;
        int length1 = t.length();

        StringBuilder sb = new StringBuilder(s);
        int prevSize = s.length();
        while (sb.length() >= length1) {
            int i = 0;
            if (prevSize == sb.length())
                break;
            while (i <= sb.length() - length1) {
                boolean isSubstring = true;
                int breakIndex = 0;
                for (int j = 0; j < length1; j++) {
                    if (sb.charAt(i + j) != t.charAt(j)) {
                        isSubstring = false;
                        breakIndex = i + j;
                        break;
                    } else {
                        continue;
                    }
                }
                if (isSubstring == true) {
                    sb.delete(i, i + length1);
                    res++;
                    i += length1;
                } else {
                    i = breakIndex;
                }
            }
        }
        return res;

    }

    public static void main(String[] atgs){
        String s= "aabb";
        String t = "ab";
        System.out.println(maxRounds(s, t));
    }

}

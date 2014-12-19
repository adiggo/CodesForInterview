import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        List<String> data = new ArrayList<String>();
//        data.add("s");
//        data.add("d");
//        Solution s = new Solution();
//        int[] A = new int[5];
//        Arrays.fill(A, 1);
//        List<List<Integer>> res = s.combinationSum(A, 5);
//        System.out.println(res.size());


//        PowerSet s1 = new PowerSet();
//        int[] newdata = new int[3];
//        for (int i = 0; i < 3; i++){
//            newdata[i] = i;
//        }
//        List<List<Integer>> res1 = s1.getPowerSetByBitManipulation(newdata);
//        System.out.println(res1.size());
//        for (int i = 0; i < res1.size(); i ++){



//        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++){
//            String str = br.readLine();
//            String[] strArr = str.split(" ");
//            int a = Integer.parseInt(strArr[0]);
//            //int b = Integer.parseInt(strArr[1]);
//            String str2 = br.readLine();
//            String[] arr2 = str2.split(" ");
//            if (isEven(arr2, a))
//                System.out.println("EVEN");
//            else
//                System.out.println("ODD");
//        }




        String s= "aabb";
        String t = "ab";
        System.out.println(maxRounds(s, t));
    }


    static int maxRounds(String s, String t) {
        if (t.length() > s.length())
            return 0;
        int res = 0;
        int length1 = t.length();

        StringBuilder sb = new StringBuilder(s);
        int prevSize = 0;

        while (sb.length() >= length1) {  //4 > 2
            int i = 0;
            if (prevSize == sb.length())
                break;
            prevSize = sb.length();
            while (i <= sb.length() - length1) {
                boolean isSubstring = true;
                int breakIndex = 0;
                for (int j = 0; j < length1; j++) {
                    if (sb.charAt(i + j) != t.charAt(j)) {
                        isSubstring = false;

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
                    i++;
                }
            }
        }
        return res;
    }


}

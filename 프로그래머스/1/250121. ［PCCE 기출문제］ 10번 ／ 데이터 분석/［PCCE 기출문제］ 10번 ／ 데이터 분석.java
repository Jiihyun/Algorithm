import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int val = -1;
        int sort = -1;
        
        if (ext.equals("code")) {
            val = 0;
        } else if (ext.equals("date")) {
            val = 1;
        } else if (ext.equals("maximum")) {
            val = 2;
        } else if (ext.equals("remain")) {
            val = 3;
        }
        for (int i = 0; i <data.length; i++) {
            if (data[i][val] < val_ext) {
                list.add(data[i]);
            }
        }
        if (sort_by.equals("code")) {
            sort = 0;
        } else if (sort_by.equals("date")) {
            sort = 1;
        } else if (sort_by.equals("maximum")) {
            sort = 2;
        } else if (sort_by.equals("remain")) {
            sort = 3;
        }
        int sortIndex = sort;
        list.sort(Comparator.comparingInt(o -> o[sortIndex]));

        int[][] answer = new int[list.size()][4];
         for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
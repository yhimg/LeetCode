class Solution {
    public boolean isRobotBounded(String str) {
        
        int i = 0;
        int[][] dir = new int[][] {{0,1}, {-1,0}, {0, -1}, {1,0}};
        int x = 0;
        int y = 0;
        for(int s = 0; s<str.length(); s++){
            if(str.charAt(s) == 'L'){
                i = (i+1)%4;
            } else if(str.charAt(s) == 'R'){
                i = (i+3)%4;
            } else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        return x==0 && y==0 || i!=0;
    }
}
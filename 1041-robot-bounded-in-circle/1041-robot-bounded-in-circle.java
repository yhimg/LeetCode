class Solution {
    public boolean isRobotBounded(String instructions) {
        return solve(0, 0, instructions, 0, 1);
    }
    
    private boolean solve(int x, int y, String ins, int index, int direction){
        if(index == ins.length()){
            if(x == 0 && y == 0) return true;
            return (direction != 1);
            //return false;
        }
        boolean result = false;
        if(ins.charAt(index) == 'L'){
            direction -= 1;
            if(direction == 0)
                direction = 4;
            result = solve(x, y, ins, index+1, direction);
        }
        else if(ins.charAt(index) == 'R'){
            direction += 1;
            if(direction > 4)
                direction = 1;
            result = solve(x, y, ins, index+1, direction);
        } else{
            if(direction == 1)
                result = solve(x, y+1, ins, index+1, direction);
            else if(direction == 2)
                result = solve(x+1, y, ins, index+1, direction);
            else if(direction == 3)
                result = solve(x, y-1, ins, index+1, direction);
            else if(direction == 4)
                result = solve(x-1, y, ins, index+1, direction);
        }
        
        return result;
    }
}
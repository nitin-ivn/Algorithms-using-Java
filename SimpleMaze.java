import java.util.ArrayList;
import java.util.Arrays;

public class SimpleMaze {
    public static void main(String[] args) {
        System.out.println(noOfWays(3,3));
//        displayPath("",3,3);
//        System.out.println(displayPathArray("",3,3));
//        System.out.println(displayPathDiagonal("",3,3));
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };

        int[][] path = new int[maze.length][maze[0].length];
//        System.out.println(displayPathObstacles("",maze,0,0));
//        System.out.println(displayAllPath("",maze,0,0));
        displayAllPathPrint("",maze,0,0,path,1);
    }

    public static int noOfWays(int r,int c){
        if(r == 1 || c == 1){
            return 1;
        }
        return noOfWays(r-1,c)+noOfWays(r,c-1);
    }

    public static void displayPath(String p,int r,int c){
        if(r == 1 && c == 1){
            System.out.println(p);
        }

        if(r > 1){
            displayPath(p + 'D',r-1,c);
        }

        if(c > 1){
            displayPath(p + 'R',r,c-1);
        }
    }

    public static ArrayList<String> displayPathArray(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1){
            list.addAll(displayPathArray(p + 'D',r-1,c));
        }

        if(c > 1){
            list.addAll(displayPathArray(p + 'R',r,c-1));
        }

        return list;
    }

    public static ArrayList<String> displayPathDiagonal(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1){
            list.addAll(displayPathDiagonal(p + 'D',r-1,c));
        }

        if(c > 1){
            list.addAll(displayPathDiagonal(p + 'R',r,c-1));
        }

        if(r > 1 && c > 1){
            list.addAll(displayPathDiagonal(p+'Z',r-1,c-1));
        }

        return list;
    }

    public static ArrayList<String> displayPathObstacles(String p,boolean[][] maze, int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(!maze[r][c]){
            return new ArrayList<>();
        }

        if(r < maze.length - 1){
            list.addAll(displayPathObstacles(p + 'D',maze,r+1,c));
        }

        if(c < maze[0].length - 1){
            list.addAll(displayPathObstacles(p + 'R',maze,r,c+1));
        }

        if(r < maze.length - 1 && c < maze[0].length - 1){
            list.addAll(displayPathObstacles(p+'Z',maze,r+1,c+1));
        }

        return list;
    }

    public static ArrayList<String> displayAllPath(String p,boolean[][] maze, int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(!maze[r][c]){
            return new ArrayList<>();
        }

        maze[r][c] = false;

        if(r < maze.length-1){
            list.addAll(displayAllPath(p + 'D',maze,r+1,c));
        }

        if(c < maze[0].length - 1){
            list.addAll(displayAllPath(p + 'R',maze,r,c+1));
        }

        if(r > 0){
            list.addAll(displayAllPath(p+'U',maze,r-1,c));
        }

        if(c > 0){
            list.addAll(displayAllPath(p+'U',maze,r,c-1));
        }

        maze[r][c] = true;
        return list;
    }


    public static void displayAllPathPrint(String p,boolean[][] maze, int r, int c,int[][] path,int step){
        if(r == maze.length-1 && c == maze[0].length-1){
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if(r < maze.length-1){
            displayAllPathPrint(p + 'D',maze,r+1,c,path,step+1);
        }

        if(c < maze[0].length - 1){
            displayAllPathPrint(p + 'R',maze,r,c+1,path,step+1);
        }

        if(r > 0){
            displayAllPathPrint(p+'U',maze,r-1,c,path,step+1);
        }

        if(c > 0){
            displayAllPathPrint(p+'U',maze,r,c-1,path,step+1);
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}

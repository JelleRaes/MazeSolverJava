package amazed;

import java.util.List;

public class Search {
    
    public static boolean searchPath(char[][] maze, int x, int y
            , List<Integer> path) {
        
        if (maze[y][x] == 'E') {
            path.add(x);
            path.add(y);
            return true;
        }
        
        if (maze[y][x] == ' ') {
            maze[y][x] = '*';
            
            int dx = -1;
            int dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 1;
            dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
    
}
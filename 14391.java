import java.util.*;
 
public class Main {
    static int n,m;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new int[n][m];
        for(int i=0;i<n;i++) {
            String t = sc.next();
            for(int j=0;j<m;j++)
                arr[i][j] = t.charAt(j)-'0';
        }
        solve(0,0);
        System.out.println(result);
    }
    
    private static void check() {
        int sum=0;
        for(int i=0;i<n;i++) {
            int tSum=0;
            for(int j=0;j<m;j++) {
                if(visited[i][j]==1) {
                    tSum*=10; 
                    tSum+=arr[i][j];
                }else {
                    sum+=tSum;
                    tSum=0;
                }
            }
            sum+=tSum;
        }
        for(int i=0;i<m;i++) {
            int tSum=0;
            for(int j=0;j<n;j++) {
                if(visited[j][i]==0) {
                    tSum*=10; 
                    tSum+=arr[j][i];
                }else {
                    sum+=tSum;
                    tSum=0; 
                }
            }
            sum+=tSum;
        }
        result = Math.max(result, sum);
    }
    
    static int result;
    static int[][] visited;
    private static void solve(int x,int y) {
        if(x>=n) {
            // °Ë»ç
            check();
            return;
        }
        if(y>=m) {
            solve(x+1,0);
            return;
        }
        visited[x][y]=1;
        solve(x, y+1);
        visited[x][y]=0;
        
        solve(x,y+1);
    }
}
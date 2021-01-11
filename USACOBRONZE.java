// Aditya Bilawar

import java.util.*;
import java.io.*;

public class USACOBRONZE {

    final public static int DISTANCE = 100;

	public static void main(String[] args) throws Exception {

        // Read in intervals.
		BufferedReader stdin = new BufferedReader(new FileReader("speeding.in"));
		StringTokenizer tok = new StringTokenizer(stdin.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());

        int[] limits = new int[DISTANCE];
        int mile = 0;

        // Go through each road segment, copying in the speed limit for each individual mile.
        for (int i=0; i<n; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int dist = Integer.parseInt(tok.nextToken());
            int speed = Integer.parseInt(tok.nextToken());
            for (int j=0; j<dist; j++)
                limits[mile++] = speed;
        }

        // Same for bessie.
        int[] bessie = new int[DISTANCE];
        mile = 0;
        for (int i=0; i<m; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int dist = Integer.parseInt(tok.nextToken());
            int speed = Integer.parseInt(tok.nextToken());
            for (int j=0; j<dist; j++)
                bessie[mile++] = speed;
        }

        // Get the maximum overage for any individual mile.
        int res = 0;
        for (int i=0; i<DISTANCE; i++)
            res = Math.max(res, bessie[i]-limits[i]);

		// Write the output.
		FileWriter fout = new FileWriter(new File("speeding.out"));
        fout.write(res+"\n");
		fout.close();
	}
}
package MathZone;

/*
De Morgans law : The complement of the union of two sets is the intersection of their complements 
and the complement of the intersection of two sets is the union of their complements.

P = P_a + P_b - P_overlap

ans=45
*/
public class RectangleArea {

	public static void main(String[] args) {
		int ax1 = -3;
		int ay1 = 0;
		int ax2 = 3;
		int ay2 = 4;
		int bx1 = 0;
		int by1 = -1;
		int bx2 = 9;
		int by2 = 2;

		int xOverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
		int yOverlap = Math.min(ay2, by2) - Math.max(ay1, by1);
		int P_overlap = 0;
		if (xOverlap > 0 && yOverlap > 0)
			P_overlap = xOverlap * yOverlap;
		
		int area1=(ax2 - ax1) * (ay2 - ay1);
		int area2=(bx2 - bx1) * (by2 - by1);
		int ans = area1 +area2  - P_overlap;

		System.out.println(ans);
	}

}

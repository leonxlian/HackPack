
public class LineSegIntersect {
	static class Point implements Comparable<Point>{
		public long x,y;
		public int segindex;
		public Point(long x, long y, int segindex) {
			this.x=x;this.y=y;this.segindex=segindex;
		}
		public int compareTo(Point e) {
			if(x==e.x) {
				return (int) (y-e.y);
			}else {
				return (int) (x-e.x);
			}
		}
	}
	static class Segment{
		public Point p, q;
		public int index;
		public Segment(Point p, Point q, int index) {
			this.p=p; this.q=q; this.index=index;
		}
		public static int product(Point p1, Point p2) {
			return sign(p1.x*p2.y-p1.y*p2.x);
		}
		public static int sign(long x) {
			if(x>0) {
				return 1;
			}else if(x<0) {
				return -1;
			}else {
				return 0;
			}
		}
		static Point sub(Point p1, Point p2) {
			return new Point(p1.x-p2.x, p1.y-p2.y,p1.segindex);
		}
		static boolean isIntersect(Segment s1, Segment s2) {
			Point p1=s1.p, q1=s1.q, p2=s2.p, q2=s2.q;
			return (product(sub(q2, p1),sub(q1, p1))*product(sub(q1,p1),sub(p2, p1))>=0)&&
				(product(sub(q1, p2),sub(q2, p2))*product(sub(q2,p2),sub(p1, p2))>=0);
		}
	}
}

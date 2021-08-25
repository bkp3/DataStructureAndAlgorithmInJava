package HashMapAndHeap;

import java.util.*;

/*
 o/p->
3 172 68
4 178 86
5 180 77
6 173 79
7 179 72
8 175 76
*/
public class ComparableDemo {

	static class Student implements Comparable<Student> {
		int rno;
		int ht;
		int wt;

		Student(int rno, int ht, int wt) {
			this.rno = rno;
			this.ht = ht;
			this.wt = wt;
		}

		@Override
		public int compareTo(Student o) {
			return this.rno - o.rno;
		}
	}

	public static void main(String[] args) {

		PriorityQueue<Student> pq = new PriorityQueue<>();

		pq.add(new Student(8, 175, 76));
		pq.add(new Student(4, 178, 86));
		pq.add(new Student(6, 173, 79));
		pq.add(new Student(7, 179, 72));
		pq.add(new Student(3, 172, 68));
		pq.add(new Student(5, 180, 77));

		while (!pq.isEmpty()) {
			Student st = pq.remove();
			System.out.println(st.rno + " " + st.ht + " " + st.wt);

		}

	}

}

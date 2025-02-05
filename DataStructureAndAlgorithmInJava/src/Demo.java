import java.util.*;

import GraphLevel1.TopologicalSortAlgorithm;

import java.io.*;
import java.text.DecimalFormat;

public class Demo {

	public static void main(String[] args) {
		int n=3;
		int a=1;
		int b=2;
		if(n==1) {
			System.out.println(1);
			return;
		}
		if(n==2) {
			System.out.println(2);
			return;
		}
		for(int i=3;i<=n;i++) {
			int tmp=a+b;
			a=b;
			b=tmp;
		}
		System.out.println(b);
		

		
	}

}


package com.learnbycoding.numberTheory;

import java.util.ArrayList;

public class QuickHullAlgos {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Point> QuickHull(Point[] points) {

		ArrayList<Point> convexHull = new ArrayList<QuickHullAlgos.Point>();

		ArrayList<Point> pointsList = new ArrayList<QuickHullAlgos.Point>();

		for (int i = 0; i < points.length; i++) {
			pointsList.add(points[i]);
		}

		Point A=null;
		Point B=null;
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;

		for (int i = 0; i < points.length; i++) {

			if (minX > pointsList.get(i).x) {
				minX = pointsList.get(i).x;
				A = pointsList.get(i);
			}

			if (maxX < pointsList.get(i).x) {
				maxX = pointsList.get(i).x;
				B = pointsList.get(i);
			}
		}
		
		convexHull.add(A);
		convexHull.add(B);
		pointsList.remove(A);
		pointsList.remove(B);
		
		ArrayList<Point> leftSet = new ArrayList<QuickHullAlgos.Point>();
		ArrayList<Point> rightSet = new ArrayList<QuickHullAlgos.Point>();
		
		
		for(int i=0; i<pointsList.size();i++){
			
			Point P= pointsList.get(i);
			if(pointLocation(A, B, P)==1)
				leftSet.add(P);
			
			if(pointLocation(A, B, P)==-1)
				rightSet.add(P);
		}
		hullSet(A, B, leftSet, convexHull);
		hullSet(B, A, rightSet, convexHull);
	
		return convexHull;
	}
	
	
	private static void hullSet(Point A, Point B, ArrayList<Point> set , ArrayList<Point> hull){
		
		int insertLocation = hull.indexOf(B);
		if(set.size()==0)
			return ;
		if(set.size()==1){
			Point P= set.get(0);
			set.remove(0);
			hull.add(insertLocation, P);
			return;
		}
		
		int dist=Integer.MIN_VALUE;
		int farthestPointIndex =-1;
		
		for(int i=0;i<set.size();i++){
			
			Point P= set.get(i);
			int pointDistance =  distance(A, B,P);
			if(dist < pointDistance)
			{
				dist= pointDistance;
				farthestPointIndex=i;
			}
		}
		
		Point P= set.get(farthestPointIndex);
		set.remove(farthestPointIndex);
        hull.add(insertLocation, P);
		
		ArrayList<Point> leftAP = new ArrayList<QuickHullAlgos.Point>();
		ArrayList<Point> leftPB = new ArrayList<QuickHullAlgos.Point>();
		
		for(int i=0;i<set.size();i++){
			
			Point C= set.get(i);
			if(pointLocation(A, P, C)==1)
				leftAP.add(C);
			
			else if(pointLocation(P, B, C)==1)
				leftPB.add(C);
		}
		
		hullSet(A, P, leftAP, hull);
		hullSet(P, B, leftPB, hull);
	}
	
	
	static int distance(Point A, Point B, Point P){
		
		int ABx= B.x- A.x;
		int ABy= B.y - A.x;
		int num = ABx * (A.y-P.y) - ABy *(A.x-P.x);
		
		num = num < 0 ? -num: num; 
		
		return num;
	}
	
	static int pointLocation(Point A, Point B , Point P){
		
		int cl= (B.x- A.x) * (P.y-A.y) - (B.y-A.y)* (P.x-A.x);
		if(cl > 0)
			return 1;
		else if(cl==0)
			return 0;
		else 
			return -1;
	}

	public static void main(String[] args) {

		Point points[] = { new Point(0, 3), new Point(1, 1), new Point(2, 2),
				new Point(4, 4), new Point(0, 0), new Point(1, 2),
				new Point(3, 1), new Point(3, 3) };

		ArrayList<Point> convexHullPoints = QuickHull(points);
		convexHullPoints.forEach((point)-> System.out.println(point.x + " " + point.y));
	}

}

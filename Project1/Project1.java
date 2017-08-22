import java.util.ArrayList;
import java.util.Collections;


/*
 * PROJECT I: Project1.java
 *
 * As in project 0, this file - and the others you downloaded - form a
 * template which should be modified to be fully functional.
 *
 * This file is the *last* file you should implement, as it depends on both
 * Point and Circle. Thus your tasks are to:
 *
 * 1) Make sure you have carefully read the project formulation. It contains
 *    the descriptions of all of the functions and variables below.
 * 2) Write the class Point.
 * 3) Write the class Circle
 * 4) Write this class, Project1. The Results() method will perform the tasks
 *    laid out in the project formulation.
 */


public class Project1 {
    // -----------------------------------------------------------------------
    // Do not modify the names of the variables below! This is where you will
    // store the results generated in the Results() function.
    // -----------------------------------------------------------------------
    public int    circleCounter; // Number of non-singular circles in the file.
    public int    posFirstLast;  // Indicates whether the first and last
    // circles overlap or not.
    public double maxArea;       // Area of the largest circle (by area).
    public double minArea;       // Area of the smallest circle (by area).
    public double averageArea;   // Average area of the circles.
    public double stdArea;       // Standard deviation of area of the circles.
    public double medArea;       // Median of the area.
    public int    stamp=189375;
    // -----------------------------------------------------------------------
    // You may implement - but *not* change the names or parameters of - the
    // functions below.
    // -----------------------------------------------------------------------

    /**
     * Default constructor for Project1. You should leave it empty.
     */
    public Project1() {
        // This method is complete.
    }

    /**
     * Results function. It should open the file called FileName (using
     * MaInput), and from it generate the statistics outlined in the project
     * formulation. These are then placed in the instance variables above.
     *
     * @param fileName  The name of the file containing the circle data.
     */
    public void results(String fileName){
        // You need to fill in this method.


        MaInput F1 = new MaInput("Project1.data");

        // Variables into which coordinates of points will be stored.
        double x, y, rad;

        // initial setup for max/min
        double maxrad = 0;
        double minrad = Double.MAX_VALUE;
        double maxx = 0;
        double minx = 0;
        double maxy = 0;
        double miny = 0;
        double firstx = 0;
        double firsty = 0;
        double firstrad = 0;
        double lastx = 0;
        double lasty = 0;
        double lastrad = 0;
        double sumofarea = 0;
        double sumofareasquared = 0;

        ArrayList<Double> radii = new
                ArrayList<Double>();


        // Counter for the number of entered points.
        int points = 0;


        // Read the file until the EOF (end-of-file) mark in the file is reached.
        while (!F1.atEOF()) {
            // Read the coordinates from one line in the file. We know that
            // there are 3 numbers on a line so the following commands read
            // all data on a line.
            x = F1.readDouble();
            y = F1.readDouble();
            rad = F1.readDouble();

            sumofarea = sumofarea + 3.141592653589*Math.pow(rad,2);
            sumofareasquared = sumofareasquared + Math.pow(3.141592653589*Math.pow(rad,2),2);
            radii.add(rad);

            // Count the points entered.
            points++;

            // Find max, min for x and y coords
            if (rad > maxrad)
                maxrad = rad;
                maxx = x;
                maxy = y;
            if (rad < minrad)
                minrad = rad;
                minx = x;
                miny = y;
            if (points == 1){
                firstx = x;
                firsty = y;
                firstrad = rad;
            }
            if (points == 1000) {
                lastx = x;
                lasty = y;
                lastrad = rad;
            }
        }

        Collections.sort(radii);

        double median_rad = 0;

        if ((radii.size() % 2) == 0){
            median_rad = 0.5*(radii.get(radii.size()/2 - 1) + radii.get(radii.size()/2));
        } else {
            median_rad = radii.get((radii.size()-1)/2) ;
        }

        Circle median_circle = new Circle(0,0,median_rad);


        Circle biggest_circle = new Circle(maxx, maxy, maxrad);
        Circle smallest_circle = new Circle(minx, miny, minrad);
        Circle first_circle = new Circle(firstx, firsty, firstrad);
        Circle last_circle = new Circle(lastx, lasty, lastrad);

        circleCounter = points;
        posFirstLast = last_circle.overlap(first_circle);
        maxArea = biggest_circle.area();
        minArea = smallest_circle.area();
        averageArea = sumofarea/(points);
        stdArea = Math.pow( sumofareasquared/(points)  - Math.pow(averageArea,2) , 1/2);
        medArea = median_circle.area();

        System.out.println(circleCounter);
        System.out.println(posFirstLast);
        System.out.println(maxArea);
        System.out.println(minArea);
        System.out.println(averageArea);
        System.out.println(stdArea);
        System.out.println(medArea);
    }

    // =======================================================
    // Tester - tests methods defined in this class
    // =======================================================

    /**
     * Your tester function should go here (see week 14 lecture notes if
     * you're confused). It is not tested by BOSS, but you will receive extra
     * credit if it is implemented in a sensible fashion.
     */
    public static void main(String args[]){
        // You need to fill in this method.
        Project1 Answer = new Project1();
        Answer.results("Project1.data");
    }
}


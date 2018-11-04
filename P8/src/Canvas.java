//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Canvas.java
// Files:           AsciiArt.java, AsciiTest.java, Canvas.java, DrawingChange.
//                  java, DrawingStack.java, DrawingStackIterator.java
// Course:          CS300 Fall 2018
//
// Author:          Bryce Xu
// Email:           xxu373@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Jingcheng Wu
// Partner Email:   jwu446@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class Canvas {

    private final int width;  // width of the canvas
    private final int height; // height of the canvas

    private char [][] drawingArray; // 2D character array to store the drawing

    private final DrawingStack undoStack; // store previous changes for undo
    private final DrawingStack redoStack; // store undone changes for redo

    public Canvas(int width, int height)
    {
        this.width = width;
        this.height = height;
        drawingArray = new char[height][width];
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                drawingArray[i][j] = ' ';
            }
        }
        undoStack = new DrawingStack();
        redoStack = new DrawingStack();
    } // Constructor. Throws IllegalArgumentException if width or height is 0 or negative
    // A Canvas is initially blank (use the space ' ' character)

    public void draw(int row, int col, char c)
    {
        if ((row < 0 || row > height ) || (col < 0 || col > width))
        {
            throw new IllegalArgumentException("WARNING: the position is out of canvas!");
        }
        char old = drawingArray[row][col];
        DrawingChange drawingChange = new DrawingChange(row, col, old, c);
        undoStack.push(drawingChange);
        if (!redoStack.isEmpty())
            redoStack.pop();
        drawingArray[row][col] = c;
    } // Draw a character at the given position
    // This method should throw an IllegalArgumentException if the drawing position is outside the canvas
    // If that position is already marked with a different character, overwrite it.
    // After making a new change, add a matching DrawingChange to the undoStack so that we can undo if needed.
    // After making a new change, the redoStack should be empty.

    public boolean undo()
    {
        DrawingChange recentDrawingChange = undoStack.pop();
        draw(recentDrawingChange.x, recentDrawingChange.y, recentDrawingChange.prevChar);
        redoStack.push(recentDrawingChange);
        return true;
    } // Undo the most recent drawing change. Return true if successful. False otherwise.
    // An undone DrawingChange should be added to the redoStack so that we can redo if needed.

    public boolean redo()
    {
        DrawingChange recentUndoneDrawingChange = redoStack.pop();
        draw(recentUndoneDrawingChange.x, recentUndoneDrawingChange.y, recentUndoneDrawingChange.newChar);
        undoStack.push(recentUndoneDrawingChange);
        return true;
    } // Redo the most recent undone drawing change. Return true if successful. False otherwise.
    // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if needed.

    public String toString()
    {
        String stringCanvas = "";
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                stringCanvas += drawingArray[i][j];
            }
            if (i != width - 1)
                stringCanvas += System.lineSeparator();
        }
        return stringCanvas;
    } // Return a printable string version of the Canvas.
    /* Format example: [_ is blank. Use System.lineSeparator() to put a newline character between rows]
     * X___X
     * _X_X_
     * __X__
     * _X_X_
     * X___X
     */

    public void printDrawing()
    {
        System.out.print(this.toString());
    }

}

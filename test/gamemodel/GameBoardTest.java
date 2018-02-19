/*
 * Copyright (C) 2018 Lucas Burdell <lucasburdell@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gamemodel;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Burdell <lucasburdell@gmail.com>
 */
public class GameBoardTest {

    public GameBoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNumberOfMerges method, of class GameBoard.
     */
    @Test
    public void testGetNumberOfMerges() {
        System.out.println("getNumberOfMerges");
        GameController controller = new GameController();
        GameBoard instance = new GameBoard(GameController.GRID_SIZE);
        int expResult = 0;
        int result = instance.getNumberOfMerges();
        assertEquals(expResult, result);

        int[][] board = new int[][]{
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1}
        };

        instance = new GameBoard(board);
        GameBoard left = controller.moveGrid(instance, Direction.LEFT);
        GameBoard right = controller.moveGrid(instance, Direction.RIGHT);
        GameBoard up = controller.moveGrid(instance, Direction.UP);
        GameBoard down = controller.moveGrid(instance, Direction.DOWN);

        assertEquals(8, left.getNumberOfMerges());
        assertEquals(8, right.getNumberOfMerges());
        assertEquals(8, up.getNumberOfMerges());
        assertEquals(8, down.getNumberOfMerges());
    }

    /**
     * Test of setNumberOfMerges method, of class GameBoard.
     */
    @Test
    public void testSetNumberOfMerges() {
        System.out.println("setNumberOfMerges");
        int numberOfMerges = 0;
        GameBoard instance = new GameBoard(16);
        instance.setNumberOfMerges(numberOfMerges);
        assertEquals(numberOfMerges, instance.getNumberOfMerges());
    }

    /**
     * Test of getMergeGridPosition method, of class GameBoard.
     */
    @Test
    public void testGetMergeGridPosition() {
        System.out.println("getMergeGridPosition");
        int x = 0;
        int y = 0;
        GameBoard instance = new GameBoard(16);
        boolean expResult = false;
        boolean result = instance.getMergeGridPosition(x, y);
        assertEquals(expResult, result);

        int[][] board = new int[][]{
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1}
        };

        instance = new GameBoard(board);
        GameController controller = new GameController();
        GameBoard left = controller.moveGrid(instance, Direction.LEFT);
        GameBoard right = controller.moveGrid(instance, Direction.RIGHT);
        GameBoard up = controller.moveGrid(instance, Direction.UP);
        GameBoard down = controller.moveGrid(instance, Direction.DOWN);

        assertEquals(true, left.getMergeGridPosition(x, y));
        assertEquals(true, right.getMergeGridPosition(x, y));
        assertEquals(true, up.getMergeGridPosition(x, y));
        assertEquals(true, down.getMergeGridPosition(x, y));

    }

    /**
     * Test of setMergeGridPosition method, of class GameBoard.
     */
    @Test
    public void testSetMergeGridPosition() {
        System.out.println("setMergeGridPosition");
        int x = 0;
        int y = 0;
        boolean value = true;
        GameBoard instance = new GameBoard(16);
        instance.setMergeGridPosition(x, y, value);
        assertEquals(value, instance.getMergeGridPosition(x, y));
    }

    /**
     * Test of getGameGrid method, of class GameBoard.
     */
    @Test
    public void testGetGameGrid() {
        System.out.println("getGameGrid");
        GameBoard instance = new GameBoard(16);
        int[][] expResult = new int[][]{
            new int[]{0, 0, 0, 0},
            new int[]{0, 0, 0, 0},
            new int[]{0, 0, 0, 0},
            new int[]{0, 0, 0, 0}
        };
        int[][] result = instance.getGameGrid();
        for (int y = 0; y < result.length; y++) {
            int[] row = result[y];
            for (int x = 0; x < row.length; x++) {
                int value = row[x];
                assertEquals(expResult[y][x], value);
            }
        }
    }

    /**
     * Test of setGameGrid method, of class GameBoard.
     */
    @Test
    public void testSetGameGrid() {
        System.out.println("setGameGrid");
        int[][] gameGrid = new int[][]{
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1},
            new int[]{1, 1, 1, 1}
        };
        GameBoard instance = new GameBoard(16);
        instance.setGameGrid(gameGrid);
        assertArrayEquals(gameGrid, instance.getGameGrid());
    }

    /**
     * Test of getEmptyPositions method, of class GameBoard.
     */
    @Test
    public void testGetEmptyPositions() {
        System.out.println("getEmptyPositions");
        GameBoard instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getEmptyPositions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStorageString method, of class GameBoard.
     */
    @Test
    public void testToStorageString() {
        System.out.println("toStorageString");
        GameBoard instance = null;
        String expResult = "";
        String result = instance.toStorageString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GameBoard.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GameBoard instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class GameBoard.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        GameBoard instance = null;
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class GameBoard.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        GameBoard instance = null;
        instance.setScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMoved method, of class GameBoard.
     */
    @Test
    public void testIsMoved() {
        System.out.println("isMoved");
        GameBoard instance = null;
        boolean expResult = false;
        boolean result = instance.isMoved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMoved method, of class GameBoard.
     */
    @Test
    public void testSetMoved() {
        System.out.println("setMoved");
        boolean moved = false;
        GameBoard instance = null;
        instance.setMoved(moved);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreviousMove method, of class GameBoard.
     */
    @Test
    public void testGetPreviousMove() {
        System.out.println("getPreviousMove");
        GameBoard instance = null;
        Direction expResult = null;
        Direction result = instance.getPreviousMove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreviousMove method, of class GameBoard.
     */
    @Test
    public void testSetPreviousMove() {
        System.out.println("setPreviousMove");
        Direction previousMove = null;
        GameBoard instance = null;
        instance.setPreviousMove(previousMove);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

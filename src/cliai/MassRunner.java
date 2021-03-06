package cliai;

import aidecision.AIDecider;
import aidecision.MajorityTieVoting;
import aidecision.MajorityVoting;
import aiheuristics.Heuristic;
import aiheuristics.HeuristicList;
import aisearch.DepthWeighting;
import aisearch.SingleThreadSearch;
import aisearch.SingleThreadSearch;
import aisearch.StateEvaluationType;
import gamemodel.Direction;
import gamemodel.GameBoard;
import gamemodel.GameController;
import java.util.Scanner;

/**
 * Run multiple games and compare results
 *
 * @author Lucas Burdell <lucasburdell@gmail.com>
 */
public class MassRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int gamesToPlay = input.nextInt();
        System.out.println();
        System.out.print("Enter max depth of search: ");
        int maxDepth = input.nextInt();
        int[] scoreResults = new int[gamesToPlay];
        GameController controller = new GameController();
        SingleThreadSearch searcher = new SingleThreadSearch(controller);
        searcher.setEvaluationType(StateEvaluationType.NEXT_STATES);
        searcher.setDepthWeightingType(DepthWeighting.NONE);
        //searcher.setEvaluateAfterstates(true);
        searcher.setMaximumDepth(maxDepth);
        Heuristic[] heuristics = HeuristicList.getHeuristics();
        AIDecider decider = new MajorityTieVoting(heuristics, 4, 6);
        //searcher.setDebugMessagesEnabled(true);
        GameBoard currentBoard = controller.createStartingGameboard();
        for (int i = 0; i < gamesToPlay; i++) {
            long moveCount = 0;
            long startTime = System.currentTimeMillis();
            double mean = 0;
            while (!controller.isGameOver(currentBoard)) {
                long moveStartTime = System.currentTimeMillis();
                int[] votes = searcher.getVotesOnDirections(currentBoard, heuristics);
                Direction decision = decider.evaluateVotes(votes);
                currentBoard = controller.doGameMove(currentBoard, decision);
                long moveDeltaTime = System.currentTimeMillis() - moveStartTime;
                //System.out.println("score: " + currentBoard.getScore());
                //System.out.println(currentBoard.getScore());
                //System.out.println(currentBoard);
                //System.out.println("Moved above board " + decision);
                mean = (moveDeltaTime + moveCount * mean) / (moveCount + 1);
                if (moveCount % 20L == 0) {
                    //System.out.println("moves made this game: " + moveCount);
                    //System.out.println("Current move time average: " + mean);
                    
                }
                moveCount++;
                
            }
            long endTime = System.currentTimeMillis();
            scoreResults[i] = currentBoard.getScore();
            System.out.println("final score: " + currentBoard.getScore());
            currentBoard = controller.createStartingGameboard();
            System.out.println("game " + i + " complete");
            System.out.println("game took: " + (endTime - startTime) / 1000.0 + " seconds");
            //System.out.println("Did " + moveCount + " moves");
            
        }
        System.out.println("Mean: " + getMean(scoreResults));
        System.out.println("Standard Deviation: " + getStandardDeviation(scoreResults));

    }

    private static long getMean(int[] scoreResults) {
        long output = 0;
        for (int i = 0; i < scoreResults.length; i++) {
            int scoreResult = scoreResults[i];
            output += scoreResult;
        }
        return output / (long) scoreResults.length;
    }
    
    private static double getStandardDeviation(int[] scoreResults) {
        long mean = getMean(scoreResults);
        double[] standardResults = new double[scoreResults.length];
        for (int i = 0; i < scoreResults.length; i++) {
            standardResults[i] =  Math.pow((scoreResults[i] - mean), 2);
        }
        double output = 0;
        for (int i = 0; i < standardResults.length; i++) {
            double standardResult = standardResults[i];
            output += standardResult;
        }
        return Math.sqrt(output / standardResults.length);
    }
}

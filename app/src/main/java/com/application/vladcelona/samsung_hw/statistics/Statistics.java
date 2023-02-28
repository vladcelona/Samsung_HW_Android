package com.application.vladcelona.samsung_hw.statistics;

import android.annotation.SuppressLint;

public class Statistics {

    private static int gameScore = 0;
    private static int loseCount = 0;
    private static int drawCount = 0;
    private static int winCount = 0;
    private static int maxPacmanScore = 0;
    private static int previousPacmanScore = 0;
    private static int pacmanGamesPlayed = 0;

    public void updateScore(int gameCode) {
        gameScore += gameCode;
        if (gameCode == 0) { loseCount++; }
        else if (gameCode == 1) { drawCount++; }
        else { winCount++; }
    }

    public void updatePacman(int score) {
        maxPacmanScore = Math.max(maxPacmanScore, score);
        previousPacmanScore = score; pacmanGamesPlayed++;
    }

    public CharSequence info() {
        @SuppressLint("DefaultLocale") String message = String.format(
                "Overall games played: %d\nGames lost: %d\n" +
                "Games ended with draw: %d\nGames won: %d\n\nYour game score: %d\n\n" +
                "Pacman stats:\nPacman games played: %d\nMax score: %d\nPrevious score: %d\n",
                (loseCount + drawCount + winCount + pacmanGamesPlayed),
                loseCount, drawCount, winCount, gameScore,
                pacmanGamesPlayed, maxPacmanScore, previousPacmanScore);

        return message;
    }
}
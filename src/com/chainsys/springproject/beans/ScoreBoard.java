package com.chainsys.springproject.beans;

public class ScoreBoard {
	public int targetScore;
	private ScoreBoard() {
		System.out.println("scoreboard object created");
	}
	private ScoreBoard(int runs)
	{
		targetScore=runs;
		System.out.println("scoreboard object created");
	}
	//factory method -the methods are static here
	public static ScoreBoard createObject()
	{
		return new ScoreBoard();
	}
	public static ScoreBoard createObject(int runs)
	{
		return new ScoreBoard(runs);
	}
}



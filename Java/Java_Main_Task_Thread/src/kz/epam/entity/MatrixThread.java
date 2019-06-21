package kz.epam.entity;

import kz.epam.validator.MatrixThreadValidator;


public class MatrixThread implements Runnable {
	private int numberOfThread = -1; // default value

	public MatrixThread(int numberOfThread) {
		if (MatrixThreadValidator.validateNumberOfThread(numberOfThread)) {
			this.numberOfThread = numberOfThread;
		}
	}

	@Override
	public void run() {
		System.out.println("Thread-->" + numberOfThread + " started to work");
		MatrixSingleton.getInstance().changeDiagonal(this);
		System.out.println("Thread-->" + numberOfThread + " ended to work");
	}

	public int getNumberOfThread() {
		return numberOfThread;
	}
}

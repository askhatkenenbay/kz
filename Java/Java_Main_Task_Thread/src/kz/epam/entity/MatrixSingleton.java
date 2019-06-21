package kz.epam.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixSingleton {
	private static MatrixSingleton singleInstance;
	private static final ReentrantLock lock = new ReentrantLock(true);
	private static AtomicBoolean createdMatrix = new AtomicBoolean(false);
	private static final ReentrantLock lockMatrix = new ReentrantLock(true);
	private static boolean started = false;
	private final Set<Integer> set = new HashSet<>();
	private int leftElements;
	private int numberOfThreads;
	private final int[][] singleMatrix;

	private MatrixSingleton() {
		MatrixFileCreator fileOne = new MatrixFileCreator("FileTwo");
		fileOne.writeMatrix();
		MatrixRead matrixRead = new MatrixRead(fileOne.getFileName());
		singleMatrix = matrixRead.getMatrix();
		leftElements = singleMatrix.length;
		instantiateSet();
	}

	public static MatrixSingleton getInstance() {
		if (!createdMatrix.get()) {
			lock.lock();
			try {
				if (singleInstance == null) {
					singleInstance = new MatrixSingleton();
					createdMatrix.set(true);
				}
			} finally {
				lock.unlock();
			}
		}
		return singleInstance;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < singleMatrix.length; i++) {
			for (int j = 0; j < singleMatrix[0].length; j++) {
				result.append(singleMatrix[i][j]);
				result.append("\t");
			}
			result.append("\n");
		}
		return result.toString();
	}


	public void changeDiagonal(MatrixThread thread) {
		if (!started) {
			changeDiagonal();
		}
		lockMatrix.lock();

		try {
			int numChosen;
			if (numberOfThreads != 1) {
				int max = leftElements - numberOfThreads + 1;
				numChosen = (new Random().nextInt(max)) + 1;
				leftElements = leftElements - numChosen;
				numberOfThreads--;
			} else {
				numChosen = leftElements;
			}

			while (numChosen != 0) {
				int temp = (new Random().nextInt(singleMatrix.length + 1));
				if (set.contains(temp)) {
					set.remove(temp);
					singleMatrix[temp][temp] = thread.getNumberOfThread();
					System.out.println("Thread " + thread.getNumberOfThread() + "changed matrix at place" +
							"[" + temp + "]" + "[" + temp + "]");
					numChosen--;
				}
			}
		} finally {
			lockMatrix.unlock();
		}
	}

	public void changeDiagonal() {
		started = true;
		numberOfThreads = (int) (Math.random() * ((6 - 4) + 1)) + 4;
		System.out.println("Number of threads is: " + numberOfThreads + "\n");
		Thread[] threads = new Thread[numberOfThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new MatrixThread((int) (Math.random() * ((999 - 100) + 1)) + 100));
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void instantiateSet() {
		for (int i = 0; i < singleMatrix.length; i++) {
			set.add(i);
		}
	}
}

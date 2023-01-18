import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import weka.core.Instance;
import weka.core.Instances;

public class Main {

	public static void main(String[] args) {

		Point[] redPoints = { new Point(50, 50), new Point(100, 50) };
		Point[] bluePoints = { new Point(300, 300), new Point(300, 150) };
		// CoordinateSystem cs = new CoordinateSystem(redPoints, bluePoints);
		// Point[] redPoints;
		// Point[] bluePoints;
		CoordinateSystem cs = new CoordinateSystem(redPoints, bluePoints);

		// CreateDataset.createDataset();
		Instances data = ReadDataset.readDataset();
		LinearSVM ls = new LinearSVM();

		int[] labels = new int[data.numInstances()];
		for (int i = 0; i < data.numInstances(); i++) {
			if (data.instance(i).value(0) >= 5 && data.instance(i).value(1) >= 4) {
				labels[i] = 1;

				System.out.println(i + " ripe");
			} else {
				labels[i] = -1;

				System.out.println(i + "unripe");
			}
			// System.out.println("i: " + labels[i]);

		}

		// 1 is passed and -1 is failed
		// data is students scores, labels are whether they passed or failed.

		double[] weights = ls.train(data, labels);

		/*
		 * double[] testData = { 40, 45 }; int prediction = ls.predict(testData,
		 * weights);
		 * 
		 * System.out.println("Predicted label: " + prediction); // 1 means passed, -1
		 * means failed.
		 */

		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(cs);
		frame.setVisible(true);

		Instance testInstance = data.instance(0);
		testInstance.setValue(0, 4);
		testInstance.setValue(1, 5);
		int prediction = ls.predict(testInstance, weights);
		System.out.println("Predicted label: " + prediction);

	}
}
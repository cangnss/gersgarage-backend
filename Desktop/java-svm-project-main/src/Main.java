import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.midi.Soundbank;
import javax.swing.JFrame;

import weka.core.Instance;
import weka.core.Instances;

public class Main {

	public static void main(String[] args) {
		// CreateDataset.createDataset();
		Instances data = ReadDataset.readDataset();
		LinearSVM ls = new LinearSVM();

		int[] labels = new int[data.numInstances()];
		for (int i = 0; i < data.numInstances(); i++) {
			if (data.instance(i).value(0) >= 5 && data.instance(i).value(1) >= 4) {
				labels[i] = 1;
				System.out.println("x value: " + data.instance(i).value(0) + " y value: " + data.instance(i).value(1) + " RIPE");
			} else {
				labels[i] = -1;
				System.out.println("x value: " + data.instance(i).value(0) + " y value: " + data.instance(i).value(1) + " UNRIPE");

			}
			// System.out.println("i: " + labels[i]);
		}

		double[] weights = ls.train(data, labels);

		double[][] dataArr = new double[data.numInstances()][2];
		for (int i = 0; i < data.numInstances(); i++) {

			dataArr[i][0] = data.instance(i).value(0);
			dataArr[i][1] = data.instance(i).value(1);

		}
		
	
		Instance testInstance = data.instance(0);
		testInstance.setValue(0, 4);
		testInstance.setValue(1, 5);
		int prediction = ls.predict(testInstance, weights);
		System.out.println("Predicted label: " + prediction);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Plot.plotData(dataArr);
			}
		});

	}

}

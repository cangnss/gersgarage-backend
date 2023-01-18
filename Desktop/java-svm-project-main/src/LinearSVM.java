import java.util.Arrays;

import weka.core.Instance;
import weka.core.Instances;

public class LinearSVM {
	public static double[] train(Instances data, int[] labels) {
		int n = data.numAttributes();
		double[] weights = new double[n];
		Arrays.fill(weights, 0);

		double learningRate = 0.1;
		int maxIterations = 100;

		for (int iter = 0; iter < maxIterations; iter++) {
			for (int i = 0; i < data.numInstances(); i++) {
				Instance instance = data.instance(i);
				double prediction = predict(instance, weights);
				double error = labels[i] - prediction;
				for (int j = 0; j < n; j++) {
					weights[j] = weights[j] + learningRate * error * instance.value(j);
				}
			}
		}

		return weights;
	}

	public static int predict(Instance data, double[] weights) {
		double prediction = 0;
		for (int i = 0; i < data.numAttributes(); i++) {
			prediction += data.value(i) * weights[i];
		}
		return prediction > 0 ? 1 : -1;
	}
}

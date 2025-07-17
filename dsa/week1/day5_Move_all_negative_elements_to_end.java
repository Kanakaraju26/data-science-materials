package week1;

public class day5_Move_all_negative_elements_to_end {
    public void segregateElements(int[] arr) {
        // code here
        int posCount = 0, negCount = 0;
        for (int num : arr) {
            if (num >= 0) {
                posCount++;
            } else {
                negCount++;
            }
        }

        int[] positives = new int[posCount];
        int[] negatives = new int[negCount];

        int posIndex = 0, negIndex = 0;

        for (int num : arr) {
            if (num >= 0) {
                positives[posIndex++] = num;
            } else {
                negatives[negIndex++] = num;
            }
        }

        int index = 0;
        for (int i = 0; i < posCount; i++) {
            arr[index++] = positives[i];
        }
        for (int i = 0; i < negCount; i++) {
            arr[index++] = negatives[i];
        }

    }
}
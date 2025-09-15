package week13;

public class day91_Middle_of_Three {
    int middle(int a, int b, int c) {
        // code here
        return a>b
            ? c>a ? a : b>c ? b:c
            : a>c ? a : c>b ? b:c; 
    }
}

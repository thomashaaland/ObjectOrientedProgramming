class VariabelBytte {
    public static void main(String[] args) {
	int x = 3;
	int y = 4;
	int[] result = variabelBytte(x,y);
	x = result[0];
	y = result[1];
	System.out.println(x + " " + y);
    }

    public static int[] variabelBytte(int a, int b) {
	int temp = a;
	a = b;
	b = temp;
	int[] list = {a, b};
	return list;
    }
}

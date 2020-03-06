class X {}
class Y extends X {}
class Z extends Y {}


class S {}
class G extends S {}
class Q extends B {}
class B extends S {}

class Kodeanalyse {
    public static void main(String[] args) {
	X x1 = (X) new Y();
	Y y1 = new Y();
	//Y y2 = new X();
	Y y3 = new Z();
	Z z1 = new Z();
	//Z z2 = (Z) new X();

	S q = new G();
	Q b = new Q();
	B s = new Q();
	B g = new B();
	S p = new B();

	System.out.println(q instanceof B);
	System.out.println(q instanceof G);
	
    }
}

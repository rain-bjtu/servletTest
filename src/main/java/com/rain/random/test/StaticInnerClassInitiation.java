package com.rain.random.test;

public class StaticInnerClassInitiation {
	public static void main(String[] args) {
		Outer o = new Outer();
		o.print();
		o.getInner();
	}
}

class Outer {
	static P p = new P("Outer static");
	public void print() {
		System.out.println("Outer");
	}
	private static class Inner {
		static final public P p = new P("Inner");
	}
	public P getInner() {
		return Inner.p;
	}
}

class P {
	public P(String s) {
		System.out.println(s);
	}
}

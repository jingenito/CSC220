/*
*	Joseph Ingenito
*	2/5/19
*	Lab02.jsh
*	Creates randomly positioned and randomly colored Ovals.
*/

/reset

/env --class-path doodlepad.jar

import java.util.Random;
import doodlepad.*;

Oval createOval(){

	Random rnd = new Random();
	
	double x, y, w, h;

	x = 400 * rnd.nextDouble();
	y = 400 * rnd.nextDouble();

	w = 300 * rnd.nextDouble() + 200;
	h = 300 * rnd.nextDouble() + 200;

	int r, g, b, a;
	r = rnd.nextInt(256);
	g = rnd.nextInt(256);
	b = rnd.nextInt(256);
	a = rnd.nextInt(256);

	Oval o = new Oval(x, y, w, h);
	o.setFillColor(r, g, b, a);
	return o;
}

Oval oval1 = createOval();
Oval oval2 = createOval();
Oval oval3 = createOval();
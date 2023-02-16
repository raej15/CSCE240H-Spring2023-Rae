/*
 * Rectangle.h
 *
 *  Created on: Feb 15, 2023
 *      Author: sarajones
 */

#ifndef RECTANGLE_H_
#define RECTANGLE_H_

#include "Shapes.cpp"
#include <string>

using namespace std;

class Rectangle: public Shapes {
public:
    double length;
    double breadth;

	Rectangle();
    Rectangle(double length, double breadth);
    double calcArea(Rectangle rectangle) {
        return rectangle.length * rectangle.breadth;
    }
	
};

#endif /* SHAPES_H_ */

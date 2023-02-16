/*
 * Shapes.h
 *
 *  Created on: Feb 15, 2023
 *      Author: sarajones
 */

#ifndef SHAPES_H_
#define SHAPES_H_

#include <string>

using namespace std;

class Shapes {
	double area;
	double perimeter;
    string errorMessage;
public:
	Shapes();
	double getArea() {
        return area;
    }

    double getPerimeter() {
        return perimeter;
    }

    string getErrorMessage() {
        return errorMessage;
    }
	
};

#endif /* SHAPES_H_ */

//============================================================================
// Name        : 240_HW3.cpp
// Author      : Rae Jones
// Version     :
// Copyright   : Your copyright notice
// Description : HW 1 -- CSCE 240, calculates from file
//============================================================================

#include <iostream>
#include <string>
#include <fstream>
#include "Shapes.cpp"
#include "Rectangle.cpp"

using namespace std;
int main() {

	//creates all variables needed to read file contents
	string operation = "add";

	string line;

	/*int num1 = 7;

	int num2 = 5;

	int final;

	//if statement handles different operations
	if (operation == "add") {
		final = num1 + num2;
	}

	else if (operation == "subtract") {
		final = num1 - num2;
	}

	else if(operation == "divide") {
		final = num1 / num2;
	}

	else {
		final = num1 * num2;
	}

	  std::cout << "The result of " << operation << " on " << num1 << " and " << num2 << " is below \n" << final;
      */

     Shapes B;
     Rectangle A;
     A.length = 5;
     A.breadth = 6;
     cout << A.calcArea(A) << endl;



	return 0;
}

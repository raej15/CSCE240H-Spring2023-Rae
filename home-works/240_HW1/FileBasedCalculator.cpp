//============================================================================
// Name        : 240_HW1.cpp
// Author      : Rae Jones
// Version     :
// Copyright   : Your copyright notice
// Description : HW 1 -- CSCE 240, calculates from file
//============================================================================

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main() {

	//creates all variables needed to read file contents
	string operation;

	string line;

	int num1;

	int num2;

	int final;

	//opens and reads file
	  ifstream myfile ("input.txt");
	  if (myfile.is_open())
	  {
	    getline (myfile,line);
	    operation = line;

	    getline (myfile,line);
	    num1 = stoi(line);

	    getline (myfile,line);
	    num2 = stoi(line);

	    myfile.close();
	  }

	  else cout << "Unable to open file";

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

	//outputs results of equation to file
	  ofstream fileOutput;
	  fileOutput.open ("output.txt");
	  fileOutput << "The result of " << operation << " on " << num1 << " and " << num2 << " is below \n" << final;


	return 0;
}

//============================================================================
// Name        : FactorialFun.cpp
// Author      : Rae Jones
// Version     :
// Copyright   : Your copyright notice
// Description : HW5
// Credit: Used info from https://www.programiz.com/cpp-programming/examples/factorial for factorials
// Credit: Used info from https://www.geeksforgeeks.org/measure-execution-time-function-cpp/ for time execution
//============================================================================

#include <algorithm>
#include <chrono>
#include <iostream>
#include<vector>
using namespace std;
using namespace std::chrono;

int getFactorial(int n) {
	int factorial = 1;
	for(int i = 1; i <= n; ++i) {
            factorial *= i;
    }
	return factorial;
}

int main() {
		int num,r;
		int factorial = 1;
		int choice = 0;
		int numF = 0;
		int numR = 0;
		int subCom = 0;
		int final = 0;
	    // Get starting timepoint
	    auto start = high_resolution_clock::now();

	    cout << "- - - - - - - - - - - - - - - - - - - - - - - - - \nProgram Starting" 
			<< "\n- - - - - - - - - - - - - - - - - - - - - - - - - \nWould you like to\n\t1. get only a factorial\n\t2. get C^N" << endl;
		cin >> choice;
		system("clear");

		if (choice == 1){
			cout << "Enter a positive whole number" << endl;
			cin >> num;
			numF = getFactorial(num);
			system("clear");
			cout << "- - - - - - - - - - - - - - - - - - - - - - - - - \nYour number: " << num << "\nYour factorial: " << numF << endl;
		}
		else {
			cout << "Enter 2 positive whole numbers separated by a space\n the first number must be bigger than the second" << endl;
			cin >> num >> r;
			numF = getFactorial(num);
			numR = getFactorial(r);
			subCom = getFactorial(num - r);
			final = (numF/(numR*subCom));
			system("clear");

			cout << "- - - - - - - - - - - - - - - - - - - - - - - - - \nYour N: " << num << "\nYour r: " << r <<"\nYour result: " << final << endl;

		}

		//cout << num <<endl;
		//cout << r <<endl;

	    // Get ending timepoint
	    auto stop = high_resolution_clock::now();

	    // Get duration. Substart timepoints to
	    // get duration. To cast it to proper unit
	    // use duration cast method
	    auto duration = duration_cast<microseconds>(stop - start);

	    cout << "\nProcessing Time: " << duration.count() << " microseconds" << "\n- - - - - - - - - - - - - - - - - - - - - - - - - " << endl;

	    return 0;
}

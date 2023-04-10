//============================================================================
// Name        : SortRandomN.cpp
// Author      : Rae Jones
// Version     :
// Copyright   : Your copyright notice
// Credit      : https://www.geeksforgeeks.org/bubble-sort/#
// Description : HW6
//============================================================================
#include <algorithm>
#include <chrono>
#include <iostream>
#include <vector>
using namespace std;
using namespace std::chrono;

//int arr[10];

void popArray(int n, int arr[])
{
    srand (time(NULL));
    int popArr[n];
    int i;

    for (i = 0; i < n - 1; i++) {
        popArr[i] = rand() % 100 + 1;
    }

    memmove( arr, popArr, sizeof(popArr) );
    //cout << popArr[9] << endl;
    //cout << arr[9] << endl;
}

void bubbleSort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n - 1; i++) {
 
        // Last i elements are already
        // in place
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
}
 
// Function to print an array
void printArray(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}
 
int main() {
        int userInput;
	    cout << "- - - - - - - - - - - - - - - - - - - - - - - - - \n\nWhat size would you like your array and vector to be?" << endl;
    
        cin >> userInput;

        if (userInput == 0) {
            cout << "\nPlease enter an integer next time\nEXITING PROGRAM";
            return 0;
        }

		//userInput = 100000;


        // Get vector starting timepoint
        auto startVector = high_resolution_clock::now();
        std::vector<int> v;

        v.resize(userInput);

        srand (time(NULL));
        for (int i = 0; i < v.size(); i++) {
            v[i] = rand() % 100 + 1;
        }

        sort(v.begin(), v.end());
    
        cout << "\nSorted Vector:\n"<< endl;
        for (auto x : v) {
            cout << x << " ";
        }

	    auto stopVector = high_resolution_clock::now();

        auto durationVector = duration_cast<microseconds>(stopVector - startVector);

        cout << "\n\n- - - - - - - - - - - - - - - - - - - - - - - - - \n\nMaking your array...\n\nMay take up to 30 seconds if its size is ~ 100,000" << endl;

	    // Get array starting timepoint
        auto startArray = high_resolution_clock::now();

		int arr[userInput];
        popArray(userInput, arr);
        int N = sizeof(arr) / sizeof(arr[0]);
        bubbleSort(arr, N);
        cout << "\n\n- - - - - - - - - - - - - - - - - - - - - - - - - \n\nSorted array:\n\n";
        printArray(arr, N);

        //stopping clock
	    auto stopArray = high_resolution_clock::now();

        //getting array time
	    auto durationArray = duration_cast<microseconds>(stopArray - startArray);

	    cout << "\n\n- - - - - - - - - - - - - - - - - - - - - - - - -\n\nArray Processing Time: " << durationArray.count() << " microseconds" << endl;
        cout << "\nVector Processing Time: " << durationVector.count() << " microseconds" << "\n\n- - - - - - - - - - - - - - - - - - - - - - - - - \nEXITING PROGRAM" << endl;

	    return 0;
}

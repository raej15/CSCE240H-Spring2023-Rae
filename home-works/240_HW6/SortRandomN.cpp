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
#include<vector>
using namespace std;
using namespace std::chrono;

int arr[10];

void popArray(int n)
{
    srand (time(NULL));
    int popArr[n];
    int i;

    for (i = 0; i < n - 1; i++) {
        popArr[i] = rand() % 10 + 1;
    }

    memmove( arr, popArr, sizeof(popArr) );
    cout << popArr[9] << endl;
    cout << arr[9] << endl;
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

	    // Get starting timepoint
	    auto start = high_resolution_clock::now();

	    cout << "- - - - - - - - - - - - - - - - - - - - - - - - - \nProgram Starting" << endl;
			
        popArray(1000);
		//int arr[] = { 5, 1, 4, 2, 8};
        int N = sizeof(arr) / sizeof(arr[0]);
        bubbleSort(arr, N);
        cout << "Sorted array: \n";
        printArray(arr, N);

	    auto stop = high_resolution_clock::now();


	    auto duration = duration_cast<microseconds>(stop - start);

	    cout << "\nProcessing Time: " << duration.count() << " microseconds" << "\n- - - - - - - - - - - - - - - - - - - - - - - - - \nEXITING PROGRAM" << endl;

	    return 0;
}

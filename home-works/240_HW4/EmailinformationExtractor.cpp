//============================================================================
// Name        : EmailinformationExtractor.cpp
// Author      : Rae Jones
// Version     :
// Copyright   : Your copyright notice
// Description : HW 4 -- CSCE 240, reads in email headers
// Sources: https://www.udacity.com/blog/2021/05/how-to-read-from-a-file-in-cpp.html
//============================================================================

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

class BaseEmailHeaderType
{
public:
	string name;
	int angles;

	string getname()
	{
		return name;
	}

	int getangles()
	{
		return angles;
	}

	virtual float getarea() = 0;  // Pure Virtual Function

};

class GmailHeaderType: public BaseEmailHeaderType
{
public:
	int length, width;

	float getarea()
	{
	return length * width;
	}
};

class OutlookHeaderType: public BaseEmailHeaderType
{
public:
	int radius;

	float getarea()
	{
		return 3.14 * radius * radius;
	}

};

int main()
{
	GmailHeaderType S;
	OutlookHeaderType C;

	S.name = " Gmail Header";

	C.name = " Outlook Header";


	cout <<"Then name of shape S is:"<<S.getname() << endl;

	cout<<"\n\n*****************************" << endl;

	cout <<"\n\nThen name of shape C is:"<<C.getname() << endl;

    std::ifstream myfile ("GmailHeader.txt");
    std::string mystring;
    std::string final;

    std::string myline;
    if ( myfile.is_open() ) {
        while ( myfile ) {
            std::getline (myfile, myline);
            //std::cout << myline <<'\n';
            final.append(myline + "\n");
        }
    }
    
    cout<<"\n\n*****************************" << endl;

    std::cout << final;
}
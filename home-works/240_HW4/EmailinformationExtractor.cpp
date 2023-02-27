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
#include <regex> 
#include<string.h>
#include <iterator> 
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

	C.name = "Outlook Header";


	std::cout <<"Then name of shape S is:"<<S.getname() << endl;

	std::cout<<"\n\n*****************************" << endl;

	std::cout <<"\n\nThen name of shape C is:"<<C.getname() << endl;

    std::ifstream myfile ("GmailHeader.txt");
    std::string final;
    std::string myline;

    if ( myfile.is_open() ) {
        while ( myfile ) {
            std::getline (myfile, myline);
            //std::cout << myline <<'\n';
            final.append(myline + "\n");
        }
    }
    
    std::cout<<"\n\n*****************************" << endl;

    std::cout << final;
   
    //string to be searched
    //string mystr = final; 
   
    // regex expression for pattern to be searched 
    regex regexp("To: .*"); 
   
    // flag type for determining the matching behavior (in this case on string objects)
     smatch m; 
   
    // regex_search that searches pattern regexp in the string mystr  
    regex_search(final, m, regexp); 
  
    cout<<"String that matches the pattern:"<<endl;
    string selectedFinal;

    for (auto x : m) 
        selectedFinal.append(x);;

    std::cout << selectedFinal;

    string shortFinal;

    regex regexp1("To: "); 

    regex_replace(back_inserter(shortFinal), selectedFinal.begin(), selectedFinal.end(), regexp1,  ""); 

    std::cout << "\n" << shortFinal;

    return 0; 
}
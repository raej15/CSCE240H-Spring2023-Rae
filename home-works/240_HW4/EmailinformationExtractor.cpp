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
private:
    //string to;
    //string from;

};

class GmailHeaderType: public BaseEmailHeaderType
{
private:
    string to;
    string from;
public:

    GmailHeaderType(string header) {
        string shortHeader;
        smatch m; 
        string selectedHeader;
        
        //To functionality
        regex regexp("To: .*"); 
        
        regex_search(header, m, regexp); 
    
        for (auto x : m) 
            selectedHeader.append(x);;

        regex regexp1("To: ");

        regex_replace(back_inserter(shortHeader), selectedHeader.begin(), selectedHeader.end(), regexp1,  ""); 

        to = shortHeader;

        //From functionality
        regex regexp3("From: .*"); 
        
        regex_search(header, m, regexp3); 
    
        shortHeader = "";
        selectedHeader = "";
        for (auto x : m) 
            selectedHeader.append(x);;

        regex regexp4("From: ");

        regex_replace(back_inserter(shortHeader), selectedHeader.begin(), selectedHeader.end(), regexp4,  ""); 

        from = shortHeader;

    }
    


    string getPart(string part) {

       if(part == "To") {
            return to;
       }
       else if (part == "From") {
        return from;
       }
       else {
        return "undefined";
       }

    }
    
};

class OutlookHeaderType: public BaseEmailHeaderType
{
public:
    string to;
    string from;

	OutlookHeaderType(string header) {
        string shortHeader;
        smatch m; 
        string selectedHeader;
        
        //To functionality
        regex regexp7("To: .*"); 
        
        regex_search(header, m, regexp7); 
    
        for (auto x : m) 
            selectedHeader.append(x);;

        regex regexp8("To: ");

        regex_replace(back_inserter(shortHeader), selectedHeader.begin(), selectedHeader.end(), regexp8,  ""); 

        to= shortHeader;

        //From functionality
        regex regexp3("From: .*"); 
        
        regex_search(header, m, regexp8); 
    
        shortHeader = "";
        selectedHeader = "";
        for (auto x : m) 
            selectedHeader.append(x);;

        regex regexp4("From: ");

        regex_replace(back_inserter(shortHeader), selectedHeader.begin(), selectedHeader.end(), regexp4,  ""); 

        from = shortHeader;
    }

    string getPartO(string part) {
        cout << "outlook working\n";

       if(part == "To") {
            return to;
       }
       else if (part == "From") {
        return from;
       }
       else {
        return "undefined";
       }

    }
    

};

int main()
{
    std::string gFinal;
    std::string oFinal;

   
   /*std::ifstream myfile ("GmailHeader.txt");
    std::string myline;

    if ( myfile.is_open() ) {
        while ( myfile ) {
            std::getline (myfile, myline);
            //std::cout << myline <<'\n';
            gFinal.append(myline + "\n");
        }
    }
    */
    
    std::ifstream myfile2 ("OutlookHeader.txt");
    std::string myline2;

    if ( myfile2.is_open() ) {
        while ( myfile2 ) {
            std::getline (myfile2, myline2);
            //std::cout << myline <<'\n';
            oFinal.append(myline2 + "\n");
        }
    }
    
    std::cout<<"\n\n*****************************" << endl;

    std::cout << gFinal;

    std::cout << oFinal;




    GmailHeaderType gHeader = GmailHeaderType(gFinal);
    OutlookHeaderType oHeader = OutlookHeaderType(oFinal);


    std::cout<<"\n\n*****************************" << endl;

    //std::cout << "\nfrom";
    //std::cout << "\n" << gHeader.getPart("From");

    //std::cout << "\nTo";
    std::cout << "\n" << gHeader.getPart("From");

    //std::cout << "\n" << oHeader.getPartO("To");

    return 0; 
}
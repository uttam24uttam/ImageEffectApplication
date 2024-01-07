#include "Sepia.h"
#include "../Pixel.h"
#include<bits/stdc++.h>

using namespace std;

void applySepia(vector<vector<Pixel>> &imageVector){
    for(auto &row: imageVector){
        for(auto &element: row){
            int dum1 = element.r;
            int dum2 = element.g;
            int dum3 = element.b;
            element.r = min(255,static_cast<int>((dum1 * .393) + (dum2 *.769) + (dum3 * .189)));
            element.g = min(255,static_cast<int>((dum1 * .349) + (dum2 *.686) + (dum3 * .168)));
            element.b = min(255,static_cast<int>((dum1 * .272) + (dum2 *.534) + (dum3 * .131)));
        }
    }
}